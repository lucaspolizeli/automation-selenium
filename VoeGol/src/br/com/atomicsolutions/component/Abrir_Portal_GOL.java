package br.com.atomicsolutions.component;

import org.openqa.selenium.WebDriver;

import br.com.atomicsolutions.proton.Proton;

public class Abrir_Portal_GOL {

	public static void Run(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		Proton.startComponent();
		driver.get(Proton.getProtonValue("in_Portal_Gol"));
		
		Thread.sleep(3000);
		
		String currentWindowHandle = driver.getWindowHandle();
		
		driver.switchTo().window(currentWindowHandle);
		
		Proton.takeScreenShot(driver, "Portal_GOL");
		
		Proton.endComponent();
	}

}
