package solucio.act1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author julian
 */
public class TextToUpper {
    
    private String filename;
    
    public TextToUpper(String filename) {
        this.filename = filename;
    }
    
    public boolean toUpper() {
        
        File f = new File(this.filename);
        if (!f.exists()) {
            return false;
        }
        
        try {
            FileReader fr = new FileReader(this.filename);
            String outFilename = f.getParent() + File.separator + "toupper_" + f.getName();
            FileWriter fw = new FileWriter(outFilename);
            
            boolean end = false;
            while (!end) {
                int character = fr.read();
                if (character == -1) {
                    end = true;
                }
                else {
                    fw.write(Character.toUpperCase(character));
                }
            }
            
            fw.close();
            fr.close();
            
            return true;
            
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;            
        }
    }    
}
