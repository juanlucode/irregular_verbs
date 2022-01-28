package io.github.juanlucode.iverbsdesktop.controllers;


import io.github.juanlucode.iverbscore.models.Level;
import io.github.juanlucode.iverbscore.models.Test;
import io.github.juanlucode.iverbsdesktop.front.MainAppFx;
import io.github.juanlucode.iverbsdesktop.front.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController extends Controller {

	MenuController(MainAppFx _mainAppFx) {
		super(_mainAppFx);
	}

	@FXML
	private Button btnEasy;
	
	@FXML
	private Button btnMedium;
	
	@FXML
	private Button btnHard;
	
	@FXML
	private void initialize() {
		btnEasy.setOnAction(e -> this.selectLevel(Level.LEVEL_LIGHT));
		btnMedium.setOnAction(e -> this.selectLevel(Level.LEVEL_MEDIUM));
		btnHard.setOnAction(e -> this.selectLevel(Level.LEVEL_HARD));
	}
	
	private void selectLevel(Level _level) {
		this.getMainAppFx().setTest(new Test(_level));
		this.getMainAppFx().toScene(View.QUESTION);		
	}
}
