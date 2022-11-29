package io.github.iverbs.core.model;

import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.value.QuestionaryVO;

/**
 * Describes a simple test, with its level and set of questions. implements on singleton pattern because there have to be one test object at once.
 * @author juanlucode
 *
 */

public class Test {
	private Level level;
	private Repository repository;
	private QuestionaryVO questionaryVO;
	
	// Constructor
	public Test(Level _level) {
		this.level = _level;
		this.repository = new Repository();
		this.questionaryVO = repository.generateQuestionary( (byte) 10, this.level);
	}
	
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public QuestionaryVO getQuestionary() {
		return questionaryVO;
	}

	public void setQuestionary(QuestionaryVO questionaryVO) {
		this.questionaryVO = questionaryVO;
	}

}
