package com.github.juanlucode.irregular_verbs.controllers;

import com.github.juanlucode.irregular_verbs.front.MainAppFx;
import com.github.juanlucode.irregular_verbs.front.View;

import io.github.juanlucode.irregular_verbs.models.Question;
import io.github.juanlucode.irregular_verbs.models.Test;
import io.github.juanlucode.irregular_verbs.models.Verb;
import io.github.juanlucode.irregular_verbs.models.VerbForm;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


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
			question.getVerbResponse().set(VerbForm.INFINITIVE, newValue);
		});
		// tab with return
		txtInfinitive.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
            public void handle(final KeyEvent keyEvent) 
            {
                handleEvent(keyEvent);
            }
        });
		
		// txtPast onChange Event
		txtPast.textProperty().addListener((observable, oldValue, newValue) -> {
			question.getVerbResponse().set(VerbForm.PAST, newValue);
		});
		// tab with return
		txtPast.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
            public void handle(final KeyEvent keyEvent) 
            {
                handleEvent(keyEvent);
            }
        });
		
		// txtParticiple onChange Event
		txtParticiple.textProperty().addListener((observable, oldValue, newValue) -> {
			question.getVerbResponse().set(VerbForm.PARTICIPLE, newValue);
		});
		// tab with return
		txtParticiple.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
            public void handle(final KeyEvent keyEvent) 
            {
                handleEvent(keyEvent);
            }
        });

		
		// cboTranslate onChange Event
		cboTranslate.valueProperty().addListener((observable, oldValue, newValue) -> {
			if ( newValue != null )
				question.getVerbResponse().set(VerbForm.TRANSLATE, newValue);
		});		
		// tab with return
		cboTranslate.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
            public void handle(final KeyEvent keyEvent) 
            {
                handleEvent(keyEvent);
            }
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
		
		txtInfinitive.setText(verb.get(VerbForm.INFINITIVE));
		txtInfinitive.setDisable(!_question.getFlags()[0]);
		
		txtPast.setText(verb.get(VerbForm.PAST));
		txtPast.setDisable(!_question.getFlags()[1]);
		
		txtParticiple.setText(verb.get(VerbForm.PARTICIPLE));
		txtParticiple.setDisable(!_question.getFlags()[2]);
		
		// show translate
		cboTranslate.getItems().clear();
		if ( _question.getFlags()[3] ) {
			cboTranslate.getItems().addAll(_question.getTranslateOps());
			cboTranslate.setValue(null);
		} else {			
			cboTranslate.getItems().add(verb.get(VerbForm.TRANSLATE));
			cboTranslate.setValue(verb.get(VerbForm.TRANSLATE));
		}
		cboTranslate.setDisable(!_question.getFlags()[3]);
		
		setFocusFrom(btnNext);
	}
	
    // Helper Methods for Event Handling
    private void handleEvent(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
        	
        	setFocusFrom( (Node) e.getSource());
        }    
    }
    
    private void setFocusFrom( Node ctrl) {
    	do {
        	ctrl = switch(ctrl.getId()) {
        	
        		case "txtInfinitive" -> txtPast;
        		case "txtPast" -> txtParticiple;
        		case "txtParticiple" -> cboTranslate;
        		case "cboTranslate" -> btnNext;
        		default -> txtInfinitive;
        	};
    	} while (ctrl.isDisable());
    	ctrl.requestFocus();   	
    }
}