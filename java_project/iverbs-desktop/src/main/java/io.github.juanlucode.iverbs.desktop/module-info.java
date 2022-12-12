module io.github.juanlucode.iverbs.desktop {
	
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	requires transitive io.github.juanlucode.iverbs.core;
    requires java.logging;


    opens io.github.juanlucode.iverbs.desktop.front to javafx.fxml;
	opens io.github.juanlucode.iverbs.desktop.controllers to javafx.fxml;
	exports io.github.juanlucode.iverbs.desktop.front;
	exports io.github.juanlucode.iverbs.desktop.controllers;
	
}