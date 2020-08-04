package io.github.juanlucode.irregular_verbs;

public class Verb {
	private String infinitive;
	private String past;
	private String participle;
	private String translate;
	
	/**
	 * Constructor
	 * @param infinitive
	 * @param past
	 * @param participle
	 * @param translate
	 */
	public Verb(String infinitive, String past, String participle, String translate) {
		super();
		this.infinitive = infinitive;
		this.past = past;
		this.participle = participle;
		this.translate = translate;
	}

	public String getInfinitive() {
		return infinitive;
	}

	public void setInfinitive(String infinitive) {
		this.infinitive = infinitive;
	}

	public String getPast() {
		return past;
	}

	public void setPast(String past) {
		this.past = past;
	}

	public String getParticiple() {
		return participle;
	}

	public void setParticiple(String participle) {
		this.participle = participle;
	}

	public String getTranslate() {
		return translate;
	}

	public void setTranslate(String translate) {
		this.translate = translate;
	}

	@Override
	public String toString() {
		return "Verb [infinitive=" + infinitive + ", past=" + past + ", participle=" + participle + ", translate="
				+ translate + "]";
	}
	
}
