package com.lulobank.apirest.certificacion.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LeerArchivoProperties {
	private String resultado;
	private String url;
	private static final Logger LOGGER = Logger.getLogger(LeerArchivoProperties.class.getName());

	public LeerArchivoProperties(String url) {
		resultado = "";
		this.url = url;
	}
	
	
	public String conParametro(String propiedad) {
		
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(url));
			resultado=properties.getProperty(propiedad);
		} catch (FileNotFoundException e) {
			LOGGER.log(Level.WARNING, "El archivo no puede ser encontrado", e);
		} catch (IOException e) {
			LOGGER.log(Level.WARNING, "Problemas con el archivo", e);
		}
		return resultado;
	}
	
	public static LeerArchivoProperties leerarchivoproperties(String url) {
		return new LeerArchivoProperties(url);
	}

}
