package src;
import src.Lector;
import src.Vertice;
import src.Escritor;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class Grafica{
    private ArrayList<Vertice> vertices;
    private ArrayList<String[]> aristas;
    private ArrayList<String> conjunto;
    private String file;

    public Grafica(String file){
        this.file = file;
        Lector lec = new Lector(file);
        vertices = new ArrayList<>();
        aristas = lec.aristas;
        conjunto = new ArrayList<>();
        for(String i : lec.vertices){
            Vertice v = new Vertice(i);
            vertices.add(v);
        }

        for(Vertice v : vertices){
            for(String[] a : lec.aristas){
                if(a[0].contains(v.getNombre())){
                    for(Vertice u : vertices){
                        if(a[1].contains(u.getNombre())){
                            v.agregaVecino(u);
                        }
                    }
                }else if(a[1].contains(v.getNombre())){
                    for(Vertice u : vertices){
                        if(a[0].contains(u.getNombre())){
                            v.agregaVecino(u);
                        }
                    }
                }
            }
        }
    }

    public String getFile(){
        return this.file;
    }

    public ArrayList<String> conjuntoI(){
        ArrayList<Vertice> verticesH = new ArrayList<>();
        if(vertices.size() == 0){
            return conjunto;
        }else{
            Random r = new Random();
            int i = r.nextInt(vertices.size());
            Vertice selec = vertices.get(i);
            conjunto.add(selec.getNombre());
            vertices.remove(selec);
            for(Vertice v : vertices){
                if(!selec.getVecinos().contains(v)){
                    verticesH.add(v);
                }
            }
            vertices = verticesH;
            this.conjuntoI();
            return conjunto;
        }
    }

    public static void main(String[] args) throws IOException{
        Scanner scan = new Scanner(System.in); 
        System.out.println("Ingresa el nombre del archivo.");
        Grafica g = new Grafica(scan.nextLine());
        ArrayList<String> conjuntoI = g.conjuntoI();
        Escritor e = new Escritor();
        e.escribe(conjuntoI, g.getFile());
    }
}