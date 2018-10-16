/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solucio.act1;

/**
 *
 * @author julian
 */
public class TestTextToUpper {
    
    public static void main(String[] args) {
        
        TextToUpper tam = new TextToUpper("data/gnu-unicode.txt");
        boolean ok = tam.toUpper();        
        System.out.println("conversion: " + (ok? "done" : "failure"));
    }

}
