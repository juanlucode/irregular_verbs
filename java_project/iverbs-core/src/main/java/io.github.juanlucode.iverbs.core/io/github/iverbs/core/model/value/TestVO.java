package io.github.iverbs.core.model.value;

import io.github.iverbs.core.model.business.RepositoryBO;
import io.github.iverbs.core.model.enumeration.Level;

/**
 * Describes a simple test, with its level and set of questions. implements on singleton pattern because there have to be one test object at once.
 * @author juanlucode
 *
 */

public class TestVO {
	private Level level;
	private RepositoryVO repositoryVO;
	private QuestionaryVO questionaryVO;
	
	// Constructor
	public TestVO(Level _level) {
		this.level = _level;
		this.questionaryVO = RepositoryBO.generateQuestionary(.getVerbList (), (byte) 10, this.level);
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

}
