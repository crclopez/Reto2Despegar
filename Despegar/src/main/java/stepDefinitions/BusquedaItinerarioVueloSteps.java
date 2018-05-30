package stepDefinitions;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import configurations.ShareDriver;
import cucumber.api.java.After;
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

	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given ("el usuario esta en la pagina principal de despegar")
	public void usuarioEstaEnPaginaPpal () {
		driver.get("https://www.despegar.com.co/");
		driver.manage().window().maximize();
		if (despegarPpalPage.ventanaEmergente()) {
			despegarPpalPage.cerrarMensajeEmergente();
		}
		
		System.out.println("Usuario ingreso a la pagina principal");
	}
	
	@When ("se elige la opcion vuelos")
	public void clickVuelos() {
		despegarPpalPage.linkSoloVuelos();
	}
	
	@And ("^selecciona la ciudad de origen \"(.*)$")
	public void digitaCiudadOrigen(String origen) {
		despegarPpalPage.campoOrigen(origen);
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
		
		int RestaMesFechaInicioFechaActual = utilidades.calcularRestaMesFechaInicioMesFechaActual(fechaInicio);
		
		for (int cont = 1; cont<RestaMesFechaInicioFechaActual; cont++) {
			despegarPpalPage.flechaCambioMesFuturo();
		}
		
		String mesConteo = Integer.toString(RestaMesFechaInicioFechaActual);
		despegarPpalPage.seleccionarDiaFechaInicio(mesConteo ,utilidades.calcularDiaFecha(fechaInicio));
		System.out.println("Usuario ingreso la fecha de inicio "+fechaInicio);
	}
	
	@And ("^de fin \"(.*)$")
	public void seleccionarFechaFin (String fechaFin) {
		despegarPpalPage.campoFechaFin();
		despegarPpalPage.campoFechaFin();
		
		int RestaMesFechaInicioFechaActual = utilidades.calcularRestaMesFechaInicioMesFechaActual(fechaFin);
		String mesConteo = Integer.toString(RestaMesFechaInicioFechaActual);
		despegarPpalPage.seleccionarDiaFechaFin(mesConteo, utilidades.calcularDiaFecha(fechaFin));
		System.out.println("Usuario ingreso la fecha de fin "+fechaFin);
	}
	
	@And ("^cantidad de viajeros \"(.*)$")
	public void seleccionarCantidadViajeros (int cantidadViajeros) {
		despegarPpalPage.campoSeleccionarNumeroViajeros();
		for (int cont=1; cont < cantidadViajeros; cont++) {
			despegarPpalPage.botonAumentarCantViajeros();
		}
		despegarPpalPage.botonAplicarSelCantViajeros();
	}
	
	@And ("presiona el boton Buscar")
	public void presionarBotonBuscar() {
		despegarPpalPage.botonBuscar();
		System.out.println("El usuario presiona el boton buscar");
	}
	
	@And ("ordena de menor a mayor los registros arrojados por la busqueda")
	public void presionarOpcionTiquetesDiferentesCompanias() {
		resultadoBusquedaPage.ordenarPrecioMenorAMayor();
		resultadoBusquedaPage.opcionTiquetesDiferentesCompañias();
		System.out.println("Registros ya ordenados por precio de menor a mayor");
	}
	
	@Then ("almacena los 7 registros con precio mas bajo en un archivo de excel y se colorea de verde el precio mas bajo")
	public void almacenarRegistrosEnExcel() throws Exception {
		resultadoBusquedaPage.obtenerItinerarioVuelo(7,2);	
		System.out.println("El archivo con el resultado de las busquedas esta en la ruta D: y su nombre es tiquetesDespegar.xlsx");
	}
	
	@Then ("se visualiza mensaje indicando que el destino debe ser diferente al origen")
	public void mensajeDestinoDiferenteOrigen() {
		String mensajeError = despegarPpalPage.MensajeDeErrorDestino();
		assertEquals("El destino debe ser diferente del origen", mensajeError);
		System.out.println("El sistema muestra un mensaje de error indicando que la ciudad de destino debe ser diferente a la ciudad de origen");
	}
	
	@Then ("se visualiza mensaje indicando que se debe ingresar una fecha de regreso")
	public void mensajeFechaRegreso() {
		String mensajeError = despegarPpalPage.MensajeDeErrorFechaRegreso();
		assertEquals("Ingresa una fecha de regreso", mensajeError);
		System.out.println("El sistema muestra un mensaje de error indicando que se debe seleccionar una fecha de regreso");
	}

}
