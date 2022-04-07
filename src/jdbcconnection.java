import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\dell\\Documents\\web drivers\\chromedriver.exe");
		
		WebDriver driver;
		
		
		String host ="localhost";
		String port="3307";
		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/demo","root","1708124281@Sirhem");
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select * from credentials;");
		while(rs.next()) {
			 driver = new ChromeDriver();
			driver.get("https://login.salesforce.com/?locale=in");
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("username"));
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("password"));
			//driver.findElement(By.xpath("//input[@id='Login']")).click();

			//input[@id='Login']
			
			
			//System.out.println(rs.getString("username")+":"+rs.getString("password"));
			
		}

	}

}
