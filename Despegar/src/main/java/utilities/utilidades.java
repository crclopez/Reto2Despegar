package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import pages.ResultadoBusquedaPage;

public class utilidades {
	
	static ResultadoBusquedaPage resultadoBusquedaPage;
	
	public static int calcularRestaMesFechaInicioMesFechaActual(String fecha) {
		String [] fechaSeparada = fecha.split("/");
		Integer mesFechaSeleccionada = Integer.parseInt(fechaSeparada[1]);
		
		Calendar fechaActual = new GregorianCalendar();
		Integer mesActual = fechaActual.get(Calendar.MONTH);
			
		Integer restaMesSelecMesActual = mesFechaSeleccionada - mesActual;
		
		return restaMesSelecMesActual;
	}
	
	public static int calcularDiaFecha(String fecha) {
		String [] fechaSep = fecha.split("/");
		Integer dia = Integer.parseInt(fechaSep[0]);
		
		return dia;
	}
	
	public static void Wait(WebDriver driver, int segundos){
	      synchronized(driver){
	         try {
	            driver.wait(segundos * 1000);
	         } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         }
	      }
	   } 
	
	public static class Excel {
			
			
			static String nombreArchivo="tiquetesDespegar.xlsx";
			static String rutaArchivo= "D:\\"+nombreArchivo;
			static String hoja="Hoja1";
			
			static XSSFWorkbook libro= new XSSFWorkbook();
			static XSSFSheet hoja1 = libro.createSheet(hoja);
			
			public static void escribirExcel(String[][] itinerarioVuelo){
			
			String [] encabezado= new String[]{"Hora","Precio"};
			     
			//generar los datos para el documento
			for (int i = 0; i <= itinerarioVuelo.length; i++) {
				XSSFRow row=hoja1.createRow(i);
				for (int j = 0; j <encabezado.length; j++) {
					if (i==0) {//para la cabecera
							XSSFCell cell= row.createCell(j);//se crea las celdas para la cabecera, junto con la posición
							cell.setCellValue(encabezado[j]);//se añade el contenido					
					}else{//para el contenido
						XSSFCell cell= row.createCell(j);//se crea las celdas para la contenido, junto con la posición
						cell.setCellValue(itinerarioVuelo[i-1][j]); //se añade el contenido
					}				
				}
			}
			
			File file;
			file = new File(rutaArchivo);
			
			 // Poner color verde al precio mas bajo
		    CellStyle colorCelda = libro.createCellStyle();
		    colorCelda.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		    colorCelda.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		    Row filaMP = hoja1.getRow(1);
		    filaMP.getCell(1).setCellStyle(colorCelda);
		    
			try (FileOutputStream fileOuS = new FileOutputStream(file)){						
				if (file.exists()) {// si el archivo existe se elimina
					file.delete();
					System.out.println("Archivo eliminado");
				}
				libro.write(fileOuS);
				fileOuS.flush();
				fileOuS.close();
				System.out.println("Archivo Creado");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
