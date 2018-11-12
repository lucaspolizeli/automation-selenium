package br.com.atomicsolutions.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import br.com.atomicsolutions.proton.Proton;

public class Finalizar_Compra {
	public static void Run(WebDriver driver) throws Exception {
		// TODO Auto-generated method stub
		Proton.startComponent();

		driver.findElement(By.id("UnitMapViewControl2_LinkButtonAssignUnit")).click();
		driver.findElement(By.id("ControlGroupProductsView2_LinkButtonSubmit")).click();

		Proton.endComponent();
	}
}
