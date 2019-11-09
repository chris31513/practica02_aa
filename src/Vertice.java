package src;
import java.util.ArrayList;

public class Vertice{
    private String nombre;
    private ArrayList<Vertice> vecinos;

    public Vertice(String nombre){
        this.nombre = nombre;
        vecinos = new ArrayList<>();
    }

    public void agregaVecino(Vertice vecino){
        vecinos.add(vecino);
    }

    public ArrayList<Vertice> getVecinos(){
        return vecinos;
    }

    public String getNombre(){
        return nombre;
    }
}