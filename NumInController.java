package lottotest;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class NumInController implements Initializable {

	@FXML private TextField tfn1 = new TextField();
	@FXML private TextField tfn2 = new TextField();
	@FXML private TextField tfn3 = new TextField();
	@FXML private TextField tfn4 = new TextField();
	@FXML private TextField tfn5 = new TextField();
	@FXML private TextField tfn6 = new TextField();
	@FXML private TextField tfbN = new TextField();
	
	@FXML private Button btNumIn = new Button();
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btNumIn.setOnAction(event->numIn(event));
	}
	
	public void numIn(ActionEvent event) {
		
		int n1 = Integer.parseInt(tfn1.getText().toString());
		int n2 = Integer.parseInt(tfn2.getText().toString());
		int n3 = Integer.parseInt(tfn3.getText().toString());
		int n4 = Integer.parseInt(tfn4.getText().toString());
		int n5 = Integer.parseInt(tfn5.getText().toString());
		int n6 = Integer.parseInt(tfn6.getText().toString());
		int bN = Integer.parseInt(tfbN.getText().toString());//db조회 함수에 넣기위해 저장
		
		if((0 < n1 && n1 < 46) && (0 < n2 && n2 < 46) && (0 < n3 && n3 < 46)&& (0 < n4 && n4 < 46)&& (0 < n5 && n5 < 46) && (0 < n6 && n6 < 46)&& (0 < bN && bN < 46)) {
			
			lotto_input(n1,n2,n3,n4,n5,n6,bN);
			
			tfClean(); //텍스트필드 초기화 메서드
			
			Alert alert = new Alert(AlertType.INFORMATION);//갱신 알림창 띄움
			alert.setTitle("값 갱신 완료");
			alert.setHeaderText("값 갱신 완료");
			alert.setContentText("값 갱신 성공을 알림");

			alert.showAndWait();
		}
		else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("잘못된 값");
			alert.setHeaderText("값 미입력 또는 경계 값 벗어남");
			alert.setContentText("값은 꼭 입력해야합니다. (1~45 사이의 정수)");

			alert.showAndWait();
		}
//		else if() {
//			Alert alert = new Alert(AlertType.WARNING);
//			alert.setTitle("잘못된 값");
//			alert.setHeaderText("값 미입력 또는 경계 값 벗어남");
//			alert.setContentText("값은 꼭 입력해야합니다. (1~45 사이의 정수)");
//
//			alert.showAndWait();
//		}
	}
	public void lotto_input(int n1, int n2, int n3, int n4, int n5, int n6, int bN){
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException ee) {
			System.exit(0);
		}
		String db_url = "jdbc:mysql://localhost:3306/lotto?useUnicode=true&characterEncoding=utf8";
		String db_id = "root";
		String db_pw = "qwer";
		
		try {
			Connection conn = DriverManager.getConnection(db_url, db_id, db_pw);
			String sql = "INSERT INTO test (n1, n2, n3, n4, n5 ,n6 ,bonusNum) VALUES (?, ?, ?, ?, ?, ?, ?);";
					PreparedStatement psmt = conn.prepareStatement(sql);
					psmt.setInt(1, n1);
					psmt.setInt(2, n2);
					psmt.setInt(3, n3);
					psmt.setInt(4, n4);
					psmt.setInt(5, n5);
					psmt.setInt(6, n6);
					psmt.setInt(7, bN);
					psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void tfClean() {
		tfn1.setText("");
		tfn2.setText("");
		tfn3.setText("");
		tfn4.setText("");
		tfn5.setText("");
		tfn6.setText("");
		tfbN.setText("");
		
	}

}
