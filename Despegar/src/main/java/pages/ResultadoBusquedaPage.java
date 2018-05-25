package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoBusquedaPage {
	
	WebDriver driver;
	
	public void opcionTiquetesDiferentesCompañias() {
		driver.findElement(By.xpath("//*[@id=\"results-visualization-bar-position\"]/results-visualization-bar/div/div/change-view-mode/div/div/em[2]")).click();
	}
	
	public String obtenerPrecioRegistro() {
		return driver.findElement(By.xpath("//*[@id=\"clusters\"]/span[1]/span/cluster/div/div/span/fare/span/span/main-fare/span/span[2]/flights-price/span/flights-price-element/span/span")).getText();
	}
	
	public String obtenerHoraVuelo() {
		return driver.findElement(By.xpath("//*[@id=\"clusters\"]/span[1]/span/cluster/div/div/span/div/div/span/route-choice/ul/li/route/itinerary/div/span/itinerary-element[2]/span/span/span")).getText();
	}

	//Constructor
	public ResultadoBusquedaPage(WebDriver driver) {
		this.driver = driver;
	}

}
