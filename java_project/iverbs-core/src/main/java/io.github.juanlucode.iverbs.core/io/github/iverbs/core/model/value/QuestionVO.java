package io.github.iverbs.core.model.value;

import java.util.Arrays;

import io.github.iverbs.commons.ArrayTools;
import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.enumeration.VerbForm;

/**
 * Describes a question.
 * @author juanlucode
 *
 */
public class QuestionVO {

	private VerbVO verbOrigin;
	private VerbVO verbResponse;
	private Level level;
	private Boolean[] flags = {false,false,false,false};
	private String[] translateOps = null;

	/**
	 * Get the origin verb of the question
	 * @return
	 */
	public VerbVO getVerbOrigin() {
		return this.verbOrigin;
	}
	
	/**
	 * Get the incomplete verb the user must complete
	 * @return
	 */
	public VerbVO getVerbResponse() {
		return this.verbResponse;
	}

	/**
	 * Set the incomplete verb the user must complete
	 * @return
	 */
	void setVerbResponse(VerbVO verbResponse) {
		this.verbResponse = verbResponse;
	}
	
	/**
	 * Get flags of the question
	 * Flags indicate which form of verbs are asked in the question.
	 * True - user must complete
	 * False - show in the question
	 * @return
	 */
	public Boolean[] getFlags() {
		return this.flags;
	}

	/**
	 * Set flags of the question
	 * Flags indicate which form of verbs are asked in the question.
	 * True - user must complete
	 * False - show in the question
	 * @return
	 */
	public void setFlags(Boolean[] _flags) {
		this.flags = _flags;
	}
	
	/**
	 * Get the options for the translate question.
	 * The translate form of the verb have a test question format with 4 possible options.
	 * @return
	 */
	public String[] getTranslateOps() {
		return this.translateOps;
	}
	
	/**
	 * Set the options for the translate question.
	 * The translate form of the verb have a test question format with 4 possible options.
	 * @return
	 */
	public void setTranslateOps(String[] ops) {
		this.translateOps = ops;
	}

	/**
	 * Indicate if the question is correct
	 * @return
	 */
	public boolean isCorrect() {
		return verbOrigin.equals(verbResponse);
	}

	/**
	 * QuestionVO construct
	 * @param _verbVO Original verb to make a question
	 * @param _level Level of the question (amount of forms hidden)
	 */
	public QuestionVO(VerbVO _verbVO, Level _level) {
		this.verbOrigin = _verbVO;
		this.level = _level;
		this.generateQuestion();
	}

	/**
	 * Generate a question from a verb hidding forms depending of level.
	 */
	private void generateQuestion() {
		// define the forms of verb which are visible at ramdom

		for (int i = 0; i <= this.level.ordinal(); i++)
			flags[i] = true;

		// mix the array
		flags = ArrayTools.shuffleArray(flags);

		// return new incomplete verb
		this.verbResponse = new VerbVO(
							 	flags[0]?null:verbOrigin.get(VerbForm.INFINITIVE),
							 	flags[1]?null:verbOrigin.get(VerbForm.PAST),
							 	flags[2]?null:verbOrigin.get(VerbForm.PARTICIPLE),
							 	flags[3]?null:verbOrigin.get(VerbForm.TRANSLATE)
							);

	}
	
	@Override
	public String toString() {
		return "QuestionVO [verbOrigin=" + verbOrigin + ", verbResponse=" + verbResponse + ", translateOps="
				+ Arrays.toString(translateOps) + "]";
	}
}
