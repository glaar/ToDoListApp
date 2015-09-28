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

public class ListScene extends Scene {
	
	private final Stage primaryStage;
	private final BorderPane root;
	
	private MySQLConnection ntnuMySql;
	private List<Task> taskList = new ArrayList<>();
	
	
	public ListScene(Stage primaryStage) {

		
		//Definerer alt n�dvendig
		super(new BorderPane(), Main.WIDTH, Main.HEIGHT);
		root = (BorderPane) super.getRoot();
		this.primaryStage = primaryStage;
		getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		
		//Title lable
		Label title = new Label(Main.loggedInUser.getUsername());
		title.setId("title");
		
		//Add list item
		TextField addItem = new TextField();	
		addItem.setPromptText("Add item...");
		Button btnAdd = new Button("Add");
		btnAdd.setId("add-button");
		btnAdd.setOnAction( e -> btnAddClicked(addItem));
		
		
		HBox addItemBox = new HBox(15);
		addItemBox.setPadding(new Insets(0, 0, 20, 0));
		addItemBox.setAlignment(Pos.CENTER);
		addItemBox.getChildren().addAll(addItem, btnAdd);
		
		//SignOutButton
		Button btnSignOut = new Button("Sign out");
		btnSignOut.setId("signout-button");
		addItemBox.getChildren().add(btnSignOut);
		btnSignOut.setOnAction( e -> buttonClicked());
		
		
		root.setBottom(addItemBox);
		
		
		
		//Liste
		VBox liste = new VBox(5);
		liste.setAlignment(Pos.CENTER);
		
		try {
			taskList = TaskDataAccessor.getTaskList(Main.loggedInUser.getIdusers());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		for (int i = 0; i < taskList.size(); i++){
			
			int idtask = taskList.get(i).getIdtask();
			
			HBox row = new HBox(25);
			row.setAlignment(Pos.CENTER);
			Label item = new Label(taskList.get(i).getDesc());
			item.setId("item");
			Button btnDelete = new Button("Delete");
			btnDelete.setOnAction( e -> btnDeleteClicked(idtask));
			btnDelete.setId("delete-button");
			row.getChildren().addAll(item, btnDelete);
			liste.getChildren().add(row);
	
		}
			
		
		root.setCenter(liste);
		
		
		//Creating Layouts
		
		VBox topVBox = new VBox(10);
		topVBox.setPadding(new Insets(50, 0, 0, 0));
		topVBox.getChildren().add(title);
		topVBox.setAlignment(Pos.CENTER);
		
		
		root.setTop(topVBox);
		
		
	}
	

	private void btnDeleteClicked(int idtask) {
		try {
			TaskDataAccessor.deleteTask(idtask);
			Main.listScene = new ListScene(primaryStage);
			Main.window.setScene(Main.listScene);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void buttonClicked() {
		Main.window.setScene(Main.logInScene);
	}
	
	private void btnAddClicked(TextField addItem){
		try {
			TaskDataAccessor.insertTask(Main.loggedInUser.getIdusers(), addItem.getText());
			Main.listScene = new ListScene(primaryStage);
			Main.window.setScene(Main.listScene);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
		
