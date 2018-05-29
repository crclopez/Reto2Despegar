package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.utilidades;

public class DespegarPpalPage {
	
WebDriver driver;
	
	public String obtenerTituloMensajeEmergente () {
		return driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/div/h3")).getText();
	}
	
	public void cerrarMensajeEmergente() {
		utilidades.Wait(driver, 2);
		driver.findElement(By.xpath("/html/body/div[16]/div/div[1]/span")).click();
	}
	
	public void linkSoloVuelos() {
		driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/ul/li[2]/a")).click();
	}
	
	public void tipoPaquete() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div/div/div/div[2]/div[2]/div/div/div[1]/label/div/span[2]")).click();
	}
	
	public void campoOrigen(String origen) {
		utilidades.Wait(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(origen);
		utilidades.Wait(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[1]/div/div/div/input")).sendKeys(Keys.ENTER);
	}
	
	public void campoDestino(String destino) {
		utilidades.Wait(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).clear();
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(destino);
		utilidades.Wait(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[1]/div/div[2]/div/div/div/div/input")).sendKeys(Keys.ENTER);
	}
	
	public void camposFechaInicio () {
		utilidades.Wait(driver, 2);
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/input")).click();
	}
	
	public void flechaCambioMesFuturo () {
		driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]")).click();
	}
	
	public void flechaCambioMesPasado () {
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div[1]/i")).click();
	}
	
	public void seleccionarDiaFechaInicio(String mesConteo, int diaInicio) {
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[" + mesConteo + "]/div[4]/span["+ diaInicio +"]")).click();
	}
	
	public void campoFechaFin() {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[4]")).click();
	}
	
	public void seleccionarDiaFechaFin(String mesConteo, int diaFin) {
		driver.findElement(By.xpath("/html/body/div[4]/div/div[4]/div[" + mesConteo + "]/div[4]/span["+ diaFin + "]")).click();
	}
	
	public void campoSeleccionarNumeroViajeros () {
		driver.findElement(By.xpath("//*[@id=\"searchbox-sbox-all-boxes\"]/div[2]/div/div/div[3]/div[2]/div[1]/div[2]/div[2]/div[6]/div[2]/div/input")).click();
	}
	
	public void botonAumentarCantViajeros() {
		utilidades.Wait(driver, 1);
		//Click sobre el boton de aumento de pasajeros
		WebElement plus= driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[2]")); 
		JavascriptExecutor js= (JavascriptExecutor ) driver;
		
		js.executeScript("arguments[0].click();", plus);	
	}
	
	public void botonDisminuirCantViajeros() {
		utilidades.Wait(driver, 2);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div/a[1]")).click();
	}
	
	public void botonAplicarSelCantViajeros() {
		utilidades.Wait(driver, 1);
		driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/a")).click();
	}
	
	public void botonBuscar () {
		driver.findElement(By.linkText("Buscar")).click();
	}
	
	public String MensajeDeErrorDestino() {
		return driver.findElement(By.cssSelector("span.validation-msg.sbox-bind-show-error-tooltip-segment-1-equal-destination")).getText();
	}
	
	public String MensajeDeErrorFechaRegreso() {
		return driver.findElement(By.cssSelector("span.validation-msg")).getText();
	}
	
	//Constructor
	public DespegarPpalPage(WebDriver driver) {
		this.driver = driver;
	}
}
