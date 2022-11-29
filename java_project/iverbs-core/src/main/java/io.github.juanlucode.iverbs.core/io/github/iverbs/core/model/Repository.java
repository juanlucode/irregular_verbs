package io.github.iverbs.core.model;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import io.github.iverbs.commons.ArrayTools;
import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.enumeration.VerbForm;
import io.github.iverbs.core.model.value.QuestionVO;
import io.github.iverbs.core.model.value.QuestionaryVO;

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
	 * 
	 * @param numQuestions
	 * @param level
	 * @return
	 */
	public QuestionaryVO generateQuestionary(byte numQuestions, Level level) {
		// list of index verb selected, used to avoid repetitions
		List<Verb> listSelected = new ArrayList<>();

		Random random = new Random();

		// selection verb counter
		Verb verbCandidate = null;

		for (var i = 0; i < numQuestions; i++) {
			do {
				// select random verb in repository
				verbCandidate = verbList.get(random.nextInt(verbList.size()));
				// avoiding repetitions
			} while (listSelected.contains(verbCandidate));
			listSelected.add(verbCandidate);

		}

		// set questionaryVO with array verbs and level of questions
		QuestionaryVO questionaryVO = new QuestionaryVO(listSelected, level);

		// when translate field is null, we need to generate options
		// for test question
		for (QuestionVO questionVO : questionaryVO.getQuestions())
			if (questionVO.getVerbResponse().get(VerbForm.TRANSLATE) == null)
				this.generateTranslateOps(questionVO);

		return questionaryVO;
	}

	private void generateTranslateOps(QuestionVO questionVO) {
		// the correct opt put in last position
		String[] ops = { null, null, null, questionVO.getVerbOrigin().get(VerbForm.TRANSLATE) };
		Random random = new Random();
		boolean ok = true;
		Verb randomVerb;
		for (byte i = 0; i < 3; i++) {
			do {
				randomVerb = verbList.get(random.nextInt(verbList.size()));
				if (randomVerb.equals(questionVO.getVerbOrigin()))
					ok = false;
				else if (i > 0)
					for (int j = i - 1; j >= 0; j--)
						if (randomVerb.get(VerbForm.TRANSLATE).equals(ops[j])) {
							ok = false;
							break;
						}
			} while (!ok);
			ops[i] = randomVerb.get(VerbForm.TRANSLATE);
		}
		// shuffle the array ops
		questionVO.setTranslateOps(ArrayTools.shuffleArray(ops));
	}

	/**
	 * Load repository from a resources json file.
	 */
	private void load() {

		// https://mkyong.com/java/how-to-parse-json-with-gson/
		Gson gson = new Gson();

		//ClassLoader classLoader = getClass().getClassLoader();
		
		Module module = getClass().getModule();

		// try (InputStream inputStream =
		// classLoader.getResourceAsStream("repo/irregular_verbs.json")){
		// try (InputStream inputStream = module.getResourceAsStream("repo/irregular_verbs.json")) {
		try (InputStream inputStream = new FileInputStream("core/repo/irregular_verbs.json")) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			Type listType = new TypeToken<List<Verb>>() {
			}.getType();
			// Convert JSON File to List Java Object
			verbList = gson.fromJson(reader, listType);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
