package com.github.juanlucode.irregular_verbs.controllers;

import com.github.juanlucode.irregular_verbs.front.MainAppFx;
import com.github.juanlucode.irregular_verbs.front.View;

import io.github.juanlucode.irregular_verbs.models.Question;
import io.github.juanlucode.irregular_verbs.models.Test;
import io.github.juanlucode.irregular_verbs.models.Verb;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class QuestionController extends Controller {

	private Test test;
	private byte idxQuestion = -1;
	
	QuestionController(MainAppFx _mainAppFx) {
		super(_mainAppFx);
		this.test = _mainAppFx.getTest();
	}
	
	@FXML
	private TextField txtInfinitive;
	
	@FXML
	private TextField txtPast;
	
	@FXML
	private TextField txtParticiple;
	
	@FXML 
	private ComboBox<String> cboTranslate;
	
	@FXML
	private Button btnNext;

	@FXML
	private void initialize() {
		
		btnNext.setOnAction(e -> nextQuestion());
		this.nextQuestion();
	}
	
	private void nextQuestion() {
		
		idxQuestion++;
		if ( idxQuestion == this.test.getQuestionary().getQuestions().length )
			this.getMainAppFx().toScene(View.RESULT);
		else {
			showQuestion(test.getQuestionary().getQuestions()[idxQuestion]);
		}
		
	}

	private void showQuestion(Question question) {
		Verb verb = question.getVerbResponse();
		txtInfinitive.setText(verb.getInfinitive());
		txtInfinitive.setDisable(verb.getInfinitive() != null);
		txtPast.setText(verb.getPast());
		txtPast.setDisable(verb.getPast() != null);
		txtParticiple.setText(verb.getParticiple());
		txtParticiple.setDisable(verb.getParticiple() != null);
		// show translate
		cboTranslate.getItems().clear();
		if (verb.getTranslate() == null ) {
			cboTranslate.getItems().addAll(question.getTranslateOps());
			cboTranslate.setDisable(false);
		} else {
			cboTranslate.setValue(verb.getTranslate());
			cboTranslate.setDisable(true);
		}
		
	}
}
