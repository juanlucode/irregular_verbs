package io.github.iverbs.core.model.value;

import io.github.iverbs.core.model.enumeration.Level;

import java.util.List;

public class QuestionaryVO {
	private QuestionVO[] questions;

	public QuestionVO[] getQuestions() {
		return this.questions;
	}
	
	public QuestionaryVO(List<VerbVO> verbs, Level level) {
		
		this.questions = new QuestionVO[verbs.size()];
		
		byte i = 0;
		for (VerbVO verbVO : verbs)
			this.questions[i++] = new QuestionVO(verbVO, level);
	}
	

	
}
