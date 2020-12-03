package com.github.juanlucode.irregular_verbs.controllers;

import java.io.File;

import com.github.juanlucode.irregular_verbs.front.MainAppFx;

import io.github.juanlucode.irregular_verbs.models.Question;
import io.github.juanlucode.irregular_verbs.models.Questionary;
import io.github.juanlucode.irregular_verbs.models.QuestionaryResult;
import io.github.juanlucode.irregular_verbs.models.Verb;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ResultController extends Controller {

	private Questionary questionary;
	private QuestionaryResult questionaryResult;
	private int idQuestion = 0;
	private Image imgCorrect = null;
	private Image imgWrong = null;

	@FXML
	private Label lblVerbsResult;
	
	@FXML 
	private Label lblCorrectsResult;
	
	@FXML 
	private Label lblWrongsResult;
	
	@FXML
	private Label lblPercentResult;
	
	@FXML
	private Label lblMasterInfinitive;
	
	@FXML
	private Label lblMasterPast;
	
	@FXML
	private Label lblMasterParticiple;
	
	@FXML
	private Label lblMasterTranslate;
	
	@FXML
	private Label lblRespInfinitive;
	
	@FXML
	private ImageView imgRespInfinitive;
	
	@FXML
	private Label lblRespPast;
	
	@FXML
	private ImageView imgRespPast;
	
	@FXML
	private Label lblRespParticiple;
	
	@FXML
	private ImageView imgRespParticiple;
	
	@FXML
	private Label lblRespTranslate;
	
	@FXML
	private ImageView imgRespTranslate;

	@FXML
	private Button btnRespBack;
	
	@FXML
	private Label lblQuestionId;
	
	@FXML
	private Button btnRespForward;
	
	@FXML
	private Button btnNewTest;
	
	@FXML
	private Button btnExit;
	
	
	@FXML
	private void initialize() {
		
        ClassLoader classLoader = getClass().getClassLoader();
        imgCorrect = new Image(classLoader.getResourceAsStream("img/correct-icon.png"));
		imgWrong = new Image(classLoader.getResourceAsStream("img/wrong-icon.png"));
		
		btnRespBack.setOnAction(e -> {
				if (idQuestion != 0 ) {
					showQuestion(--idQuestion);
				}
			}
		);
		
		btnRespForward.setOnAction(e -> {
				if (idQuestion < questionary.getQuestions().length) {
					showQuestion(++idQuestion);
				}
			}
		);
		
		btnNewTest.setOnAction(e -> {;});
		btnExit.setOnAction(e -> {;});
		showResult(questionaryResult);
	}
	
	ResultController(MainAppFx _mainAppFx) {
		super(_mainAppFx);
		this.questionary = _mainAppFx.getTest().getQuestionary();
		this.questionaryResult = this.questionary.check();
		
	}
	
	/**
	 * Shows the result table.
	 * @param result
	 */
	private void showResult(QuestionaryResult result) {
		
		lblVerbsResult.setText(String.valueOf(result.getTotalVerbs()));
		lblCorrectsResult.setText(String.valueOf(result.getCorrects()));
		lblWrongsResult.setText(String.valueOf(result.getWrongs()));
		lblPercentResult.setText(String.valueOf(result.getPercent()));
		showQuestion(idQuestion);
		
	}
	
	/**
	 * Show question correction.
	 * @param id
	 */
	private void showQuestion(int id) {
		Question question = questionary.getQuestions()[id];
		// verb master
		Verb verbM = question.getVerbOrigin();
		// verb response
		Verb verbR = question.getVerbResponse();
		

		 
		lblQuestionId.setText(String.valueOf(id + 1));
		
		// infinitive
		lblMasterInfinitive.setText(verbM.getInfinitive());
		lblRespInfinitive.setText(verbR.getInfinitive());
		
		// past
		lblMasterPast.setText(verbM.getPast());
		lblRespPast.setText(verbR.getPast());
		
		// participle
		lblMasterParticiple.setText(verbM.getParticiple());
		lblRespParticiple.setText(verbR.getParticiple());
		
		// translate
		lblMasterTranslate.setText(verbM.getTranslate());
		lblRespTranslate.setText(verbR.getTranslate());
		
	}

}
