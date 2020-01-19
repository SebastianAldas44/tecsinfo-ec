package com.aldas.sebastian.backend.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.aldas.sebastian.backend.model.Producto;

public class ProductoController {
	public List<Producto> getProductos(){
		Path file = Paths.get(".//src//main//resources//productos.txt");
        List<Producto> lista_productos = new ArrayList<Producto>();
        try
        {
            FileReader fileReader = new FileReader(file.toString());
            BufferedReader br = new BufferedReader(fileReader);
            int contador = 1;
            String r;
            while((r = br.readLine()) != null)
            {
                if(contador != 1)
                {
                    String[] file_producto = r.split("&&");
                    Producto producto = new Producto();
                    producto.setCodigo(Integer.parseInt(file_producto[0]));
                    producto.setDescripcion(file_producto[1]);
                    producto.setPrecio(Double.parseDouble(file_producto[2]));
                    producto.setCantidad(Integer.parseInt(file_producto[3]));
                    producto.setTotal(Double.parseDouble(file_producto[4]));
                    lista_productos.add(producto);
                }
                contador++;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista_productos;
	}
}
