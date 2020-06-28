package Archivos;

import Colecciones.ListaComidas;
import Colecciones.SetCombo;
import Comidas.Combo;
import Comidas.Comida;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

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

    public static void cargarArchivoCombos(String nombre,SetCombo setCombo) throws IOException {
        FileOutputStream archi = new FileOutputStream(nombre);
        ObjectOutputStream obj = new ObjectOutputStream(archi);
        HashSet<Combo> combos = setCombo.getCartaCombo();
        Iterator<Combo> it = combos.iterator();
        while (it.hasNext()) {
            Combo entrada = (Combo) it.next();
            obj.writeObject(entrada);
        }
    }/*
    public  static SetCombo leerArchivoCombos(String nombre) throws IOException, ClassNotFoundException {
        SetCombo rta = new SetCombo();
        FileInputStream archi =new FileInputStream(nombre);
        ObjectInputStream obj = new ObjectInputStream(archi);
        Combo aux;
        try {
            while ((aux = (Combo) obj.readObject()) != null) {
                System.out.println(aux.getClass().getSimpleName());
                rta.agregar(aux);
            }
        }catch (EOFException e){
            System.out.println("Fin archivo");
        }
        return rta;
    }
*/
    public static SetCombo leerArchivoCombos(String nombre) {
        SetCombo rta=new SetCombo();
        try {
            FileInputStream archi =new FileInputStream(nombre);
            ObjectInputStream ob = new ObjectInputStream(archi);
            boolean flag =true;
            Combo combo1;
            while (flag){
                combo1=(Combo)ob.readObject();
                rta.agregar(combo1);
            }
            ob.close();

        }catch (EOFException e){
            System.out.println("Fin ");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return rta;
    }

}
