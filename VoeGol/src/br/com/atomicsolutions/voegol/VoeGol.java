package br.com.atomicsolutions.voegol;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VoeGol {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\DriverChrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.voegol.com.br/pt");
		driver.manage().window().maximize();
		
		String ida = "congo";
		String volta = "sdu";
		String HoraIda = "15:40";
		String HoraVolta = "6:10";
		
		driver.findElement(By.xpath("//div[@id = 'purchase-box']//a[@class = 'chosen-single chosen-default']/span[@class = 'chosen-placeholder-origin']")).click();
		driver.findElement(By.id("header-chosen-origin")).sendKeys(ida);
		driver.findElement(By.id("header-chosen-origin")).sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//div[@class = 'purchase-box-header-division division-input division-input-destiny']")).click();
		driver.findElement(By.id("header-chosen-destiny")).sendKeys(volta);
		driver.findElement(By.id("header-chosen-destiny")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("btn-box-buy")).click();

		driver.findElement(By.xpath("(//*[@id='flightsFilter01']/../../..//div[@class = 'infoScale' and contains(span, '"+ HoraIda +"')]/../../../..//td[@class = 'taxa taxaExecutiva'])[(1)]")).click();
		driver.findElement(By.xpath("(//*[@id='flightsFilter02']/../../..//div[@class = 'infoScale' and contains(span, '"+ HoraVolta +"')]/../../../..//td[@class = 'taxa taxaExecutiva'])[(2)]")).click();
		
		driver.findElement(By.xpath("//input[@value = 'Continuar']")).click();
		
		driver.findElement(By.xpath(""));
	}

}
