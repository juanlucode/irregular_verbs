package com.github.juanlucode.irregular_verbs.controllers;

import com.github.juanlucode.irregular_verbs.front.MainAppFx;
import com.github.juanlucode.irregular_verbs.front.View;

import io.github.juanlucode.irregular_verbs.models.Question;
import io.github.juanlucode.irregular_verbs.models.Test;
import io.github.juanlucode.irregular_verbs.models.Verb;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class QuestionController extends Controller {

	private Test test;
	private byte idxQuestion = -1;
	private Question question = null;
	
	QuestionController(MainAppFx _mainAppFx) {
		super(_mainAppFx);
		this.test = _mainAppFx.getTest();
	}
	
	@FXML
	private Label lblQuestionNum;
	
	@FXML
	private Label lblQuestionTotal;
	
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
		
		// txtInfinitive onChange Event
		txtInfinitive.textProperty().addListener((observable, oldValue, newValue) -> {
			question.getVerbResponse().setInfinitive(newValue);
		});
		
		// txtPast onChange Event
		txtPast.textProperty().addListener((observable, oldValue, newValue) -> {
			question.getVerbResponse().setPast(newValue);
		});
		
		// txtParticiple onChange Event
		txtParticiple.textProperty().addListener((observable, oldValue, newValue) -> {
			question.getVerbResponse().setParticiple(newValue);
		});
		
		// cboTranslate onChange Event
		cboTranslate.valueProperty().addListener((observable, oldValue, newValue) -> {
			if ( newValue != null )
				question.getVerbResponse().setTranslate(newValue);
		});		
		
		btnNext.setOnAction(e -> nextQuestion());
		
		lblQuestionTotal.setText(String.valueOf(this.test.getQuestionary().getQuestions().length));
		this.nextQuestion();
	}
	
	private void nextQuestion() {
		

		idxQuestion++;
		if ( idxQuestion >= this.test.getQuestionary().getQuestions().length )
			this.getMainAppFx().toScene(View.RESULT);
		else {
			question = test.getQuestionary().getQuestions()[idxQuestion];
			showQuestion(question);
		}
		
	}

	private void showQuestion(Question _question) {
		lblQuestionNum.setText(String.valueOf(idxQuestion + 1));
		Verb verb = _question.getVerbResponse();
		txtInfinitive.setText(verb.getInfinitive());
		txtInfinitive.setEditable(verb.getInfinitive() == null);
		txtPast.setText(verb.getPast());
		txtPast.setEditable(verb.getPast() == null);
		txtParticiple.setText(verb.getParticiple());
		txtParticiple.setEditable(verb.getParticiple() == null);
		// show translate
		cboTranslate.setValue(null);
		cboTranslate.getItems().clear();
		if (verb.getTranslate() == null ) {
			cboTranslate.getItems().addAll(_question.getTranslateOps());
			cboTranslate.setEditable(true);
		} else {
			cboTranslate.setValue(verb.getTranslate());
			cboTranslate.setEditable(false);
		}
		
	}
}
