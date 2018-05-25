package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import cucumber.api.java.en.When;
import pages.DespegarPpalPage;
import pages.ResultadoBusquedaPage;

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
		Integer i = calcularMesFecha(fechaInicio);
		
		for (Integer cont = 0; cont<i; cont++) {
			despegarPpalPage.flechaCambioMesFuturo();
		}
		
		despegarPpalPage.seleccionarDiaFechaInicio(calcularDiaFecha(fechaInicio));
		System.out.println("Usuario ingreso la fecha de inicio "+fechaInicio);
	}
	
	@And ("^de fin \"(.*)$")
	public void seleccionarFechaFin (String fechaFin) {
		despegarPpalPage.campoFechaFin();
		despegarPpalPage.campoFechaFin();		
		despegarPpalPage.seleccionarDiaFechaFin(calcularDiaFecha(fechaFin));
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
	public void almacenarRegistrosEnExcel() {
		String precio = resultadoBusquedaPage.obtenerPrecioRegistro();
		String horaVuelo = resultadoBusquedaPage.obtenerHoraVuelo();
		escribirExcel(horaVuelo, precio);
		System.out.println("El archivo con el resultado de las busquedas esta en la ruta D: y su nombre es tiquetesDespegar.xlsx"+precio+" "+horaVuelo);
	}
	
	public int calcularMesFecha(String fecha) {
		String [] fechaSep = fecha.split("/");
		Integer mes = Integer.parseInt(fechaSep[1]);
		
		Calendar fechaAct = new GregorianCalendar();
		Integer mesAct = fechaAct.get(Calendar.MONTH);
			
		Integer mesRest = mes - mesAct;
		
		return mesRest;
	}
	
	public int calcularDiaFecha(String fecha) {
		String [] fechaSep = fecha.split("/");
		Integer dia = Integer.parseInt(fechaSep[0]);
		
		return dia;
	}
	
	public void escribirExcel (String horaVuelo, String precio){
		File file = new File("D:\\tiquetesDespegar.xlsx");
		
		try {
			FileInputStream xFileI = new FileInputStream(file);
			Workbook libroExcel = WorkbookFactory.create(xFileI);
			Sheet hoja = libroExcel.getSheetAt(0);
			Cell celda = hoja.getRow(0).getCell(0);
			System.out.println("por aqui paso");
			celda.setCellValue(horaVuelo);
			xFileI.close();
			
			
//			XSSFWorkbook libroExcel = new XSSFWorkbook(xFileI);
//			XSSFSheet hoja = libroExcel.getSheetAt(0);

			FileOutputStream xFileO = new FileOutputStream(file);
			libroExcel.write(xFileO);
			libroExcel.close();
			xFileO.close();
			
		} catch (FileNotFoundException e) {
	        e.printStackTrace();
		} catch (Exception e) {
			System.out.println("ERROR FILE HANDLING " + e.toString());
			e.printStackTrace();
		}
	}
}
