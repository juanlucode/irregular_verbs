package io.github.juanlucode.irregular_verbs_core.models;
/**
 * Describes a simple test, with its level and set of questions. implements on singleton pattern because there have to be one test object at once.
 * @author juanlucode
 *
 */

public class Test {
	private Level level;
	private Repository repository;
	private Questionary questionary;
	
	// Constructor
	public Test(Level _level) {
		this.level = _level;
		this.repository = new Repository();
		this.questionary = repository.generateQuestionary( (byte) 10, this.level);
	}
	
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Questionary getQuestionary() {
		return questionary;
	}

	public void setQuestionary(Questionary questionary) {
		this.questionary = questionary;
	}

}
