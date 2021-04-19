package io.github.juanlucode.irregular_verbs_core_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.github.juanlucode.irregular_verbs_core.models.Level;
import io.github.juanlucode.irregular_verbs_core.models.Questionary;
import io.github.juanlucode.irregular_verbs_core.models.Repository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GeneralTest {

	private Repository repository =  null;
	private Questionary questionary = null;
	
	@Test
	@Order(1)
	@DisplayName("Testing repository creation")
	void testRepository() {
		
		this.repository = new Repository();
		
		assertNotEquals(0, this.repository.size()); 
	}

	@Test
	@Order(2)
	@DisplayName("Testing questionary creation")
	void testQuestionary() {
		this.repository = new Repository();
		this.questionary = this.repository.generateQuestionary((byte) 10, Level.LEVEL_HARD);
		
		// amont of questions
		assertEquals(10, questionary.getQuestions().length);
		
		// all questions are unsolved yet.
		var questionaryResult = questionary.check();
		assertEquals(0, questionaryResult.getCorrects());
		assertEquals(0.0f, questionaryResult.getPercent() );
		
		/*
		for ( Question question : questionary.getQuestions() ) {
			
			System.out.println(question);

		}
		*/
	}
	
}
