/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package months;

import java.io.IOException;

/**
 *
 * @author julian
 */
public class TestWriteMonths {
    
    public static void main(String[] args) throws IOException {
        
        WriteMonths wm = new WriteMonths("data/months.dat");
        wm.write();
        String[] months = wm.read();
        
        for (int i=0; i<months.length; i++) {                
            System.out.println(i + ": " + months[i]);                
        }
    }
}
