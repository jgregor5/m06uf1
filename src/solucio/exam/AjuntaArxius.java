package solucio.exam;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author julian
 */
public class AjuntaArxius {
    
    public static void ajunta(String arxiu1, String arxiu2, String arxiuAjuntat) throws IOException {
        
        FileReader fr = new FileReader(arxiu1);
        FileWriter fw = new FileWriter(arxiuAjuntat);
        
        fw.write("\nPRIMERA PART\n");
        
        llegirIEscriure(fr, fw);
        
        fr.close();
        fr = new FileReader(arxiu2);
        
        fw.write("\nSEGONA PART\n");
        
        llegirIEscriure(fr, fw);
        
        fr.close();
        fw.close();
    }
    
    private static void llegirIEscriure(FileReader fr, FileWriter fw) throws IOException {
        
        boolean fi = false;
        while (!fi) {
            int caracter = fr.read();
            if (caracter == -1) {
                fi = true;
            }
            else {
                fw.write(caracter);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        ajunta("data/hansel.txt", "data/gretel.txt", "data/hansel_gretel.txt");
    }
}
