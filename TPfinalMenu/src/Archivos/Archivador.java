package Archivos;

import Colecciones.ListaClientes;
import Colecciones.ListaComidas;
import Colecciones.ListaMesas;
import Colecciones.SetCombo;
import Comidas.Combo;
import Comidas.Comida;
import Humanos.Cliente;
import Humanos.Presencial;
import Humanos.Virtual;
import Objetos.Mesa;

import java.io.*;


public class Archivador
{
    static final String ARCHIVO_COMIDAS = "comidas.dat";
    static final String ARCHIVO_COMBOS = "combos.dat";
    static final String ARCHIVO_CLIENTES = "clientes.dat";
    static final String ARCHIVO_MESAS = "mesas.dat";
    //static final String ARCHIVO_PRESENCIAL="presencial.dat";
    //static final String ARCHIVO_VIRTUAL="virtual.dat";

    /**
     * Carga en un Archivo la lista de Comidas del restaurant
     * @param listaComidas
     * @throws IOException
     */
    public static void agregarComidas (ListaComidas listaComidas) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_COMIDAS);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Comida aux: listaComidas.getListaComidas())
            objectOutputStream.writeObject(aux);

        objectOutputStream.close();
    }

    /**
     * Retorna una lista de comidas cargada en el Archivo
     * @return ListaComidas
     */
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
            System.out.println("Fin archivo Comidas");}
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
            System.out.println("Fin archivo Combos");
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

   /* public static void cargarArchivoClienteVirtual(ListaClientes listaClientes) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_VIRTUAL);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Cliente aux: listaClientes.getListaClientes()) {
            if(aux instanceof Virtual)
                objectOutputStream.writeObject(aux);
        }
        objectOutputStream.close();
    }
    public static ListaClientes leerArchivoClientesVirtual () {
        ListaClientes listaClientes = new ListaClientes();

        try {
            FileInputStream fileInputStream = new FileInputStream(ARCHIVO_VIRTUAL);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean bandera = true;
            Virtual aux;
            while (bandera) {
                aux = (Virtual) objectInputStream.readObject();
                listaClientes.agregar(aux);
            }
            objectInputStream.close();
        }
        catch (EOFException l) {

            System.out.println("Fin archivo Clientes");
        }
        catch (FileNotFoundException e) {

            e.printStackTrace(); }
        catch (IOException e) {

            e.printStackTrace(); }
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return listaClientes;
    }

    public static void cargarArchivoClientePresencial(ListaClientes listaClientes) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_PRESENCIAL);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Cliente aux: listaClientes.getListaClientes()) {
            if(aux instanceof Presencial)
            objectOutputStream.writeObject(aux);
        }

        objectOutputStream.close();
    }
    public static ListaClientes leerArchivoClientesPresenciales () {
        ListaClientes listaClientes = new ListaClientes();

        try {
            FileInputStream fileInputStream = new FileInputStream(ARCHIVO_PRESENCIAL);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean bandera = true;
            Presencial aux;
            while (bandera) {
                aux = (Presencial) objectInputStream.readObject();
                listaClientes.agregar(aux);
            }
            objectInputStream.close();
        }
        catch (EOFException l) {

            System.out.println("Fin archivo Clientes");
        }
        catch (FileNotFoundException e) {

            e.printStackTrace(); }
        catch (IOException e) {

            e.printStackTrace(); }
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return listaClientes;
    }
*/

    public static void agregarClientes (ListaClientes listaClientes) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_CLIENTES);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Cliente aux: listaClientes.getListaClientes()) {
            objectOutputStream.writeObject(aux);
        }

        objectOutputStream.close();
    }

    public static ListaClientes leerArchivoClientes () {
        ListaClientes listaClientes = new ListaClientes();

        try {
            FileInputStream fileInputStream = new FileInputStream(ARCHIVO_CLIENTES);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean bandera = true;
            Cliente aux;
            while (bandera) {
                aux = (Cliente) objectInputStream.readObject();
                listaClientes.agregar(aux);
            }
            objectInputStream.close();
        }
        catch (EOFException l) {

            System.out.println("Fin archivo Clientes");
        }
        catch (FileNotFoundException e) {

            e.printStackTrace(); }
        catch (IOException e) {

            e.printStackTrace(); }
        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        return listaClientes;
    }

//---------------------------------------------------------------------------------------------------------------------

    public static void agregarMesas (ListaMesas listaMesas) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_MESAS);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Mesa aux: listaMesas.getListaMesa()) {
            objectOutputStream.writeObject(aux);
        }

        objectOutputStream.close();
    }

    public static ListaMesas leerArchivoMesas () {
        ListaMesas listaMesas = new ListaMesas();

        try {
            FileInputStream fileInputStream = new FileInputStream(ARCHIVO_MESAS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean bandera = true;
            Mesa aux;
            while (bandera) {
                aux = (Mesa) objectInputStream.readObject();
                listaMesas.agregar(aux);
            }
            objectInputStream.close();
        }
        catch (EOFException l) {
            System.out.println("Fin archivo Mesas");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace(); }
        catch (IOException e) {
            e.printStackTrace(); }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaMesas;
    }

}
