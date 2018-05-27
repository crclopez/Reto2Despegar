package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import configurations.ShareDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.DespegarPpalPage;
import pages.ResultadoBusquedaPage;
import utilities.utilidades;

public class BusquedaItinerarioVueloSteps {

	WebDriver driver;
	DespegarPpalPage despegarPpalPage;
	ResultadoBusquedaPage resultadoBusquedaPage;
	
	//Constructor
	public BusquedaItinerarioVueloSteps(ShareDriver shareDriver, DespegarPpalPage despegarPpalPage,
			ResultadoBusquedaPage resultadoBusquedaPage) {
		this.driver = shareDriver;
		this.despegarPpalPage = despegarPpalPage;
		this.resultadoBusquedaPage = resultadoBusquedaPage;
	}
	
	@Given ("el usuario esta en la pagina principal de despegar")
	public void usuarioEstaEnPaginaPpal () {
		driver.get("https://www.despegar.com.co/");
		driver.manage().window().maximize();
		despegarPpalPage.cerrarMensajeEmergente();
		
	System.out.println("Usuario ingreso a la pagina principal");
	}
	
	@When ("se elige la opcion vuelos")
	public void clickVuelos() {
		despegarPpalPage.linkSoloVuelos();
	}
	
	@And ("^selecciona la ciudad de origen \"(.*)$")
	public void digitaCiudadOrigen(String origen) {
		despegarPpalPage.campoOrigen(origen);
//		despegarPpalPage.tipoPaquete();
		System.out.println("Usuario ingreso la ciudad de origen");
	}
	
	@And ("^escoge la ciudad de destino \"(.*)$")
	public void digitaCiudadDestino(String destino) {
		despegarPpalPage.campoDestino(destino);
		System.out.println("Usuario ingreso la ciudad destino");
	}
	
	@And ("^la fecha de inicio \"(.*)$")
	public void seleccionarFechaInicio (String fechaInicio) {
		despegarPpalPage.camposFechaInicio();
		Integer i = utilidades.calcularMesFecha(fechaInicio);
		
		for (Integer cont = 0; cont<i; cont++) {
			despegarPpalPage.flechaCambioMesFuturo();
		}
		
		despegarPpalPage.seleccionarDiaFechaInicio(utilidades.calcularDiaFecha(fechaInicio));
		System.out.println("Usuario ingreso la fecha de inicio "+fechaInicio);
	}
	
	@And ("^de fin \"(.*)$")
	public void seleccionarFechaFin (String fechaFin) {
		despegarPpalPage.campoFechaFin();
		despegarPpalPage.campoFechaFin();		
		despegarPpalPage.seleccionarDiaFechaFin(utilidades.calcularDiaFecha(fechaFin));
		System.out.println("Usuario ingreso la fecha de fin "+fechaFin);
	}
	
	@And ("^cantidad de viajeros \"(.*)$")
	public void seleccionarCantidadViajeros (String cantidadViajeros) {
		despegarPpalPage.campoSeleccionarNumeroViajeros();
		despegarPpalPage.botonAumentarCantViajeros();
	}
	
	@And ("presiona el boton Buscar")
	public void presionarBotonBuscar() {
		despegarPpalPage.botonBuscar();
		System.out.println("El usuario presiona el boton buscar");
	}
	
	@And ("ordena de menor a mayor los registros arrojados por la busqueda")
	public void presionarOpcionTiquetesDiferentesCompanias() {
		resultadoBusquedaPage.opcionTiquetesDiferentesCompañias();
		System.out.println("Registros ya ordenados por precio de menor a mayor");
	}
	
	@And ("almacena los registros en un archivo de excel")
	public void almacenarRegistrosEnExcel() throws Exception {
		resultadoBusquedaPage.obtenerItinerarioVuelo(7,2);	
		System.out.println("El archivo con el resultado de las busquedas esta en la ruta D: y su nombre es tiquetesDespegar.xlsx");
	}
	
	@Then ("se muestre el registro de menor valor restado en verde")
	public void pintarValorMenorEnVerde() {
		
	}

}
