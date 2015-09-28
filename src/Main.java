import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage window;
    public static Scene logInScene, listScene;
    public static final int WIDTH = 400, HEIGHT = 500;
    
    public static User loggedInUser;

	//Oppretter forbindelse med MySQL databasen
	public static final MySQLConnection MYSQL = new MySQLConnection();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    	window = primaryStage;
        window.setTitle("ToDoList");
        
        
        logInScene = new LogInScene(primaryStage);
        //listScene = new ListScene(primaryStage);
        
        
        
        window.setScene(logInScene);
        window.show();
    }
    
     

}