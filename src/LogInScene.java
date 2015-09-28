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

public class LogInScene extends Scene {
	
	private final Stage primaryStage;
	private final BorderPane root;
	
	private String password;
	
	private MySQLConnection ntnuMySql;
	private List<User> userList = new ArrayList<>();
	
	public LogInScene(Stage primaryStage) {
		
		//Definerer alt n�dvendig
		super(new BorderPane(), Main.WIDTH, Main.HEIGHT);
		root = (BorderPane) super.getRoot();
		this.primaryStage = primaryStage;
		getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		

		
		//Title lable
		Label title = new Label("ToDoList");
		title.setId("title");
		
		
		//Form
		TextField txtUserName = new TextField();
		txtUserName.setPromptText("Brukernavn");
		txtUserName.setMaxWidth(150);
		//txtUserName.setFocusTraversable(false);
		
		
		PasswordField pf = new PasswordField();
		pf.setPromptText("Password");
		pf.setMaxWidth(150);
		//pf.setFocusTraversable(false);
		
		//Creating layout
		VBox vbox = new VBox(5);		
		Button btnLogin = new Button("Login");
		//btnLogin.setFocusTraversable(false);
		btnLogin.setId("button");
		
		btnLogin.setOnAction( e -> buttonClicked(txtUserName, pf));
		vbox.getChildren().addAll(title, txtUserName, pf, btnLogin);
		vbox.setAlignment(Pos.CENTER);
		
		//SignUpButton
		Button btnSignUp = new Button("Sign up");
		VBox bottomVBox = new VBox();
		btnSignUp.setId("btnSignUp");
		bottomVBox.getChildren().add(btnSignUp);
		bottomVBox.setAlignment(Pos.BOTTOM_RIGHT);
		
		btnSignUp.setOnAction( e -> btnSignUpClicked());

		root.setBottom(bottomVBox);
		

		//add to scene
		root.setCenter(vbox);
		
	
	}

	private void buttonClicked(TextField txtUserName, PasswordField pf) {
		if (validateLogIn(txtUserName, pf)){
			Main.listScene = new ListScene(primaryStage);
			
			Main.window.setScene(Main.listScene);	
		}
			
	}

	private boolean validateLogIn(TextField txtUserName, PasswordField pf) {
		try {
			userList = UserDataAccessor.getUserList();
			for(int i = 0; i < userList.size(); i++){
				User user = userList.get(i);
				
				if (user.getUsername().equals(txtUserName.getText())){
					if (user.getPassword().equals(pf.getText().hashCode())){
						Main.loggedInUser = user;
						return true;	
					};
				};
			
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void btnSignUpClicked() {
			Main.newUserScene = new newUserScene(primaryStage);	
			Main.window.setScene(Main.newUserScene);	
		}
}
			
	
		
