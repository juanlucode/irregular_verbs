/**
 * 
 */
package io.github.juanlucode.iverbs.desktop.front;

import java.io.IOException;
import java.net.URL;
import io.github.iverbs.core.model.value.TestVO;
import io.github.juanlucode.iverbs.desktop.controllers.Controller;
import io.github.juanlucode.iverbs.desktop.controllers.ControllerFactory;
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
	
	private TestVO testVO;
	
	//private Level level;
	
	/*
	 * Getters & Setters
	 */

	public Stage getPrimaryStage() {
		return stage;
	}
	
	public TestVO getTest() {
		return this.testVO;
	}
	
	public void setTest(TestVO _testVO) {
		this.testVO = _testVO;
	}
	
	/*
	 * Public Methods
	 */
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage _stage) throws Exception {
        this.stage = _stage;
        
        this.stage.setTitle("Irregular Verbs TestVO");
        
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
			e.printStackTrace();
		}
        Scene scene = new Scene(root);
        
        // Set Stylesheet
        URL url = this.getClass().getResource("/css/simple_theme.css");

        String css = url.toExternalForm(); 
        scene.getStylesheets().add(css);        
       
      
        this.stage.setScene(scene);
        
        this.stage.show();
	}

	@Override
	public void toExit() {
		System.exit(0);
		
	}

}
