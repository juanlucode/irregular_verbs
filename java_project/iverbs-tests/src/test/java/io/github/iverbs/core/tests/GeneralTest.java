package io.github.iverbs.core.tests;

import static org.junit.jupiter.api.Assertions.*;

import io.github.iverbs.core.model.business.QuestionaryBO;
import io.github.iverbs.core.model.business.RepositoryBO;
import io.github.iverbs.core.model.value.RepositoryVO;
import io.github.iverbs.core.model.value.SessionVO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.github.iverbs.core.model.enumeration.Level;
import io.github.iverbs.core.model.value.QuestionaryVO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GeneralTest {

	//private RepositoryVO repositoryVO =  null;
	private SessionVO sessionVO = SessionVO.getInstance("");
	private QuestionaryVO questionaryVO = null;
	
	@Test
	@Order(1)
	@DisplayName("Testing repositoryVO creation")
	void testRepository() {
		
		assertNotEquals(0, this.sessionVO.getRepository().size());
	}

	@Test
	@Order(2)
	@DisplayName("Testing questionaryVO creation")
	void testQuestionary() {
		this.questionaryVO = RepositoryBO.generateQuestionary( this.sessionVO.getRepository().getVerbList() ,(byte) 10, Level.LEVEL_HARD);
		
		// amont of questions
		assertEquals(10, questionaryVO.getQuestions().length);
		
		// all questions are unsolved yet.
		var questionaryResult = QuestionaryBO.check(questionaryVO.getQuestions());
		assertEquals(0, questionaryResult.getCorrects());
		assertEquals(0.0f, questionaryResult.getPercent() );
		
		/*
		for ( QuestionVO question : questionaryVO.getQuestions() ) {
			
			System.out.println(question);

		}
		*/
	}
	
}
