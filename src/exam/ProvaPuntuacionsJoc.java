package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author julian
 */
public class ProvaPuntuacionsJoc {

    public static void mostrarArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + ": " + array[i]);
        }
    }

    public static void main(String[] args) throws IOException {

        PuntuacionsJoc pj = new PuntuacionsJoc("data/punts.dat");

        pj.llegirPunts();
        mostrarArray(pj.obtenirPunts());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean end = false;

        System.out.println("afegeix puntuacions, retorn per finalitzar");
        while (!end) {

            System.out.print("> ");
            String line = br.readLine();
            if (line == null || line.length() == 0) {
                break;
            }

            int puntuacio;
            try {
                puntuacio = Integer.parseInt(line);
            } catch (NumberFormatException wz) {
                System.out.println("format incorrecte");
                continue;
            }

            boolean afegit = pj.afegirPuntuacio(puntuacio);
            System.out.println(afegit ? "afegit" : "NO afegit");

            mostrarArray(pj.obtenirPunts());
        }

        pj.escriurePunts();
    }
}
