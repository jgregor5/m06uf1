package solucio.exam;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Classe per mantenir emmagatzemada el top 10 de puntuacions d'un joc.
 * @author julian
 */
public class PuntuacionsJoc {
    
    private static final int NOMBRE_PUNTUACIONS = 10;
    
    private String arxiu;
    private int[] puntuacions;
    
    public PuntuacionsJoc(String arxiu) {
        this.arxiu = arxiu;
        this.puntuacions = new int[NOMBRE_PUNTUACIONS];
    }
    
    /**
     * llegeix les 10 puntuacions maximes des d'un arxiu binari a l'array 
     * 'puntuacions'. Si no existeix l'arxiu, ha de inicialitzar l'array amb 
     * deu zeros.
     */
    public void llegirPunts() throws IOException {
        
        File f = new File(this.arxiu);
        if (!f.exists()) {
            return;
        }
        else {
            DataInputStream dis = new DataInputStream(new FileInputStream(f)); 
            for (int i = 0; i < NOMBRE_PUNTUACIONS; i++) {
                this.puntuacions[i] = dis.readInt();
            }
            dis.close();    
        }
    }
    
    /**
     * escriure l'array 'puntuacions' amb les 10 puntuacions maximes a un 
     * arxiu binari
     */
    public void escriurePunts() throws IOException {
        
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(this.arxiu));
        
        for (int i = 0; i < NOMBRE_PUNTUACIONS; i++) {
            dos.writeInt(this.puntuacions[i]);
        }
        
        dos.close();
    }
    
    /**
     * 
     * @return l'array 'puntuacions'
     */
    public int[] obtenirPunts() {
        return this.puntuacions;
    }
    
    /**
     * Afegir la puntuacio, si esta al top 10. 
     * @param puntuacio si s'ha afegit la puntuacio (estava al top 10).
     * @return 
     */
    public boolean afegirPuntuacio(int puntuacio) {

        int posicio = -1;
        for (int i = 0; i < NOMBRE_PUNTUACIONS; i++) {
            if (this.puntuacions[i] < puntuacio) {
                posicio = i;
                break;
            }
        }
        
        if (posicio == -1) {
            return false;
        }
        
        for (int i = NOMBRE_PUNTUACIONS - 1; i > posicio; i--) {
            this.puntuacions[i] = this.puntuacions[i - 1];
        }
        
        this.puntuacions[posicio] = puntuacio;
        
        return true;
    }
}
