import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class lectorcsv {
        private BufferedReader lector;
        private String linea;
        private String partes[] = null;

        public void Leercsv(String nombredelarchivo){
            try {
                lector = new BufferedReader(new FileReader(nombredelarchivo));
                while ((linea = lector.readLine())!=null ){
                    partes = linea.split(",");
                    mostrarlineas();
                    System.out.println();

                }
                lector.close();
                linea=null;
                partes=null;

            }catch (Exception e){
                JOptionPane.showMessageDialog(null ,e);
            }
        }
        public void mostrarlineas(){
            for (int i = 0; i <partes.length ; i++) {
                System.out.println(partes[i]+"  /  ");

            }
        }
    }



