package io.github.juanlucode.iverbs.desktop.controllers;

import io.github.iverbs.core.model.value.VerbVO;
import io.github.iverbs.core.model.value.QuestionVO;
import io.github.iverbs.core.model.value.TestVO;
import io.github.iverbs.core.model.enumeration.VerbForm;
import io.github.juanlucode.iverbs.desktop.front.MainAppFx;
import io.github.juanlucode.iverbs.desktop.front.View;
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

	private TestVO testVO;
	private byte idxQuestion = -1;
	private QuestionVO questionVO = null;
	

	
	QuestionController(MainAppFx _mainAppFx) {
		super(_mainAppFx);
		this.testVO = _mainAppFx.getTest();
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
			questionVO.getVerbResponse().set(VerbForm.INFINITIVE, newValue);
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
			questionVO.getVerbResponse().set(VerbForm.PAST, newValue);
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
			questionVO.getVerbResponse().set(VerbForm.PARTICIPLE, newValue);
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
				questionVO.getVerbResponse().set(VerbForm.TRANSLATE, newValue);
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
		
		lblQuestionTotal.setText(String.valueOf(this.testVO.getQuestionary().getQuestions().length));
		this.nextQuestion();
	}
	
	private void nextQuestion() {
		

		idxQuestion++;
		if ( idxQuestion >= this.testVO.getQuestionary().getQuestions().length )
			this.getMainAppFx().toScene(View.RESULT);
		else {
			questionVO = testVO.getQuestionary().getQuestions()[idxQuestion];
			showQuestion(questionVO);
		}
		
	}

	private void showQuestion(QuestionVO _questionVO) {
		
		lblQuestionNum.setText(String.valueOf(idxQuestion + 1));
		VerbVO verbVO = _questionVO.getVerbResponse();
		
		txtInfinitive.setText(verbVO.get(VerbForm.INFINITIVE));
		txtInfinitive.setDisable(!_questionVO.getFlags()[0]);
		
		txtPast.setText(verbVO.get(VerbForm.PAST));
		txtPast.setDisable(!_questionVO.getFlags()[1]);
		
		txtParticiple.setText(verbVO.get(VerbForm.PARTICIPLE));
		txtParticiple.setDisable(!_questionVO.getFlags()[2]);
		
		// show translate
		cboTranslate.getItems().clear();
		if ( _questionVO.getFlags()[3] ) {
			cboTranslate.getItems().addAll(_questionVO.getTranslateOps());
			cboTranslate.setValue(null);
		} else {			
			cboTranslate.getItems().add(verbVO.get(VerbForm.TRANSLATE));
			cboTranslate.setValue(verbVO.get(VerbForm.TRANSLATE));
		}
		cboTranslate.setDisable(!_questionVO.getFlags()[3]);
		
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
        	switch(ctrl.getId()) {
        	
        		case "txtInfinitive": 
        			ctrl = txtPast;
        			break;
        		case "txtPast":
        			ctrl = txtParticiple;
        			break;
        		case "txtParticiple":
        			ctrl = cboTranslate;
        			break;
        		case "cboTranslate":
        			ctrl = btnNext;
        			break;
        		default: 
        			ctrl = txtInfinitive;
        	};
    	} while (ctrl.isDisable());
    	ctrl.requestFocus();   	
    }
}
