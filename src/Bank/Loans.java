package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Statement;

import extras.Constants;

public class Loans {
	private Scanner scanner ;
	private Statement stmt;
	private Connection conn;
	Loans()
	{
		try {
			Class.forName(Constants.JDBC_DRIVER);
			conn = (Connection) DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASS);
			stmt = (Statement) 	conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public int addNewLoan(int LoanAccNumber,float loanAmount,float interestRate,String due_date) throws SQLException
	{
		int LoanId=(int)(Math.random()*999999);
		String query= "INSERT INTO Loan (LoanID, LAccNum, LAmount, LInterestRate, DueTime) VALUES	("+
						LoanId+","+LoanAccNumber+","+loanAmount+","+interestRate+",'"+due_date+"');";
		stmt.executeQuery(query);
		return LoanId;
		
	}

}
