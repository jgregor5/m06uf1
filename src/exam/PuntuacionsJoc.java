package exam;

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
        
        // implementa-ho!
    }
    
    /**
     * escriure l'array 'puntuacions' amb les 10 puntuacions maximes a un 
     * arxiu binari
     */
    public void escriurePunts() throws IOException {
        
        // implementa-ho!
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

        // implementa-ho!
        
        return false;
    }
}
