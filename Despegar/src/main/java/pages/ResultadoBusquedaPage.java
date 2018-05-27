package pages;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.utilidades;
import utilities.utilidades.Excel;

public class ResultadoBusquedaPage {
	
	WebDriver driver;
	Excel escribirExcel = new Excel();
	
	public void opcionTiquetesDiferentesCompañias() {
		driver.findElement(By.xpath("//*[@id=\"results-visualization-bar-position\"]/results-visualization-bar/div/div/change-view-mode/div/div/em[2]")).click();
	}
	
	public void obtenerItinerarioVuelo(int cantVuelos, int detalle) {
		
		String [][] itinerarioVuelo = new String [cantVuelos][detalle];
		int ubicacion = 1;
		
		for (int cont=0; cont<cantVuelos; cont++)
		{
			for (int cont2=1; cont2<detalle; cont2++) {
				
				//Hora
				itinerarioVuelo [cont][cont2-1] = driver.findElement(By.xpath("//*[@id=\"clusters\"]/span["+ubicacion+"]/span/cluster/div/div/span/div/div/span/route-choice/ul/li/route/itinerary/div/span/itinerary-element[2]/span/span/span")).getText();				
				
				//Precio
				itinerarioVuelo [cont][cont2] = driver.findElement(By.xpath("//*[@id='clusters']/span["+ubicacion+"]/span/cluster/div/div/span/fare/span/span/main-fare/span/span[2]/flights-price/span/flights-price-element/span/span/em/span[2]")).getText();
//				itinerarioVuelo [cont][cont2] = driver.findElement(By.xpath("//*[@id="clusters"]/span["+ubicacion+"]/span/cluster/div/div/span/fare/span/span/main-fare/span/span[2]/flights-price/span/flights-price-element/span/span/em/span[2])).getText();
			}
			ubicacion++;
		}
		
		Excel.escribirExcel(itinerarioVuelo);
					
	}
	

	//Constructor
	public ResultadoBusquedaPage(WebDriver driver) {
		this.driver = driver;
	}

}
