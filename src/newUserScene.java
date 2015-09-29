import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class newUserScene extends Scene {
	
	private final Stage primaryStage;
	private final BorderPane root;
	

	
	private MySQLConnection ntnuMySql;
	
	public newUserScene(Stage primaryStage) {
		
		//Definerer alt n�dvendig
		super(new BorderPane(), Main.WIDTH, Main.HEIGHT);
		root = (BorderPane) super.getRoot();
		this.primaryStage = primaryStage;
		getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		
		//Title lable
		Label title = new Label("SignUp");
		title.setId("title");
		
		
		//Form
		TextField txtUserName = new TextField();
		txtUserName.setPromptText("Brukernavn");
		txtUserName.setMaxWidth(150);
		txtUserName.setFocusTraversable(false);
		
		
		PasswordField pf = new PasswordField();
		pf.setPromptText("Password");
		pf.setMaxWidth(150);
		pf.setFocusTraversable(false);
		
		//Creating layout
		VBox vbox = new VBox(5);		
		Button btnSignUp = new Button("SignUp");
		btnSignUp.setFocusTraversable(false);
		btnSignUp.setId("button");
		
		btnSignUp.setOnAction( e -> buttonClicked(txtUserName, pf));
		vbox.getChildren().addAll(title, txtUserName, pf, btnSignUp);
		vbox.setAlignment(Pos.CENTER);
		
		//SignUpButton
		Button btnLogin = new Button("Login");
		VBox bottomVBox = new VBox();
		btnLogin.setId("btnSignUp");
		bottomVBox.getChildren().add(btnLogin);
		bottomVBox.setAlignment(Pos.BOTTOM_RIGHT);
		
		btnLogin.setOnAction( e -> btnBackClicked());

		root.setBottom(bottomVBox);

		//add to scene
		root.setCenter(vbox);
		
	
	}

	private void buttonClicked(TextField txtUserName, PasswordField pf) {
		
		String username = txtUserName.getText();
		
		String password = pf.getText();
		Integer hashcode = password.hashCode();
		password = hashcode.toString();
	
	
		try {
			UserDataAccessor.insertUser(username, password);
			Main.window.setScene(Main.logInScene);
		} catch (SQLException e) {
			e.printStackTrace();
		}

			
	}
	
	private void btnBackClicked(){
		Main.window.setScene(Main.logInScene);
	}


	
}
		
