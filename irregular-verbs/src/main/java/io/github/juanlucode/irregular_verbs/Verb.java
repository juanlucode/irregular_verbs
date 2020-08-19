package io.github.juanlucode.irregular_verbs;

import com.github.juanlucode.commons.ArrayTools;

public class Verb {
	private String infinitive = null;
	private String past = null;
	private String participle = null;
	private String translate = null;
	
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

	public Verb generateQuestion(Level _level) {
		// define the forms of verb which are visible at ramdom
		
		Boolean[] form = {true,true,true,true};
		for (int i = 0; i <= _level.ordinal(); i++)
			form[i] = false;
		
		// mix the array
		form = ArrayTools.shuffleArray(form);
		
		// return new incomplete verb
		return new Verb(
								form[0]?this.infinitive:null,
								form[1]?this.past:null,
								form[2]?this.participle:null,
								form[3]?this.translate:null
							);
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((infinitive == null) ? 0 : infinitive.hashCode());
		result = prime * result + ((participle == null) ? 0 : participle.hashCode());
		result = prime * result + ((past == null) ? 0 : past.hashCode());
		result = prime * result + ((translate == null) ? 0 : translate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Verb other = (Verb) obj;
		if (infinitive == null) {
			if (other.infinitive != null)
				return false;
		} else if (!infinitive.equals(other.infinitive))
			return false;
		if (participle == null) {
			if (other.participle != null)
				return false;
		} else if (!participle.equals(other.participle))
			return false;
		if (past == null) {
			if (other.past != null)
				return false;
		} else if (!past.equals(other.past))
			return false;
		if (translate == null) {
			if (other.translate != null)
				return false;
		} else if (!translate.equals(other.translate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Verb [infinitive=" + infinitive + ", past=" + past + ", participle=" + participle + ", translate="
				+ translate + "]";
	}
	
}
