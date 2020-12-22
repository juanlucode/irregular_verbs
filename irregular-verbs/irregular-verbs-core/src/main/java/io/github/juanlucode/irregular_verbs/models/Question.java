package io.github.juanlucode.irregular_verbs.models;

import java.util.Arrays;

import io.github.juanlucode.commons.ArrayTools;

/**
 * Describes a question.
 * @author juanlucode
 *
 */
public class Question {

	private Verb verbOrigin;
	private Verb verbResponse;
	private Level level;
	private Boolean[] flags = {false,false,false,false};
	private String[] translateOps = null;

	/**
	 * Get the origin verb of the question
	 * @return
	 */
	public Verb getVerbOrigin() {
		return this.verbOrigin;
	}
	
	/**
	 * Get the incomplete verb the user must complete
	 * @return
	 */
	public Verb getVerbResponse() {
		return this.verbResponse;
	}

	/**
	 * Set the incomplete verb the user must complete
	 * @return
	 */
	void setVerbResponse(Verb verbResponse) {
		this.verbResponse = verbResponse;
	}
	
	/**
	 * Get flags of the question
	 * Flags indicate which form of verbs are asked in the question.
	 * True - user must complete
	 * False - show in the question
	 * @return
	 */
	public Boolean[] getFlags() {
		return this.flags;
	}

	/**
	 * Set flags of the question
	 * Flags indicate which form of verbs are asked in the question.
	 * True - user must complete
	 * False - show in the question
	 * @return
	 */
	public void setFlags(Boolean[] _flags) {
		this.flags = _flags;
	}
	
	/**
	 * Get the options for the translate question.
	 * The translate form of the verb have a test question format with 4 possible options.
	 * @return
	 */
	public String[] getTranslateOps() {
		return this.translateOps;
	}
	
	/**
	 * Set the options for the translate question.
	 * The translate form of the verb have a test question format with 4 possible options.
	 * @return
	 */	
	void setTranslateOps(String[] ops) {
		this.translateOps = ops;
	}

	/**
	 * Indicate if the question is correct
	 * @return
	 */
	boolean isCorrect() {
		return verbOrigin.equals(verbResponse);
	}

	/**
	 * Question construct
	 * @param _verb Original verb to make a question
	 * @param _level Level of the question (amount of forms hidden)
	 */
	public Question(Verb _verb, Level _level) {
		this.verbOrigin = _verb;
		this.level = _level;
		this.generateQuestion();
	}

	/**
	 * Generate a question from a verb hidding forms depending of level.
	 */	
	private void generateQuestion() {
		// define the forms of verb which are visible at ramdom
		
		for (int i = 0; i <= this.level.ordinal(); i++)
			flags[i] = true;
		
		// mix the array
		flags = ArrayTools.shuffleArray(flags);
		
		// return new incomplete verb
		this.verbResponse = new Verb(
							 	flags[0]?null:verbOrigin.get(VerbForm.INFINITIVE),
							 	flags[1]?null:verbOrigin.get(VerbForm.PAST),
							 	flags[2]?null:verbOrigin.get(VerbForm.PARTICIPLE),
							 	flags[3]?null:verbOrigin.get(VerbForm.TRANSLATE)
							);
		
	}
	
	@Override
	public String toString() {
		return "Question [verbOrigin=" + verbOrigin + ", verbResponse=" + verbResponse + ", translateOps="
				+ Arrays.toString(translateOps) + "]";
	}
}
