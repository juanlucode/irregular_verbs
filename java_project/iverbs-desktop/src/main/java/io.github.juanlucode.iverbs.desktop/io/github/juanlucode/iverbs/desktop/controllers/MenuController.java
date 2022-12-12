package io.github.juanlucode.iverbs.desktop.controllers;


import io.github.iverbs.core.model.value.TestVO;
import io.github.iverbs.core.model.enumeration.Level;
import io.github.juanlucode.iverbs.desktop.front.MainAppFx;
import io.github.juanlucode.iverbs.desktop.front.View;
import io.github.juanlucode.iverbs.desktop.logfile.LogFile;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.FileNotFoundException;

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
		try {
			this.getMainAppFx().setTest(new TestVO(_level));
		} catch (FileNotFoundException e) {
			LogFile.getInstance().put(e.getMessage());
			e.printStackTrace();
		}
		this.getMainAppFx().toScene(View.QUESTION);
	}
}
