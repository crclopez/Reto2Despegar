package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DespegarPpalPage {
	
WebDriver driver;
	
	public String obtenerTituloMensajeEmergente () {
		return driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/div/h3")).getText();
	}
	
	public void cerrarMensajeEmergente() {
		driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span")).click();
	}
	
	public void linkSoloVuelos() {
		driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/ul/li[2]/a")).click();
	}
	
	public void tipoPaquete() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[2]/div[2]/div/div/div[1]/label/div/span[2]")).click();
	}
	
	public void campoOrigen(String origen) {
//		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input")).clear();
//		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/input")).sendKeys(origen);
//		List <WebElement>  listItemsO = driver.findElements(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/div/div[2]"));
//		listItemsO.get(0).click();
		
		esperarSegundos(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(origen);
	}
	
	public void campoDestino(String destino) {
//		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input")).clear();
//		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(destino);
//		List <WebElement> listItemsD = driver.findElements(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[3]/div/div[1]/div/div[1]/div/div/div/div/div[2]"));
//		listItemsD.get(0).click();
		esperarSegundos(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(destino);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	}
	
	public void camposFechaInicio () {
		esperarSegundos(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input")).click();
	}
	
	public void flechaCambioMesFuturo () {
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]")).click();
	}
	
	public void flechaCambioMesPasado () {
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[1]/i")).click();
	}
	
	public void seleccionarDiaFechaInicio(int diaInicio) {
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[6]/div[4]/span["+ diaInicio +"]")).click();
	}
	
	public void campoFechaFin() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]")).click();
	}
	
	public void seleccionarDiaFechaFin(int diaFin) {
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[6]/div[4]/span["+ diaFin + "]")).click();
	}
	
	public void campoSeleccionarNumeroViajeros () {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div/input")).click();
	}
	
	public void botonAumentarCantViajeros() {
//		driver.findElement(By.cssSelector("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")).click();
	}
	
	public void botonDisminuirCantViajeros() {
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[1]")).click();
	}
	
	public void botonAplicarSelCantViajeros() {
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[1]")).click();
	}
	
	public void botonBuscar () {
		driver.findElement(By.linkText("Buscar")).click();
	}
	
	public void esperarSegundos(WebDriver driver, int segundos){
	      synchronized(driver){
	         try {
	            driver.wait(segundos * 1000);
	         } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	   } 
	
	//Constructor
	public DespegarPpalPage(WebDriver driver) {
		this.driver = driver;
	}
}
