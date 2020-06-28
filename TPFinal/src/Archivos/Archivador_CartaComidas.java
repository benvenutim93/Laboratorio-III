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
    static final String ARCHIVO_COMBOS = "combos.dat";
    static final String ARCHIVO_CLIENTES = "clientes.dat";

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

//---------------------------------------------------------------------------------------------------------------------

    public static void cargarArchivoCombos(SetCombo setCombo) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_COMBOS);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Combo aux: setCombo.getSetCombo())
            objectOutputStream.writeObject(aux);
        objectOutputStream.close();
    }

    public static SetCombo leerArchivoCombos() {
        SetCombo rta=new SetCombo();
        try {
            FileInputStream fileInputStream =new FileInputStream(ARCHIVO_COMBOS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean flag =true;
            Combo combo1;
            while (flag){
                combo1=(Combo)objectInputStream.readObject();
                rta.agregar(combo1);
            }
            objectInputStream.close();
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

//---------------------------------------------------------------------------------------------------------------------











}
