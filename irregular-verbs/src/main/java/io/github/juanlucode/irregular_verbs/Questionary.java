package io.github.juanlucode.irregular_verbs;

import java.util.List;

public class Questionary {
	private Question[] questions;

	Question[] getQuestions() {
		return this.questions;
	}
	
	public Questionary(List<Verb> verbs, Level level) {
		
		this.questions = new Question[verbs.size()];
		
		byte i = 0;
		for (Verb verb : verbs)
			this.questions[i++] = new Question( verb, level);
	}
	
	public float check() {
		var total = 0;
		var correct = 0;
		for ( Question question : this.questions ) {
			total++;
			if ( question.isCorrect() )
				correct++;
		}
		return (float) correct / total;
		
	}
	
}
