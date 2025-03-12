package Intro;

import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Calendar {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String year= "2030";
		String month="June";
		String day="12";
		String[] expected= {month,day,year};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//span[@class=\"react-calendar__navigation__label__labelText react-calendar__navigation__label__labelText--from\"]")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElement(By.xpath("//abbr[text()='"+month+"']")).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		//Thread.sleep(5000);
		
		List<WebElement> date = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(int j=1;j<date.size();j++)
		{
			System.out.println(date.get(j).getAttribute("value"));
			Assert.assertEquals(date.get(j).getAttribute("value"), expected[j]);
		}
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("page-menu"))).click();
		driver.findElement(By.xpath("//option[@value=\"20\"]")).click();
		driver.findElement(By.xpath("//td[text()=\"Banana\"]")).click();
		
		List<WebElement> dropdown = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println(dropdown.size());
		for(int i=0;i<dropdown.size();i++)
		{
			System.out.println(dropdown.get(i).getText());
				
		}
		driver.findElement(By.id("search-field")).sendKeys("to");
		System.out.println(driver.getTitle());
		
		/*List<WebElement> dateis = driver.findElements(By.xpath("//button[@style=\"flex: 0 0 14.2857%; overflow: hidden; margin-inline-end: 0px;\"]"));
		for(int k=0;k<dateis.size();k++)
		{
			System.out.println(dateis.get(k).getText());
		}*/
		
	}

}
