package br.com.atomicsolutions.component;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import br.com.atomicsolutions.proton.Proton;

public class Parametros_Selecao_Busca {
	public static void Run(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		Proton.startComponent();
		
		String ida = "congo";
		String volta = "sdu";

		String diaIda = "15";
		String mesIda = "10";
		String anoIda = "2018";
		
		String diaVolta = "22";
		String mesVolta = "10";
		String anoVolta = "2018";
		
		driver.findElement(By.xpath("//div[@id = 'purchase-box']//a[@class = 'chosen-single chosen-default']/span[@class = 'chosen-placeholder-origin']")).click();
		driver.findElement(By.id("header-chosen-origin")).sendKeys(ida);
		driver.findElement(By.id("header-chosen-origin")).sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//div[@class = 'purchase-box-header-division division-input division-input-destiny']")).click();
		driver.findElement(By.id("header-chosen-destiny")).sendKeys(volta);
		driver.findElement(By.id("header-chosen-destiny")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("datepickerGo")).click();
		driver.findElement(By.xpath("//td[@data-month = '"+ mesIda +"' and @data-year='"+ anoIda +"']/a[text() = '"+ diaIda +"']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("datepickerBack")).click();
		driver.findElement(By.xpath("//td[@data-month = '"+ mesVolta +"' and @data-year='"+ anoVolta +"']/a[text() = '"+ diaVolta +"']")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.id("btn-box-buy")).click();
		
		Proton.endComponent();
	}
}
