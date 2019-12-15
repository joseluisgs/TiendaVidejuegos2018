/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author link
 */
public class Utilidad {
    private static Utilidad util = null;
    
    public static Utilidad nuevaInstancia() {
        if(util ==null){
            util= new Utilidad();
        }
        return util;
    }
    
    private Utilidad() {
        
    }
    
    public String getPathBaseDatos() {
        // Path Actual, directorio de la BD
        String path = System.getProperty("user.dir");
        String pathBD = path+File.separator+"BD"+File.separator;
        return pathBD;   
    }
    
    public String getPatImagenes() {
        // Path Actual, directorio de la imagenes de la app
        String path = System.getProperty("user.dir");
        String pathImg = path+File.separator+"iconos"+File.separator;
        return pathImg;   
    }
    
    public String getPathFotosSocios() {
        String path = System.getProperty("user.dir");
        String pathImg = path+File.separator+"fotosSocios"+File.separator;
        return pathImg;   
    }
    
    public String getPathFotosJuegos() {
        String path = System.getProperty("user.dir");
        String pathImg = path+File.separator+"fotosJuegos"+File.separator;
        //System.out.println(pathImg);
        return pathImg;   
    }
    
    public void copiarFotoSocio(File fotoSocio) {
        try {
            String fichero = fotoSocio.getName();
            fichero=getPathFotosSocios()+fichero;
            File destino = new File(fichero);
            Files.copy(fotoSocio.toPath(), destino.toPath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se puede copiar el fichero de imagen seleccionado","error al copiar imagen",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void copiarFotoJuego(File fotoJuego) {
        try {
            String fichero = fotoJuego.getName();
            fichero=getPathFotosJuegos()+fichero;
            File destino = new File(fichero);
            Files.copy(fotoJuego.toPath(), destino.toPath());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"No se puede copiar el fichero de imagen seleccionado","error al copiar imagen",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    // Patrones de texto
    
    public boolean emailValido(String email) {
        String regExpn =
             "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                 +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                   +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                   +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                   +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

    return matcher.matches();
    }
    
    public boolean telefonoValido(String telefono) {
        String regExpn = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{3})$";

        CharSequence inputStr = telefono;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

    return matcher.matches();
    }
    
    public boolean precioValido(String precio) {
        String regExpn = "\\d*\\.?\\d*";

        CharSequence inputStr = precio;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

    return matcher.matches();
    }
    
    public String convertirSHA256(String password) {
	MessageDigest md = null;
	try {
            md = MessageDigest.getInstance("SHA-256");
	} 
	catch (NoSuchAlgorithmException e) {		
            e.printStackTrace();
            return null;
	}
	    
	byte[] hash = md.digest(password.getBytes());
	StringBuffer sb = new StringBuffer();
	    
	for(byte b : hash) {        
		sb.append(String.format("%02x", b));
	}
	    
	return sb.toString();
    }


    
}
