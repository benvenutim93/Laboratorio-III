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
import Objetos.Pedido;

import java.io.*;


public class Archivador
{
    static final String ARCHIVO_COMIDAS = "comidas.dat";
    static final String ARCHIVO_COMBOS = "combos.dat";
    static final String ARCHIVO_CLIENTES = "clientes.dat";
    static final String ARCHIVO_MESAS = "mesas.dat";


    /**
     * Se encarga de actualizar los datos del archivo de Comidas
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
     * Se encarga de devolver lo que e archivo de Comidas contine
     * @return lista de comidas
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

    /**
     * Se encarga de actualizar los datos del archivo de Combos
     * @param setCombo
     * @throws IOException
     */
    public static void cargarArchivoCombos(SetCombo setCombo) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_COMBOS);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Combo aux: setCombo.getSetCombo())
            objectOutputStream.writeObject(aux);
        objectOutputStream.close();
    }

    /**
     * Se encarga de devolver lo que e archivo de Combos contine
     * @return set de combos
     */
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

    /**
     * Se encarga de actualizar los datos del archivo de clientes
     * @param listaClientes
     * @throws IOException
     */
    public static void agregarClientes (ListaClientes listaClientes) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_CLIENTES);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Cliente aux: listaClientes.getListaClientes()) {
            objectOutputStream.writeObject(aux);
        }

        objectOutputStream.close();
    }

    /**
     * Se encarga de devolver lo que e archivo de Clientes contine
     * @return lista de clientes
     */
    public static ListaClientes leerArchivoClientes () {
        ListaClientes listaClientes = new ListaClientes();

        try {
            FileInputStream fileInputStream = new FileInputStream(ARCHIVO_CLIENTES);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            boolean bandera = true;
            Cliente aux;
            while (bandera) {
                aux = (Cliente) objectInputStream.readObject();
                aux.setPedido(new Pedido());
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

    /**
     * Se encarga de actualizar los datos del archivo de Mesas
     * @param listaMesas
     * @throws IOException
     */
    public static void agregarMesas (ListaMesas listaMesas) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(ARCHIVO_MESAS);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Mesa aux: listaMesas.getListaMesa()) {
            objectOutputStream.writeObject(aux);
        }

        objectOutputStream.close();
    }

    /**
     * Se encarga de devolver lo que e archivo de Mesas contine
     * @return lista de mesas
     */
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
