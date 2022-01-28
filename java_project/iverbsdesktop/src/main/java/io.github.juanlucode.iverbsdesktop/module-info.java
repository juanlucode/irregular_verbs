module io.github.juanlucode.iverbsdesktop {
	
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	requires transitive io.github.juanlucode.iverbscore;
        
	
	opens io.github.juanlucode.iverbsdesktop.front to javafx.fxml;
	opens io.github.juanlucode.iverbsdesktop.controllers to javafx.fxml;
	exports io.github.juanlucode.iverbsdesktop.front;
	exports io.github.juanlucode.iverbsdesktop.controllers;
	
}