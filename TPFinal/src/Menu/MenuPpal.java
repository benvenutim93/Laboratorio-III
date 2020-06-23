package Menu;

import java.util.Scanner;

import Colecciones.ListaMesas;
import Colecciones.Restaurant;
import Excepciones.ClienteInexistenteException;
import Excepciones.ComidaInexistenteException;
import Excepciones.DniExistenteException;
import Excepciones.DniNOexistenteExecption;
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
                MenuClientePresencial(var,scan, restaurant); //submenu
                break;
            }
            case 2:
                imprimirOpcionesDelivery();
                var = elegirOpcion(scan);
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
        System.out.println("0- Regresar");
    }

    public static void imprimirOpcionesDelivery ()
    {
        System.out.println("\n\n");
        System.out.println("1- Tomar datos del cliente");
        System.out.println("2- Tomar pedido");
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
    public static void imprimirSubMenuClientePresencial ()
    {
        System.out.println("\n\n");
        System.out.println("1- Asignar mesa");
        System.out.println("2- Tomar pedido");
        System.out.println("3- Lista de espera");
        System.out.println("0- Regresar");
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
        System.out.println(" Ingrese Dni del  Cliente: ");
        String dni = scan.next();
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
                try {

                    cliente = restaurant.buscarPorDni(dni);
                    if (cliente != null) {
                        System.out.println("Cliente existe!");
                        System.out.println(cliente.toString());
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
                cliente = restaurant.buscarPorDni(dni);
                try {
                    if (cliente == null) {
                        throw new DniNOexistenteExecption();
                    }else {
                        int opc;
                        Presencial aux =(Presencial)cliente;
                        imprimirOpcionesTomarPedido();
                        opc =elegirOpcion(scan);
                        switch (opc){
                            case 1:

                            case 2:
                                imprimirOpcionesTomarPedidoComidas();
                                opc=elegirOpcion(scan);
                                aux.crearPedido(opc,restaurant.getCartaComidas());
                        }



                    }
                }catch (DniNOexistenteExecption | ComidaInexistenteException e){
                    System.out.println(e.getMessage());
                }


                //buscar cliente y tomar el pedido
                //mini switch de si quiere combo o pedir comida sola
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
        ///todo falta hacer este set

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
    public static void MenuDelivery (int op, Scanner scan)
    {
        Virtual virtual;
        switch (op)
        {
            case 1:
                virtual = crearClienteVirtual(scan);
                //tomar pedido
                break;
            case 2:
                //switch pequeño del pedido
                break;
            case 0:
                //salir
                break;
            default:
                System.out.println("Opción invalida");
                op = elegirOpcion(scan);
                break;
        }
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
