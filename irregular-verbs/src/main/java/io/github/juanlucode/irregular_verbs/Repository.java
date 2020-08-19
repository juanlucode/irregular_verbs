package io.github.juanlucode.irregular_verbs;

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
	
	public Questionary generateQuestionary(byte numQuestions, Level level) {
		// list of index verb selected, used to avoid repetitions
		List<Integer> listSelected = new ArrayList<Integer>();
		// array of verbs to generate questionary
		Verb[] verbs = new Verb[numQuestions];
		
		Random random = new Random();
		
		// selection verb counter
		int idxVerb = 0;
		
		for ( var i = 0; i < numQuestions; i++ ) {
			do {
				// select random verb in repository
				idxVerb = random.nextInt(verbList.size());
				// avoiding repetitions
			} while(listSelected.contains(idxVerb));
			listSelected.add(idxVerb);
			// include verb
			verbs[i] = verbList.get(idxVerb);
		}
		
		// set questionary with array verbs and level of questions
		Questionary questionary = new Questionary(verbs, level);
		
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
		int randomVerb;
		for ( byte i = 0; i < 3; i++ ) {
			do {
				randomVerb = random.nextInt(verbList.size());
				if (verbList.get(randomVerb).equals(question.getVerbOrigin()))
					ok = false;
				else
					if ( i > 0 )
						for (int j = i - 1; j >= 0;j--)
							if (ops[i] == ops[j]) ok = false;
			} while(ok);
			ops[i] = verbList.get(randomVerb).getTranslate();
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
