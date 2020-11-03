package io.github.juanlucode.irregular_verbs.models;

import java.util.List;

public class Questionary {
	private Question[] questions;

	public Question[] getQuestions() {
		return this.questions;
	}
	
	public Questionary(List<Verb> verbs, Level level) {
		
		this.questions = new Question[verbs.size()];
		
		byte i = 0;
		for (Verb verb : verbs)
			this.questions[i++] = new Question( verb, level);
	}
	
	public QuestionaryResult check() {
		var total = 0;
		var correct = 0;
		for ( Question question : this.questions ) {
			total++;
			if ( question.isCorrect() )
				correct++;
		}
		return new QuestionaryResult(total, correct);
		
	}
	
}
