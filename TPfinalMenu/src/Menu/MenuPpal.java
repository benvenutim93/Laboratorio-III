package Menu;

import java.util.Scanner;

import Colecciones.ListaMesas;
import Colecciones.Restaurant;
import Excepciones.*;
import Humanos.*;
import Comidas.*;
import Objetos.*;


public class MenuPpal {
    public static void MenuPrincipal (Scanner scan, Restaurant restaurant)
    {
        int op, var;
        imprimirMenuPrincipal();
        op = elegirOpcion(scan);

        switch (op)
        {
            case 1:
            {
                imprimirOpionesClientePresencial();
                var = elegirOpcion(scan);
                MenuClientePresencial(var,scan, restaurant);
                break;
            }
            case 2:
                imprimirOpcionesDelivery();
                var = elegirOpcion(scan);
                MenuDelivery(var,scan,restaurant);
                break;
            case 3:
                imprimirOpcionesMesas();
                var = elegirOpcion(scan);

                break;
            case 4:
                imprimirOpcionesGestionCombosComidas();
                var = elegirOpcion(scan);
                break;
            case 0:
                System.out.println("Gracias, vuelva pronto! =) ");
                System.exit(0);
                break;
        }
    }

    public static int elegirOpcion (Scanner scan)
    {
        int op;
        System.out.println("Ingrese una opcion:");
        op = scan.nextInt();
        return op;
    }

    public static void imprimirMenuPrincipal ()
    {
        System.out.println("\n");
        System.out.println(" ---- BIENVENIDO !! ---- ");
        System.out.println(" -- MENU PRINCIPAL --");
        System.out.println("1- Cliente presencial");
        System.out.println("2- Delivery");
        System.out.println("3- Mesas");
        System.out.println("4- Gestion de combos y comidas");
        System.out.println("0- Salir");
    }

    public static void imprimirOpionesClientePresencial ()
    {
        System.out.println("\n\n");
        System.out.println("1- Nuevo Cliente");
        System.out.println("2- Cliente existente");
        System.out.println("3- Tomar pedido");
        System.out.println("4- Mostrar datos Cliente");
        System.out.println("0- Regresar");
    }

    public static void imprimirOpcionesDelivery ()
    {
        System.out.println("\n\n");
        System.out.println("1- Tomar datos del cliente");
        System.out.println("2- Tomar pedido");
        System.out.println("3- Mostrar datos cliente");
        System.out.println("0- Regresar");
    }
    public static void imprimirOpcionesMesas()
    {
        System.out.println("\n\n");
        System.out.println("1- Mesas disponibles");
        System.out.println("2- Liberar mesa");
        System.out.println("3- Agregar mesa");
        System.out.println("4- Eliminar mesa");
        System.out.println("0- Regresar");
    }
    public static void imprimirOpcionesGestionCombosComidas ()
    {
        System.out.println("\n\n");
        System.out.println("1- Agregar combos");
        System.out.println("2- Eliminar combos");
        System.out.println("3- Agregar comidas");
        System.out.println("4- Eliminar comidas");
        System.out.println("5- Modificar precio");
        System.out.println("6- Listado de comidas");
    }
    public static  void imprimirOpcionesTomarPedido(){
        System.out.println("1-Combos\n"+"2-Comidas");
    }
    public static void imprimirOpcionesTomarPedidoComidas(){
        System.out.println("1-Bebida\n"+ "2-PlatoPrinciapl\n"+"3-Postre\n"+"4-Guarnicion");
    }

