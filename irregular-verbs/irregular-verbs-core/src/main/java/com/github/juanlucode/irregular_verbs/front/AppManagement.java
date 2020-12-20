package com.github.juanlucode.irregular_verbs.front;

/**
 * Interface to manage the flow of app. Provides methods:
 * toScene: method to call from any controller.
 * toExit: exit app.
 * 
 * @author juanluis
 *
 */
public interface AppManagement {
	public void toScene(View _view);
	public void toExit();

}
