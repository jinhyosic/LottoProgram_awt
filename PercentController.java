package lottotest;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PercentController implements Initializable{
	@FXML private Button btPercent = new Button();
	@FXML private Button btClear = new Button();
	
	@FXML private TextField tfn1 = new TextField();
	@FXML private TextField tfn2 = new TextField();
	@FXML private TextField tfn3 = new TextField();
	@FXML private TextField tfn4 = new TextField();
	@FXML private TextField tfn5 = new TextField();
	@FXML private TextField tfn6 = new TextField();
	@FXML private TextField tfbN = new TextField();
	
	@FXML private Label lbN1 = new Label();
	@FXML private Label lbN2 = new Label();
	@FXML private Label lbN3 = new Label();
	@FXML private Label lbN4 = new Label();
	@FXML private Label lbN5 = new Label();
	@FXML private Label lbN6 = new Label();
	@FXML private Label lbbN = new Label();
	
	int n1;
	int n2;
	int n3;
	int n4;
	int n5;
	int n6;
	int bN;
	
//db��ȸ �Լ��� �ֱ����� ����
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		btPercent.setOnAction(event->percent(event));
		btClear.setOnAction(event->btClear(event));
		
	}
	
	public void btClear(ActionEvent event) {
		
		tfClean(); //�ؽ�Ʈ�ʵ� �ʱ�ȭ �޼���
	}

	public void percent(ActionEvent event) {
		
	
		int n1 = Integer.parseInt(tfn1.getText().toString());
		int n2 = Integer.parseInt(tfn2.getText().toString());
		int n3 = Integer.parseInt(tfn3.getText().toString());
		int n4 = Integer.parseInt(tfn4.getText().toString());
		int n5 = Integer.parseInt(tfn5.getText().toString());
		int n6 = Integer.parseInt(tfn6.getText().toString());
		int bN = Integer.parseInt(tfbN.getText().toString());
//		int n1 = 0;
//		int n2 = 0;
//		int n3 = 0;
//		int n4 = 0;
//		int n5 = 0;
//		int n6 = 0;
//		int bN = 0;
//
//tfTest(tfn1.getText().toString(),n1);
//		tfTest(tfn2,n2);
//		tfTest(tfn3,n3);
//		tfTest(tfn4,n4);
//		tfTest(tfn5,n5);
//		tfTest(tfn6,n6);
//		tfTest(tfbN,bN);
//		
		if((0 < n1 && n1 < 46) && (0 < n2 && n2 < 46) && (0 < n3 && n3 < 46)&& (0 < n4 && n4 < 46)&& (0 < n5 && n5 < 46) && (0 < n6 && n6 < 46)&& (0 < bN && bN < 46)) {
			
			lotto_persent();
			
		}
		else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("�߸��� ��");
			alert.setHeaderText("�� ���Է� �Ǵ� ��� �� ���");
			alert.setContentText("���� �� �Է��ؾ��մϴ�. (1~45 ������ ����)");

			alert.showAndWait();
		}
	}
