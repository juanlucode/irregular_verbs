package io.github.juanlucode.irregular_verbs.models;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.github.juanlucode.commons.ArrayTools;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Repository {

	private List<Verb> verbList = null;
	
	public Repository() {
		load();
	}
	
	/**
	 * Gets the repository size. Number of verbs.
	 */
	public int size() {
		return verbList.size();
	}
	
	/**
	 * Generates a questionary with a number of questions for a determinate level.
	 * The verbs are random selected.
	 * @param numQuestions
	 * @param level
	 * @return
	 */
	public Questionary generateQuestionary(byte numQuestions, Level level) {
		// list of index verb selected, used to avoid repetitions
		List<Verb> listSelected = new ArrayList<>();
		
		Random random = new Random();
		
		// selection verb counter
		Verb verbCandidate = null;
		
		for ( var i = 0; i < numQuestions; i++ ) {
			do {
				// select random verb in repository
				verbCandidate = verbList.get(random.nextInt(verbList.size()));
				// avoiding repetitions
			} while(listSelected.contains(verbCandidate));
			listSelected.add(verbCandidate);

		}
		
		// set questionary with array verbs and level of questions
		Questionary questionary = new Questionary( listSelected, level);
		
		// when translate field is null, we need to generate options
		// for test question
		for ( Question question : questionary.getQuestions() )
			if ( question.getVerbResponse().getTranslate() == null )
				this.generateTranslateOps(question);
		
		return questionary; 
	}
	
	private void generateTranslateOps(Question question) {
		// the correct opt put in last position
		String[] ops = {null, null, null, question.getVerbOrigin().getTranslate()};
		Random random = new Random();
		boolean ok = true;
		Verb randomVerb;
		for ( byte i = 0; i < 3; i++ ) {
			do {
				randomVerb = verbList.get(random.nextInt(verbList.size()));
				if ( randomVerb.equals(question.getVerbOrigin()) )
					ok = false;
				else
					if ( i > 0 )
						for (int j = i - 1; j >= 0;j--)
							if ( randomVerb.equals(ops[j]) ) {
								ok = false;
								break;
							}
			} while ( !ok );
			ops[i] = randomVerb.getTranslate();
		}
		// shuffle the array ops
		question.setTranslateOps(ArrayTools.shuffleArray(ops));
	}

	/**
	 * Load repository from a resources json file.
	 */
	private void load() {
		
		// https://mkyong.com/java/how-to-parse-json-with-gson/
        Gson gson = new Gson();

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("irregular_verbs.json").getFile());
        
        Type listType = new TypeToken<List<Verb>>() {}.getType();
        
        try (Reader reader = new FileReader(file)) {

            // Convert JSON File to List Java Object
            verbList = gson.fromJson(reader, listType);
        	
        	//Verb verb = gson.fromJson(reader, Verb.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

	}
}
