package br.com.atomicsolutions.cometa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Cometa {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String localIda = "Santo André";
		String localPara = "Guarujá";
		
		driver.manage().window().maximize();
		driver.get("http://www.viacaocometa.com.br");
		
		Thread.sleep(2000);
		driver.findElement(By.id("origin-sidebar")).sendKeys(localIda);
		
		driver.findElement(By.id("destination-sidebar")).sendKeys(localPara);
		driver.findElement(By.id("destination-sidebar")).sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//td[@data-month = '10' and @data-year='2018']/a[@class='ui-state-default' and text() = '1']"));
		

	}

}
