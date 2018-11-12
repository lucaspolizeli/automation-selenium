package br.com.atomicsolutions.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.atomicsolutions.proton.Proton;

public class Selecionar_Lugar_GOL {
	public static void Run(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		Proton.startComponent();
		
		driver.findElement(By.xpath("(//div[@data-journey='1']//a[@class='seatTypeGolComfort txtIndentSeat'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Escolher GOL+ Conforto' and @class='btnContinue btnContinueNew btnSeatMapClose_C']")).click();
		
		driver.findElement(By.xpath("(//div[@data-journey='2']//div[@class='seatWhite']//a[@class='seatTypeGolComfort txtIndentSeat'])[1]")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@value='Escolher GOL+ Conforto' and @id='btnSeatMapClose']")).click();
		
		Proton.endComponent();
	}
}
