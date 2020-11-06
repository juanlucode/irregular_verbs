package com.github.juanlucode.irregular_verbs.controllers;

import com.github.juanlucode.irregular_verbs.front.MainAppFx;

import io.github.juanlucode.irregular_verbs.models.QuestionaryResult;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class ResultController extends Controller {

	private QuestionaryResult questionaryResult;
	
	ResultController(MainAppFx _mainAppFx) {
		super(_mainAppFx);
		this.questionaryResult = _mainAppFx.getTest().getQuestionary().check();
		
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
	private Button btnNewTest;
	
	@FXML
	private Button btnExit;
	
	@FXML
	private void initialize() {
		
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
