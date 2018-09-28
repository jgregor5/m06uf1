/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author julian
 */
public class FilePathTest {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        String nombre = "C:\\data\\arxiu.txt";
        
        File f = new File(nombre);
        boolean existe = f.exists();
        
        System.out.println(existe? "SI" : "NO");
        
        System.out.println("name " + f.getName());
        System.out.println("parent " + f.getParent());
        
        String newName = f.getParent() + File.separator + "toupper_" + f.getName(); 
        System.out.println("new name " + newName);
    }
}