public void lotto_persent() {

	double rs1 = 0.0;
	double rs2 = 0.0;
	double rs3 = 0.0;
	double rs4 = 0.0;
	double rs5 = 0.0;
	double rs6 = 0.0;
	double rsbn = 0.0; //��÷��ȣ ��з� ���
//	int tot = 0; //�ζ� �� ȸ��.
	
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
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
			
//			String sqlt = "select count(1) from test;";
//			psmtt = conn.prepareStatement(sqlt); //
//			tot = psmtt.executeUpdate();
			
			
			String sql = "select * from test;";
			psmt = conn.prepareStatement(sql); 
			rs = psmt.executeQuery();
			int n1c = 0;
			int n2c = 0;
			int n3c = 0;
			int n4c = 0;
			int n5c = 0;
			int n6c = 0;
			int nbc = 0; //��÷��ȣ ���� ��ġ Ƚ�� ī��Ʈ
			int tot = 0; //�ζ��� �� ȸ��.
			while(rs.next()) {
				int n1 = rs.getInt("n1");
				int n2 = rs.getInt("n2");
				int n3 = rs.getInt("n3");
				int n4 = rs.getInt("n4");
				int n5 = rs.getInt("n5");
				int n6 = rs.getInt("n6");
				int bN = rs.getInt("bonusNum");
				//��񿡼� ������ ����� ���ϸ� �ζ� Ȯ�� �̾Ƴ� ���� n1p�� ���� ��ȹ.
				//�׽�Ʈ �ڵ� System.out.println(n1 +" "+ n2 + " " +n3);
				
				//ù��° �ؽ�Ʈ�ʵ�� ���ݱ��� ��� �ζ� ��÷��ȣ�� �� ���� �� Ȯ���� �ø�
				if(n1==(Integer.parseInt(tfn1.getText().toString()))){
					n1c++;
				}
				if(n2==(Integer.parseInt(tfn1.getText().toString()))) {
					n1c++;
				}
				if(n3==(Integer.parseInt(tfn1.getText().toString()))) {
					n1c++;
				}
				if(n4==(Integer.parseInt(tfn1.getText().toString()))) {
					n1c++;
				}
				if(n5==(Integer.parseInt(tfn1.getText().toString()))) {
					n1c++;
				}
				if(n6==(Integer.parseInt(tfn1.getText().toString()))) {
					n1c++;
				}
				if(bN==(Integer.parseInt(tfn1.getText().toString()))) {
					n1c++;
				}
				//�ι�° �ؽ�Ʈ�ʵ�
				if(n1==(Integer.parseInt(tfn2.getText().toString()))){
					n2c++;
				}
				if(n2==(Integer.parseInt(tfn2.getText().toString()))) {
					n2c++;
				}
				if(n3==(Integer.parseInt(tfn2.getText().toString()))) {
					n2c++;
				}
				if(n4==(Integer.parseInt(tfn2.getText().toString()))) {
					n2c++;
				}
				if(n5==(Integer.parseInt(tfn2.getText().toString()))) {
					n2c++;
				}
				if(n6==(Integer.parseInt(tfn2.getText().toString()))) {
					n2c++;
				}
				if(bN==(Integer.parseInt(tfn2.getText().toString()))) {
					n2c++;
				}
				//����° �ؽ�Ʈ�ʵ�
				if(n1==(Integer.parseInt(tfn3.getText().toString()))){
					n3c++;
				}
				if(n2==(Integer.parseInt(tfn3.getText().toString()))) {
					n3c++;
				}
				if(n3==(Integer.parseInt(tfn3.getText().toString()))) {
					n3c++;
				}
				if(n4==(Integer.parseInt(tfn3.getText().toString()))) {
					n3c++;
				}
				if(n5==(Integer.parseInt(tfn3.getText().toString()))) {
					n3c++;
				}
				if(n6==(Integer.parseInt(tfn3.getText().toString()))) {
					n3c++;
				}
				if(bN==(Integer.parseInt(tfn3.getText().toString()))) {
					n3c++;
				}
				//�׹�° �ؽ�Ʈ�ʵ�
				if(n1==(Integer.parseInt(tfn4.getText().toString()))){
					n4c++;
				}
				if(n2==(Integer.parseInt(tfn4.getText().toString()))) {
					n4c++;
				}
				if(n3==(Integer.parseInt(tfn4.getText().toString()))) {
					n4c++;
				}
				if(n4==(Integer.parseInt(tfn4.getText().toString()))) {
					n4c++;
				}
				if(n5==(Integer.parseInt(tfn4.getText().toString()))) {
					n4c++;
				}
				if(n6==(Integer.parseInt(tfn4.getText().toString()))) {
					n4c++;
				}
				if(bN==(Integer.parseInt(tfn4.getText().toString()))) {
					n4c++;
				}
				//�ټ�° �ؽ�Ʈ�ʵ�
				if(n1==(Integer.parseInt(tfn5.getText().toString()))){
					n5c++;
				}
				if(n2==(Integer.parseInt(tfn5.getText().toString()))) {
					n5c++;
				}
				if(n3==(Integer.parseInt(tfn5.getText().toString()))) {
					n5c++;
				}
				if(n4==(Integer.parseInt(tfn5.getText().toString()))) {
					n5c++;
				}
				if(n5==(Integer.parseInt(tfn5.getText().toString()))) {
					n5c++;
				}
				if(n6==(Integer.parseInt(tfn5.getText().toString()))) {
					n5c++;
				}
				if(bN==(Integer.parseInt(tfn5.getText().toString()))) {
					n5c++;
				}
				//����° �ؽ�Ʈ�ʵ�
				if(n1==(Integer.parseInt(tfn6.getText().toString()))){
					n6c++;
				}
				if(n2==(Integer.parseInt(tfn6.getText().toString()))) {
					n6c++;
				}
				if(n3==(Integer.parseInt(tfn6.getText().toString()))) {
					n6c++;
				}
				if(n4==(Integer.parseInt(tfn6.getText().toString()))) {
					n6c++;
				}
				if(n5==(Integer.parseInt(tfn6.getText().toString()))) {
					n6c++;
				}
				if(n6==(Integer.parseInt(tfn6.getText().toString()))) {
					n6c++;
				}
				if(bN==(Integer.parseInt(tfn6.getText().toString()))) {
					n6c++;
				}
				//���ʽ���ȣ �ؽ�Ʈ�ʵ�
				if(n1==(Integer.parseInt(tfbN.getText().toString()))){
					nbc++;
				}
				if(n2==(Integer.parseInt(tfbN.getText().toString()))) {
					nbc++;
				}
				if(n3==(Integer.parseInt(tfbN.getText().toString()))) {
					nbc++;
				}
				if(n4==(Integer.parseInt(tfbN.getText().toString()))) {
					nbc++;
				}
				if(n5==(Integer.parseInt(tfbN.getText().toString()))) {
					nbc++;
				}
				if(n6==(Integer.parseInt(tfbN.getText().toString()))) {
					nbc++;
				}
				if(bN==(Integer.parseInt(tfbN.getText().toString()))) {
					nbc++;
				}
				///////////////////////////////
				tot++; //�ζ� �� ȸ����ŭ ����
			}
			
			//Ȯ������
			rs1 = Math.round(((((double)n1c/(double)tot) * 100.0))*100)/100.0;
			rs2 = Math.round(((((double)n2c/(double)tot) * 100.0))*100)/100.0;
			rs3 = Math.round(((((double)n3c/(double)tot) * 100.0))*100)/100.0;
			rs4 = Math.round(((((double)n4c/(double)tot) * 100.0))*100)/100.0;
			rs5 = Math.round(((((double)n5c/(double)tot) * 100.0))*100)/100.0;
			rs6 = Math.round(((((double)n6c/(double)tot) * 100.0))*100)/100.0;
			rsbn = Math.round(((((double)nbc/(double)tot) * 100.0))*100)/100.0;
		
		
			//Ȯ�� ��� �󺧿� �ֱ�
			lbN1.setText(Double.toString(rs1)+"% ");
			lbN2.setText(Double.toString(rs2)+"% ");
			lbN3.setText(Double.toString(rs3)+"% ");
			lbN4.setText(Double.toString(rs4)+"% ");
			lbN5.setText(Double.toString(rs5)+"% ");
			lbN6.setText(Double.toString(rs6)+"% ");
			lbbN.setText(Double.toString(rsbn)+"% ");
		
			
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
	public void tfTest(String t, int n) {
		if(t.equals("")){
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("�߸��� ��");
			alert.setHeaderText("�� ���Է� �Ǵ� ��� �� ���");
			alert.setContentText("���� �� �Է��ؾ��մϴ�. (1~45 ������ ������ �Է°���)");
			alert.showAndWait();
		}
		else {
			n = Integer.parseInt(t);
		}
	}

}
