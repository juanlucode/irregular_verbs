package io.github.juanlucode.irregular_verbs.models;


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
