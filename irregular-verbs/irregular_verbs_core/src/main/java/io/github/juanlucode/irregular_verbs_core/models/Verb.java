package io.github.juanlucode.irregular_verbs_core.models;


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

	public String get(VerbForm _verbForm) {
		String value = switch( _verbForm ) {
		case INFINITIVE -> this.infinitive;
		case PAST -> this.past;
		case PARTICIPLE -> this.participle;
		case TRANSLATE -> this.translate;

		};
		
		return (value == null)?null:value.toLowerCase().trim();
	}
	
	public void set(VerbForm _verbForm, String _value) {
		switch ( _verbForm ) {
		case INFINITIVE: 
			this.infinitive = _value;
			break;
		case PAST:
			this.past = _value;
			break;
		case PARTICIPLE:
			this.participle = _value;
			break;
		case TRANSLATE:
			this.translate = _value;
			break;
		}
	}
	

	public boolean equalForm(VerbForm _verbForm, Verb other) {

		if (  this.get(_verbForm) == null) {
			if ( other.get(_verbForm) == null )
				return true;
			else
				return false;
		} else {
			if ( this.get(_verbForm).equals(other.get(_verbForm)) )
				return true;
			else 
				return false;
		}
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
		
		for ( VerbForm _verbForm : VerbForm.values() ) {
			if ( ! this.equalForm(_verbForm, other)) 
				return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Verb [infinitive=" + infinitive + ", past=" + past + ", participle=" + participle + ", translate="
				+ translate + "]";
	}
	
}
