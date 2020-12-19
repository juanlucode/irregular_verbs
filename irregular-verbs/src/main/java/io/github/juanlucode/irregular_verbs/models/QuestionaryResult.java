package io.github.juanlucode.irregular_verbs.models;

public final class QuestionaryResult {
	
	private int totalVerbs;
	private int corrects;
	
	// getters and setters
	
	/**
	 * Provides the total number of verbs asked in the questionnaire.
	 * @return
	 */
	public int getTotalVerbs() {
		return totalVerbs;
	}

	/**
	 * Provides the total number of correct verbs
	 * @return
	 */
	public int getCorrects() {
		return corrects;
	}

	/**
	 * Provides the total number of wrong verbs
	 * @return
	 */
	public int getWrongs() {
		return this.totalVerbs - corrects;
	}
	
	/**
	 * Provides the total percent of correct verbs
	 * @return
	 */
	public float getPercent() {
		return getCoeficient() * 100;
	}
	
	public float getCoeficient() {
		return (float) this.corrects / this.totalVerbs;
	}
	
	/**
	 * Questionary Result Constructor
	 * @param total
	 * @param correct
	 */
	public QuestionaryResult(int total, int correct) {
		super();
		this.totalVerbs = total;
		this.corrects = correct;
	}
	
	
	
}
