module irregular_verbs_desktop_module {
	
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.fxml;
	
	requires transitive irregular_verbs_core_module;
        
	
	opens io.github.juanlucode.irregular_verbs_desktop.front to javafx.fxml;
	opens io.github.juanlucode.irregular_verbs_desktop.controllers to javafx.fxml;
	exports io.github.juanlucode.irregular_verbs_desktop.front;
	exports io.github.juanlucode.irregular_verbs_desktop.controllers;
	
}