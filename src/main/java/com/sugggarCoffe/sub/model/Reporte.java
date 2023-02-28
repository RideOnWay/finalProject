package com.sugggarCoffe.sub.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.sugggarCoffe.sub.model.Venta;
import com.sugggarCoffe.sub.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.lang.reflect.Field;


public class Reporte {



  //  public  void escribir(VentaService ventaService) {
//        Workbook libro = new XSSFWorkbook();
//        final String nombreArchivo = "Reporte.xlsx";
//        Sheet hoja = libro.createSheet("Hoja 1");    
//        
//        List<Venta> listVenta = ventaService.listarVenta();
//        String valores[]=new String[4] ;
//        
//        for(int i=0;i <listVenta.size() ;i++){
//        		Row Fila ;
//        		Fila = hoja.createRow(i);
//        		Venta venta =listVenta.get(i);
//        		valores[0]=venta.getIdUsuario().getNombreUsuario();
//            	valores[1]=venta.getIdCliente().getNombreCliente();
//            	valores[2]=Integer.toString(venta.getPrecioTotal());
//            	valores[3]=venta.getProducto().toString();
//        	for(int j=0;j < 4.;j++){
//        		Cell Celda = Fila.createCell(j);
//        		Celda.setCellValue(valores[j]);
//        	}
//        }
//
//       
//        
//        File ubicacion = new File("/home/alejo/Desktop/");
//        // String ubicacion = directorioActual.getAbsolutePath();
//        // String ubicacionArchivoSalida = ubicacion.substring(0, ubicacion.length() - 1) + nombreArchivo;
//        FileOutputStream outputStream;
//        try {
//            outputStream = new FileOutputStream(ubicacion+nombreArchivo);
//            libro.write(outputStream);
//            libro.close();
//            System.out.println("Libro guardado correctamente");
//        } catch (FileNotFoundException ex) {
//            System.out.println("Error de filenotfound");
//        } catch (IOException ex) {
//            System.out.println("Error de IOException");
//        }
//    }
}
