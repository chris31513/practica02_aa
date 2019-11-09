package src;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;

public class Escritor{
    public Escritor(){

    }

    public void escribe(ArrayList<String> list, String file) throws IOException{
        String s = "";
        int i = 0;
        for(String r : list){
            if(i == list.size() - 1){
                s += r + "\n"; 
            }else{
                s += r + ",";
            }
            i++;
        }

        BufferedWriter w = new BufferedWriter(new FileWriter("Salida" + file));
        w.write(s);
        w.close();
    }
}