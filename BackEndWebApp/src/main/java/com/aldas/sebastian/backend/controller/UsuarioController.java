package com.aldas.sebastian.backend.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.aldas.sebastian.backend.model.Usuario;

public class UsuarioController {
	
	
	public List<Usuario> getUsuarios(){
		Path file = Paths.get(".//src//main//resources//usuarios.txt");
        List<Usuario> lista_usuarios = new ArrayList<Usuario>();
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
                    String[] file_usuario = r.split("&&");
                    Usuario usuario = new Usuario();
                    usuario.setNombre(file_usuario[0]);
                    usuario.setNick(file_usuario[1]);
                    usuario.setClave(file_usuario[2]);
                    lista_usuarios.add(usuario);
                }
                contador++;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista_usuarios;
	}
}
