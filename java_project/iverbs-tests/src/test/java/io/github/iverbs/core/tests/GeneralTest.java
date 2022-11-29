package io.github.iverbs.core.tests;

import static org.junit.jupiter.api.Assertions.*;

import io.github.iverbs.core.model.Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.value.QuestionaryVO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GeneralTest {

	private Repository repository =  null;
	private QuestionaryVO questionaryVO = null;
	
	@Test
	@Order(1)
	@DisplayName("Testing repository creation")
	void testRepository() {
		
		this.repository = new Repository();
		
		assertNotEquals(0, this.repository.size()); 
	}

	@Test
	@Order(2)
	@DisplayName("Testing questionaryVO creation")
	void testQuestionary() {
		this.repository = new Repository();
		this.questionaryVO = this.repository.generateQuestionary((byte) 10, Level.LEVEL_HARD);
		
		// amont of questions
		assertEquals(10, questionaryVO.getQuestions().length);
		
		// all questions are unsolved yet.
		var questionaryResult = questionaryVO.check();
		assertEquals(0, questionaryResult.getCorrects());
		assertEquals(0.0f, questionaryResult.getPercent() );
		
		/*
		for ( QuestionVO question : questionaryVO.getQuestions() ) {
			
			System.out.println(question);

		}
		*/
	}
	
}
