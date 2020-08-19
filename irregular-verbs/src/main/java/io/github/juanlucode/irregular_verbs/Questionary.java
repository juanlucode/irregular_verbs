package io.github.juanlucode.irregular_verbs;

public class Questionary {
	private Question[] questions;

	Question[] getQuestions() {
		return this.questions;
	}
	
	public Questionary(Verb[] verbs, Level level) {
		
		questions = new Question[verbs.length];
		
		byte i = 0;
		for (Verb verb : verbs)
			questions[i++] = new Question( verb, level);
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
