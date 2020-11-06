package io.github.juanlucode.irregular_verbs.models;

import java.util.Arrays;

public class Question {

	private Verb verbOrigin;
	private Verb verbResponse;
	private String[] translateOps = null;

	Verb getVerbOrigin() {
		return this.verbOrigin;
	}
	
	public Verb getVerbResponse() {
		return this.verbResponse;
	}

	void setVerbResponse(Verb verbResponse) {
		this.verbResponse = verbResponse;
	}
	
	public String[] getTranslateOps() {
		return this.translateOps;
	}
	
	void setTranslateOps(String[] ops) {
		this.translateOps = ops;
	}

	boolean isCorrect() {
		return verbOrigin.equals(verbResponse);
	}

	public Question(Verb _verb, Level _level) {
		this.verbOrigin = _verb;
		this.generateQuestion(_verb, _level);
	}

	private void generateQuestion(Verb _verb, Level _level) {
		this.verbResponse = _verb.generateQuestion(_level);
		
	}
	
	@Override
	public String toString() {
		return "Question [verbOrigin=" + verbOrigin + ", verbResponse=" + verbResponse + ", translateOps="
				+ Arrays.toString(translateOps) + "]";
	}
}
