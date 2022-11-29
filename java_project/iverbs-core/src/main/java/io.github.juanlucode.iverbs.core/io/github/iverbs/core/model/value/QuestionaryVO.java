package io.github.iverbs.core.model.value;

import io.github.iverbs.core.model.QuestionaryResult;
import io.github.iverbs.core.model.Verb;
import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.value.QuestionVO;

import java.util.List;

public class QuestionaryVO {
	private QuestionVO[] questions;

	public QuestionVO[] getQuestions() {
		return this.questions;
	}
	
	public QuestionaryVO(List<Verb> verbs, Level level) {
		
		this.questions = new QuestionVO[verbs.size()];
		
		byte i = 0;
		for (Verb verb : verbs)
			this.questions[i++] = new QuestionVO( verb, level);
	}
	

	
}
