package io.github.juanlucode.iverbsdesktop.controllers;

import io.github.juanlucode.iverbsdesktop.front.MainAppFx;

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
