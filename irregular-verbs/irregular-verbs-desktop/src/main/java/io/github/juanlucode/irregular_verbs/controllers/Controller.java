package io.github.juanlucode.irregular_verbs.controllers;

import io.github.juanlucode.irregular_verbs.front.MainAppFx;

/**
 * Controller
 *
 * Top class for controllers. Contains commons methods for all specifics
 * controllers.
 * 
 * @author juanluis
 *
 */
public abstract class Controller {
	
	private static MainAppFx mainAppFx;

	Controller(MainAppFx _mainAppFx) {
		Controller.mainAppFx = _mainAppFx;
	}
	
	public MainAppFx getMainAppFx() {
		return Controller.mainAppFx;
	}

}
