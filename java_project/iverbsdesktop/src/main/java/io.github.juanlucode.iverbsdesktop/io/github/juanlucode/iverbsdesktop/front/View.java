package io.github.juanlucode.iverbsdesktop.front;

/**
 * View
 * @author juanluis
 *
 * Enumeration of existing views, specifying
 * the fxml file and its controller.
 */
public enum View {
	MENU("menu.fxml"),
	QUESTION("question.fxml"),
	RESULT("result.fxml");
	
	final private String fxml;
	
	View(String _fxml){
		this.fxml = _fxml;
	}
	
	protected String getFxml() {
		return this.fxml;
	}
}
