package com.github.juanlucode.irregular_verbs.controllers;

import com.github.juanlucode.irregular_verbs.front.MainAppFx;
import com.github.juanlucode.irregular_verbs.front.View;

import io.github.juanlucode.irregular_verbs.models.Question;
import io.github.juanlucode.irregular_verbs.models.Questionary;
import io.github.juanlucode.irregular_verbs.models.QuestionaryResult;
import io.github.juanlucode.irregular_verbs.models.Verb;
import io.github.juanlucode.irregular_verbs.models.VerbForm;
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
		if ( verbM.equalForm(VerbForm.INFINITIVE, verbR) )
			imgRespInfinitive.setImage(imgCorrect);
		else
			imgRespInfinitive.setImage(imgWrong);
		
		// past
		lblMasterPast.setText(verbM.get(VerbForm.PAST));
		lblRespPast.setText(verbR.get(VerbForm.PAST));
		if ( verbM.equalForm(VerbForm.PAST, verbR) )
			imgRespPast.setImage(imgCorrect);
		else
			imgRespPast.setImage(imgWrong);
		
		// participle
		lblMasterParticiple.setText(verbM.get(VerbForm.PARTICIPLE));
		lblRespParticiple.setText(verbR.get(VerbForm.PARTICIPLE));
		if ( verbM.equalForm(VerbForm.PARTICIPLE, verbR) )
			imgRespParticiple.setImage(imgCorrect);
		else
			imgRespParticiple.setImage(imgWrong);

		
		// translate
		lblMasterTranslate.setText(verbM.get(VerbForm.TRANSLATE));
		lblRespTranslate.setText(verbR.get(VerbForm.TRANSLATE));
		if ( verbM.equalForm(VerbForm.TRANSLATE, verbR) )
			imgRespTranslate.setImage(imgCorrect);
		else
			imgRespTranslate.setImage(imgWrong);
		
	}

}
