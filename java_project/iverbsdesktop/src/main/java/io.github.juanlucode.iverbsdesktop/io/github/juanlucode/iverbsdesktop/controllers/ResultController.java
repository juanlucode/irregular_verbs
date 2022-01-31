package io.github.juanlucode.iverbsdesktop.controllers;

import java.io.IOException;
import java.io.InputStream;

import io.github.juanlucode.iverbscore.models.Question;
import io.github.juanlucode.iverbscore.models.Questionary;
import io.github.juanlucode.iverbscore.models.QuestionaryResult;
import io.github.juanlucode.iverbscore.models.Verb;
import io.github.juanlucode.iverbscore.models.VerbForm;
import io.github.juanlucode.iverbsdesktop.front.MainAppFx;
import io.github.juanlucode.iverbsdesktop.front.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


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
		
		/*
		 
		//ClassLoader classLoader = getClass().getClassLoader();
		
		Module module = getClass().getModule();

		// try (InputStream inputStream =
		// classLoader.getResourceAsStream("repo/irregular_verbs.json")){
		try (InputStream inputStream = module.getResourceAsStream("repo/irregular_verbs.json")) {
		 
		 */
		
        //ClassLoader classLoader = getClass().getClassLoader();
		
		Module module = getClass().getModule();
		
        try {
			imgCorrect = new Image(module.getResourceAsStream("img/correct-icon.png"));
			imgWrong = new Image(module.getResourceAsStream("img/wrong-icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		btnRespBack.setOnAction(e -> {
				if (idQuestion != 0 ) {
					showQuestion(--idQuestion);
				}
			}
		);
		
		btnRespForward.setOnAction(e -> {
				if (idQuestion < questionary.getQuestions().length - 1) {
					showQuestion(++idQuestion);
				}
			}
		);
		
		btnNewTest.setOnAction(e -> this.getMainAppFx().toScene(View.MENU));
		btnExit.setOnAction(e -> System.exit(0));
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
		if ( result.getPercent() < 50 )
			lblPercentResult.setTextFill(Color.RED);
		else 
			lblPercentResult.setTextFill(Color.GREEN);
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
		lblMasterInfinitive.setText(verbM.get(VerbForm.INFINITIVE));
		lblRespInfinitive.setText(verbR.get(VerbForm.INFINITIVE));
		if ( question.getFlags()[0]) 
			if ( verbM.equalForm(VerbForm.INFINITIVE, verbR) ) {
				lblRespInfinitive.setTextFill(Color.GREEN);
				imgRespInfinitive.setImage(imgCorrect);
			} else {
				lblRespInfinitive.setTextFill(Color.RED);
				imgRespInfinitive.setImage(imgWrong);
			}
		else {
			lblRespInfinitive.setTextFill(Color.BLACK);
			imgRespInfinitive.setImage(null);
		}
		
		// past
		lblMasterPast.setText(verbM.get(VerbForm.PAST));
		lblRespPast.setText(verbR.get(VerbForm.PAST));
		if ( question.getFlags()[1])
			if ( verbM.equalForm(VerbForm.PAST, verbR) ) {
				lblRespPast.setTextFill(Color.GREEN);
				imgRespPast.setImage(imgCorrect);
			} else {
				lblRespPast.setTextFill(Color.RED);
				imgRespPast.setImage(imgWrong);
			}
		else {
			lblRespPast.setTextFill(Color.BLACK);
			imgRespPast.setImage(null);
		}
		
		// participle
		lblMasterParticiple.setText(verbM.get(VerbForm.PARTICIPLE));
		lblRespParticiple.setText(verbR.get(VerbForm.PARTICIPLE));
		if ( question.getFlags()[2])
			if ( verbM.equalForm(VerbForm.PARTICIPLE, verbR) ) {
				lblRespParticiple.setTextFill(Color.GREEN);
				imgRespParticiple.setImage(imgCorrect);
			} else {
				lblRespParticiple.setTextFill(Color.RED);
				imgRespParticiple.setImage(imgWrong);
			}
		else {
			lblRespParticiple.setTextFill(Color.BLACK);
			imgRespParticiple.setImage(null);
		}
		
		// translate
		lblMasterTranslate.setText(verbM.get(VerbForm.TRANSLATE));
		lblRespTranslate.setText(verbR.get(VerbForm.TRANSLATE));
		if ( question.getFlags()[3])
			if ( verbM.equalForm(VerbForm.TRANSLATE, verbR) ) {
				lblRespTranslate.setTextFill(Color.GREEN);
				imgRespTranslate.setImage(imgCorrect);
			} else {
				lblRespTranslate.setTextFill(Color.RED);
				imgRespTranslate.setImage(imgWrong);
			}
		else {
			lblRespTranslate.setTextFill(Color.BLACK);
			imgRespTranslate.setImage(null);
			
		}
	}

}
