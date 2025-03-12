package Intro;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//selected or not
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
		//get count
		System.out.println(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size());
		System.out.println(driver.getCurrentUrl());
		//switch window
		driver.findElement(By.className("class1")).click();
		Set<String> window= driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		String p = it.next();
		String c = it.next();
		driver.switchTo().window(c);
		System.out.println(driver.getCurrentUrl());
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[@href=\"https://www.udemy.com/user/testing-minds/\"])[2]")).click();
		driver.switchTo().window(p);
		driver.findElement(By.id("hide-textbox")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id=\"displayed-text\"]")).isDisplayed());
		driver.findElement(By.id("show-textbox")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id=\"displayed-text\"]")).isDisplayed());
		driver.findElement(By.xpath("//input[@id=\"displayed-text\"]")).sendKeys("ajit");
		Actions a= new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//button[@id=\"mousehover\"]"))).build().perform();
		WebElement top = driver.findElement(By.xpath("//a[@href=\"#top\"]"));
        top.click();
        driver.findElement(By.id("checkBoxOption2")).click();
        WebElement frm = driver.findElement(By.xpath("//iframe[@id=\"courses-iframe\"]"));
        driver.switchTo().frame(frm);
        driver.findElement(By.xpath("(//a[text()=\"Blog\"])[1]")).click();
        
        
	}

}