    public static void MenuClientePresencial (int op, Scanner scan, Restaurant restaurant)
    {

        Presencial presencial = null;
        Cliente cliente = null;

        String dni ;
        switch (op)
        {
            case 1:
                presencial = crearClientePresencial(scan);
                try {
                    if (!restaurant.agregarCliente(presencial)) {
                        throw new DniExistenteException();

                    }else {
                        System.out.println(presencial.toString());
                    }
                }catch(DniExistenteException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println(" Ingrese Dni del  Cliente: ");
                dni=scan.next();
                try {

                    presencial = (Presencial) restaurant.buscarPorDni(dni);
                    if (presencial != null) {
                        System.out.println("Cliente existe!");
                        System.out.println(presencial.toString());
                    } else
                    {
                        throw new ClienteInexistenteException(dni);

                    }
                }catch (ClienteInexistenteException e){
                    String opc;
                    System.out.println(e.getMessage()); //muestra mensajito
                    System.out.println("Desea crear el cliente? (si /no)");
                    opc= scan.next();
                    if(opc.equalsIgnoreCase("si")){
                        String nombre;
                        String apellido;
                        String documento = e.getDni();
                        int cantPersonas;
                        System.out.println("Ingrese nombre -> ");
                        nombre=scan.next();
                        System.out.println("Ingrese apellido -> ");
                        apellido=scan.next();
                        System.out.println("Ingrese cantidad de personas -> ");
                        cantPersonas = scan.nextInt();
                        Presencial nuevoPresencial = new Presencial(nombre,apellido,documento,cantPersonas);
                        restaurant.agregarCliente(nuevoPresencial);

                    }

                }
                break;
            case 3:
                System.out.println(" Ingrese Dni del  Cliente: ");
                dni=scan.next();
                presencial = (Presencial) restaurant.buscarPorDni(dni);
                if (presencial.getEspera()==false) {
                    try {
                        if (presencial == null) {
                            throw new DniNOexistenteExecption();
                        } else {
                            int opc;
                            Presencial aux = presencial;
                            imprimirOpcionesTomarPedido();
                            opc = elegirOpcion(scan);
                            switch (opc) {
                                case 1:
                                    System.out.println(restaurant.listarCombos());
                                    opc = elegirOpcion(scan);
                                    aux.pedirCombo(restaurant.getCartaComidas(), opc);
                                    break;
                                case 2:
                                    imprimirOpcionesTomarPedidoComidas();
                                    opc = elegirOpcion(scan);
                                    aux.crearPedido(opc, restaurant.getCartaComidas());
                                    break;
                            }
                        }
                    } catch (DniNOexistenteExecption | ComidaInexistenteException | ComboNoExistenteException e) {
                        System.out.println(e.getMessage());
                    }
                }
                else {
                    try {
                        throw new SentarPersonaException();
                    }
                    catch (SentarPersonaException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Desea ubicarlo ahora? SI/NO");
                        String rta = scan.next();

                        if (rta.equalsIgnoreCase("si")) {
                            try {
                                presencial.setEspera(restaurant.ocuparMesa(presencial));

                            }  catch (SinMesasException sinMesasException) {
                                System.out.println(sinMesasException.getMessage());
                            } catch (CapacidadMaximaException capacidadMaximaException) {
                                System.out.println(capacidadMaximaException.getMessage());
                            } catch (IdInexistenteMesaException idInexistenteMesaException) {
                                idInexistenteMesaException.printStackTrace();
                            }
                        }
                    }
                }
                break;
            case 4:
                System.out.println(" Ingrese Dni del  Cliente: ");
                dni=scan.next();
                Cliente aux= restaurant.buscarPorDni(dni);
                try{
                    if (aux == null) {
                        throw new DniNOexistenteExecption();
                    }
                    else
                        System.out.println(aux.toString());
                }
                catch (DniNOexistenteExecption e){
                    System.out.println(e.getMessage());
                }
                break;
            case 0: //salir
                break;
            default:
                System.out.println("Opción invalida");
                op = elegirOpcion(scan);
                break;
        }
        MenuPrincipal(scan,restaurant);
    }

    public static Presencial crearClientePresencial(Scanner scan)
    {
        Presencial a = new Presencial ();
        System.out.println("Nombre: ");
        scan.nextLine();
        a.setNombre(scan.nextLine());
        System.out.println("Apellido: ");
        a.setApellido(scan.nextLine());
        System.out.println("DNI: ");
        a.setDNI(scan.nextLine());
        System.out.println("Cantidad de personas: ");
        a.setCantPer(scan.nextInt());
        return a;
    }
    public static Virtual crearClienteVirtual (Scanner scan)
    {
        Virtual a = new Virtual ();
        System.out.println("Nombre: ");
        scan.nextLine();
        a.setNombre(scan.nextLine());
        System.out.println("Apellido: ");
        a.setApellido(scan.nextLine());
        System.out.println("DNI: ");
        a.setDNI(scan.nextLine());
        System.out.println("Telefono: ");
        a.setTelefono(scan.nextLine());
        System.out.println("Direccion: ");
        a.setDireccion(scan.nextLine());
        return a;
    }
    public static void MenuDelivery (int op, Scanner scan,Restaurant restaurant)
    {
        Virtual virtual;
        String dni;
        switch (op)
        {
            case 1:
                virtual = crearClienteVirtual(scan);

                try {
                    if (!restaurant.agregarCliente(virtual)) {
                        throw new DniExistenteException();

                    }else {
                        System.out.println(virtual.toString());
                    }
                }catch(DniExistenteException e){
                    System.out.println(e.getMessage());
                }
                break;
            case 2:
                System.out.println(" Ingrese Dni del  Cliente: ");
                dni=scan.next();
                virtual = (Virtual) restaurant.buscarPorDni(dni);
                try {
                    if (virtual == null) {
                        throw new DniNOexistenteExecption();
                    }
                    else {
                        int opc;
                        Virtual aux = virtual;
                        imprimirOpcionesTomarPedido();
                        opc = elegirOpcion(scan);
                        switch (opc) {
                            case 1:
                                System.out.println(restaurant.listarCombos());
                                opc = elegirOpcion(scan);
                                aux.pedirCombo(restaurant.getCartaComidas(), opc);
                                break;
                            case 2:
                                imprimirOpcionesTomarPedidoComidas();
                                opc = elegirOpcion(scan);
                                aux.crearPedido(opc, restaurant.getCartaComidas());
                                break;
                        }
                    }
                }
         catch (DniNOexistenteExecption | ComidaInexistenteException | ComboNoExistenteException e) {
        System.out.println(e.getMessage());
                }
                break;
            case 3:
                System.out.println(" Ingrese Dni del  Cliente: ");
                dni=scan.next();
                Cliente aux= restaurant.buscarPorDni(dni);
                try{
                    if (aux == null) {
                        throw new DniNOexistenteExecption();
                    }
                    else
                        System.out.println(aux.toString());
                }
                catch (DniNOexistenteExecption e){
                    System.out.println(e.getMessage());
                }
                break;
            case 0:
                //salir
                break;
            default:
                System.out.println("Opción invalida");
                op = elegirOpcion(scan);
                break;
        }
        MenuPrincipal(scan,restaurant);

    }

    public static Mesa crearMesa (Scanner scan)
    {
        Mesa a = new Mesa ();
        System.out.println("Capacidad: ");
        a.setCapacidad(scan.nextInt());
        return a;
    }

    public static void MenuMesas (int op, Scanner scan, ListaMesas lista)
    {
        Mesa mesa;
        switch (op)
        {
            case 1:
                lista.imprimirMesasLibres();
                break;
            case 2:
                //TODO ver como agregar mesa, si se crea o como.
                lista.agregar(crearMesa(scan));
                break;
            case 3:
                //TODO funcion de eliminar mesa
                break;
            case 4:
                ///TODO la mesa tenga asignado el DNI del cliente que la ocupa.
                break;
            default:
                System.out.println("Opción invalida");
                op = elegirOpcion(scan);
                break;
        }
    }



    public static void MenuCombos (int op, Scanner scan)
    {
        Combo combo;
        Comida comida;
        switch (op)
        {
            case 1:


        }
    }




}
