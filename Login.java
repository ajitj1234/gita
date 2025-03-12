package Intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String name = "rahul";

		WebDriver driver = new ChromeDriver();
		String word = Password(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(word);
		driver.findElement(By.xpath("//button[@class=\"submit signInBtn\"]")).click();
		System.out.println(driver.findElement(By.xpath("//p[text()=\"You are successfully logged in.\"]")).getText());
		driver.findElement(By.className("logout-btn")).click();

	}

	private static String Password(WebDriver driver) throws InterruptedException {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//div/a[text()=\"Forgot your password?\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class=\"reset-pwd-btn\"]")).click();
		String password = driver.findElement(By.xpath("//p[@class=\"infoMsg\"]")).getText();
		System.out.println(password);
		String[] pass = password.split("'");
		System.out.println(pass[1]);
		String word = pass[1];
		return word;

	}

}
