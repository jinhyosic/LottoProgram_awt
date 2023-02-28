package lottotest;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainController implements Initializable{
	@FXML private Button num_In; //�ζ�ȸ�� ����
	@FXML private Button persent; //Ȯ�� ����
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		num_In.setOnAction(event->num_In(event));
		persent.setOnAction(event->persent(event));
	}

	public void persent(ActionEvent event) { //Ȯ�� ���� ��ư ����
		
		try {
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("percent.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void num_In(ActionEvent event) { //ȸ�� ���� ��ư ����
		
		try {
			Stage primaryStage = new Stage();
			Parent root;
			root = FXMLLoader.load(getClass().getResource("num_In.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
