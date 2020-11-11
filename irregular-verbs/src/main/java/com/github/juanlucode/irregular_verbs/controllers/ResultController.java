package com.github.juanlucode.irregular_verbs.controllers;

import com.github.juanlucode.irregular_verbs.front.MainAppFx;

import io.github.juanlucode.irregular_verbs.models.Questionary;
import io.github.juanlucode.irregular_verbs.models.QuestionaryResult;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class ResultController extends Controller {

	private Questionary questionary;
	private QuestionaryResult questionaryResult;
	
	ResultController(MainAppFx _mainAppFx) {
		super(_mainAppFx);
		this.questionary = _mainAppFx.getTest().getQuestionary();
		this.questionaryResult = this.questionary.check();
		
	}

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
	private Button btnRespForward;
	
	@FXML
	private Button btnNewTest;
	
	@FXML
	private Button btnExit;
	
	@FXML
	private void initialize() {
		btnRespBack.setOnAction(e -> {;});
		btnRespForward.setOnAction(e -> {;});
		btnNewTest.setOnAction(e -> {;});
		btnExit.setOnAction(e -> {;});
		showResult(questionaryResult);
	}
	
	private void showResult(QuestionaryResult result) {
		lblVerbsResult.setText(String.valueOf(result.getTotalVerbs()));
		lblCorrectsResult.setText(String.valueOf(result.getCorrects()));
		lblWrongsResult.setText(String.valueOf(result.getWrongs()));
		lblPercentResult.setText(String.valueOf(result.getPercent()));
		
	}

}
