package io.github.juanlucode.iverbsdesktop.controllers;

import io.github.juanlucode.iverbsdesktop.front.MainAppFx;
import io.github.juanlucode.iverbsdesktop.front.View;

/**
 * Factory Pattern to get controllers
 * @author juanluis
 *
 */
public final class ControllerFactory {
	
	public static Controller get(MainAppFx app, View view) {
        switch(view) {
        case MENU:
        	return new MenuController(app);
        case QUESTION:
        	return new QuestionController(app);
        case RESULT:
        	return new ResultController(app);
        default:
        	return null;
        }
    }		


}
