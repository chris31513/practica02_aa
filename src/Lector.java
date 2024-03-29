package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * Lector de graficas desde archivos de texto
 */
public class Lector{
  
  // Atributos de Lector
  String[] vertices;
  ArrayList<String[]> aristas;
  
  /**
   * Constructor del lector
   * Recibe el nombre de un archivo de texto y almacena el arreglo de vertices y aristas en el objeto.
   * @param filename Nombre del archivo de texto a procesar
   */
  public Lector(String filename){
    aristas = new ArrayList<>();
    leerArchivo(filename);
  }
  /**
   * Metodo que dado un nombre de archivo almacena en el objeto los vertices y las aristas del archivo de texto
   * @param filename Nombre del archivo de texto a procesar
   */
  public void leerArchivo(String filename){
    try(BufferedReader br = new BufferedReader(new FileReader(filename))){
      String line;
      for(int i = -1; (line = br.readLine()) != null; i++){
        if(i == -1){
          vertices = line.trim().split("\\s*,\\s*");
        }else{
          String[] lineaAristas = line.trim().split("\\s*,\\s*");
          aristas.add(lineaAristas);
        }
      }
    }catch(Exception e){
      System.err.println(e);
    }
  } 
}




