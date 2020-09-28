/**
 * 
 */
package com.github.juanlucode.irregular_verbs.front;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import com.github.juanlucode.irregular_verbs.controllers.Controller;
import com.github.juanlucode.irregular_verbs.controllers.ControllerFactory;

//import com.github.juanlucode.defutbol_app.i18n.I18N;

//import java.io.IOException;

//import com.github.juanlucode.defutbol_app.controllers.Controller;
//import com.github.juanlucode.defutbol_app.controllers.RootController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author juanluis
 *
 */
public class MainAppFx extends Application implements AppManagement{


	/*
	 * Private objects
	 */
	
	private Stage stage;
	
	/*
	 * Getters
	 */

	public Stage getPrimaryStage() {
		return stage;
	}
	
	/*
	 * Public Methods
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}

	@Override
	public void start(Stage _stage) throws Exception {
        this.stage = _stage;
        
        this.stage.setTitle("Irregular Verbs Test");
        
        this.toScene(View.MENU);

	}

	
	/**
	 * function to management the transition between scenes
	 * @params _view
	 */
	@Override
	public void toScene(View _view) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/" + _view.getFxml()));
        //loader.setResources(I18N.getInstance().getResourceBundle());
        Controller controller = ControllerFactory.get(this, _view);
        
        loader.setController(controller);
        Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scene scene = new Scene(root);
       
      
        this.stage.setScene(scene);
        
        this.stage.show();
	}

	@Override
	public void toExit() {
		System.exit(0);
		
	}

}
