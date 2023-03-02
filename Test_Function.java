package lotto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

class Test_Function{
	
	int n1;
	int n2;
	int n3;
	int n4;
	int n5;
	int n6;
	int bN;
	int n1p; //확률계산변수
	int n2p;
	int n3p;
	int n4p;
	int n5p;
	int n6p;
	int bNp;
	Scanner sc = new Scanner(System.in);
	PreparedStatement psmt = null;
	ResultSet rs = null;
	Test_Function(){
		System.out.println("숫자1번 입력");
		n1 = sc.nextInt();
		System.out.println("숫자2번 입력");
		n2 = sc.nextInt();
		System.out.println("숫자3번 입력");
		n3 = sc.nextInt();
		System.out.println("숫자4번 입력");
		n4 = sc.nextInt();
		System.out.println("숫자5번 입력");
		n5 = sc.nextInt();
		System.out.println("숫자6번 입력");
		n6 = sc.nextInt();
		System.out.println("숫자 보너스번호 입력");
		bN = sc.nextInt();
		
		lotto_input(n1,n2,n3,n4,n5,n6,bN);
		lotto_persent();
	
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
	public void lotto_persent() {
		
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
			String sql = "select *from lotto.test;";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				n1 = rs.getInt("n1");
				n2 = rs.getInt("n2");
				n3 = rs.getInt("n3");
				n4 = rs.getInt("n4");
				n5 = rs.getInt("n5");
				n6 = rs.getInt("n6");
				bN = rs.getInt("bonusNum");
				//디비에서 가져온 값들과 비교하며 로또 확률 뽑아내 변수 n1p에 넣을 계획.
				//테스트 코드 System.out.println(n1 +" "+ n2 + " " +n3);
			}
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
