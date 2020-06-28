package Archivos;

import Colecciones.ListaComidas;
import Comidas.Comida;

import java.io.*;

public class Archivador_CartaComidas
{
    static final String ARCHIVO_COMIDAS = "comidas.dat";


    public static void agregarComidas (ListaComidas listaComidas) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_COMIDAS);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Comida aux: listaComidas.getListaComidas())
            objectOutputStream.writeObject(aux);

        objectOutputStream.close();
    }

    public static ListaComidas leerArchivoComidas (){
        ListaComidas listaComidas = new ListaComidas();
        try{
            FileInputStream fileInputStream = new FileInputStream(ARCHIVO_COMIDAS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean bandera = true;
            Comida aux;
            while(bandera){
                aux = (Comida)objectInputStream.readObject();
                listaComidas.agregar(aux);
            }
            objectInputStream.close();
        }
        catch (EOFException e){
            System.out.println("FIN DEL ARCHIVO");}
        catch (FileNotFoundException e) {
            System.out.println(e.getMessage());}
        catch (IOException e) {
            System.out.println(e.getMessage());}
        catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());}
        return listaComidas;
    }

}
