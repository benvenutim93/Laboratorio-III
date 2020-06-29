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
                MenuClientePresencial(var,scan, restaurant, " ");
                break;
            }
            case 2:
                imprimirOpcionesDelivery();
                var = elegirOpcion(scan);
                MenuDelivery(var,scan,restaurant, " ");
                break;
            case 3:
                imprimirOpcionesMesas();
                var = elegirOpcion(scan);
                MenuMesas(var, scan, restaurant);

                break;
            case 4:
                imprimirOpcionesGestionCombosComidas();
                var = elegirOpcion(scan);
                MenuCombos(var,scan,restaurant);
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

    public static void MenuClientePresencial (int op, Scanner scan, Restaurant restaurant, String dni)
    {

        Presencial presencial = null;
        Cliente cliente = null;
        if (dni.equalsIgnoreCase(" ")) {
            System.out.println(" Ingrese Dni del  Cliente: ");
            dni = scan.next();
        }
        switch (op)
        {
            case 1:
                presencial = crearClientePresencial(scan, dni);
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
                //System.out.println(" Ingrese Dni del  Cliente: ");
                //dni=scan.next();
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
                //System.out.println(" Ingrese Dni del  Cliente: ");
                //dni=scan.next();
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
                                    String seguir;
                                    do {
                                            System.out.println(restaurant.listarCombos());
                                            opc = elegirOpcion(scan);
                                            aux.pedirCombo(restaurant.getCartaComidas(), opc);
                                            System.out.println("Desea agregar algo mas? SI/NO");
                                            seguir  = scan.next();
                                            if (seguir.equalsIgnoreCase("si")) {
                                                System.out.println("--------------------------------------------------------");
                                                System.out.println("Su pedido hasta ahora");
                                                System.out.println(aux.mostrarPedidos());
                                                System.out.println("--------------------------------------------------------");

                                            }
                                        }while (seguir.equalsIgnoreCase("Si"));
                                    break;
                                case 2:
                                    String continuar;
                                    do {
                                        imprimirOpcionesTomarPedidoComidas();
                                        opc = elegirOpcion(scan);
                                        aux.crearPedido(opc, restaurant.getCartaComidas());
                                        System.out.println("Desea agregar algo mas? SI/NO");
                                        continuar  = scan.next();
                                        if (continuar.equalsIgnoreCase("si")) {
                                            System.out.println("--------------------------------------------------------");
                                            System.out.println("Su pedido hasta ahora");
                                            System.out.println(aux.mostrarPedidos());
                                            System.out.println("--------------------------------------------------------");

                                        }
                                    }while (continuar.equalsIgnoreCase("si"));
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
                    catch (SentarPersonaException e)
                    {
                        System.out.println(e.getMessage());
                        System.out.println("Desea ubicarlo ahora? SI/NO");
                        String rta = scan.next();

                        if (rta.equalsIgnoreCase("si")) {
                            try {
                                presencial.setEspera(restaurant.ocuparMesa(presencial));
                                MenuClientePresencial(3, scan, restaurant, dni);

                            }  catch (SinMesasException sinMesasException) {
                                System.out.println(sinMesasException.getMessage());
                                MenuPrincipal(scan, restaurant);
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
                //System.out.println(" Ingrese Dni del  Cliente: ");
                //dni=scan.next();
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

    public static Presencial crearClientePresencial(Scanner scan, String dni)
    {
        Presencial a = new Presencial ();
        System.out.println("Nombre: ");
        scan.nextLine();
        a.setNombre(scan.nextLine());
        System.out.println("Apellido: ");
        a.setApellido(scan.nextLine());
        a.setDNI(dni);
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
    public static void MenuDelivery (int op, Scanner scan,Restaurant restaurant, String dni)
    {
        Virtual virtual;
        if (dni.equalsIgnoreCase(" ")) {
            System.out.println(" Ingrese Dni del  Cliente: ");
            dni = scan.next();
        }

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
                //System.out.println(" Ingrese Dni del  Cliente: ");
                //dni=scan.next();
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
                                String seguir;
                                do {
                                    System.out.println(restaurant.listarCombos());
                                    opc = elegirOpcion(scan);
                                    aux.pedirCombo(restaurant.getCartaComidas(), opc);
                                    virtual.calcularFactura();
                                    System.out.println("Desea agregar otro combo mas? SI/NO");
                                    seguir  = scan.next();
                                    if (seguir.equalsIgnoreCase("si")) {
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Su pedido hasta ahora");
                                        System.out.println(aux.mostrarPedidos());
                                        System.out.println("--------------------------------------------------------");

                                    }
                                }while (seguir.equalsIgnoreCase("Si"));
                                break;
                            case 2:
                                String continuar;
                                do {
                                    imprimirOpcionesTomarPedidoComidas();
                                    opc = elegirOpcion(scan);
                                    aux.crearPedido(opc, restaurant.getCartaComidas());
                                    virtual.calcularFactura();
                                    System.out.println("Desea agregar otra comida? SI/NO");
                                    continuar  = scan.next();
                                    if (continuar.equalsIgnoreCase("si")) {
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Su pedido hasta ahora");

                                        System.out.println(aux.mostrarPedidos());
                                        System.out.println("--------------------------------------------------------");

                                    }
                                }while (continuar.equalsIgnoreCase("si"));


                        }
                    }
                }
         catch (DniNOexistenteExecption | ComidaInexistenteException | ComboNoExistenteException e) {
        System.out.println(e.getMessage());
                }
                MenuDelivery(2,scan, restaurant,dni);
                break;
            case 3:
                //System.out.println(" Ingrese Dni del  Cliente: ");
                //dni=scan.next();
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

    public static void MenuMesas (int op, Scanner scan, Restaurant restaurant)
    {
        Mesa mesa;
        switch (op)
        {
            case 1:
                System.out.println(restaurant.imprimirMesasLibres());
                break;
            case 2:
                int id, flag = 0;
                System.out.println(restaurant.imprimirMesasOcupadas());
                System.out.println("Ingrese el ID de la mesa a liberar");
                id = scan.nextInt();
                do {
                        try {
                            restaurant.liberarMesa(id);
                            System.out.println(restaurant.imprimirMesasOcupadas());
                            flag = 1;

                        } catch (IdInexistenteMesaException e) {
                            System.out.println(e.getMessage());
                            System.out.println("Ingrese un ID valido");
                            id = scan.nextInt();
                        } catch (IndexOutOfBoundsException ex)
                        {
                            System.out.println("Ingrese un ID menor o igual a "+restaurant.cantidadMesas());
                            id = scan.nextInt();
                        }
                    } while (flag == 0);
                break;
            case 3:
                String seguir;
                do{
                    restaurant.agregarMesa(crearMesa(scan));
                    System.out.println("Quiere agregar mas mesas? SI/NO");
                    seguir = scan.next();
                }while (seguir.equalsIgnoreCase("si"));
                break;
            case 4:
                int id2;
                System.out.println(restaurant.mostrarListaMesas());
                System.out.println("Ingrese el ID de la mesa a eliminar");
                id2 = scan.nextInt();
                restaurant.eliminarMesa(restaurant.buscarMesaIDmesa(id2));
                System.out.println(restaurant.mostrarListaMesas());
                break;
            case 0:
                break;
            default:
                System.out.println("Opción invalida");
                op = elegirOpcion(scan);
                break;
        }
        MenuPrincipal(scan, restaurant);

    }



    public static void MenuCombos (int op, Scanner scan,Restaurant restaurant)
    {
        Combo combo;
        Comida comida;
        PlatoPrincipal plato ;
        Bebida bebida ;
        Postre postre;
        Guarnicion guarni;
        int pos;String confirmar;
        switch (op)
        {
            case 1:


                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Eliga un PlatoPrincipal"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarPlatosPrincipales());
                pos=elegirOpcion(scan);
                plato= (PlatoPrincipal) restaurant.getCartaComidas().getComidaPos(pos);

                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Eliga una Bebida"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarBebidas());
                pos=elegirOpcion(scan);
                bebida=(Bebida)restaurant.getCartaComidas().getComidaPos(pos);

                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Eliga un Postre"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarPostres());
                pos=elegirOpcion(scan);
                postre=(Postre)restaurant.getCartaComidas().getComidaPos(pos);

                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Eliga una Guarnicion"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarGuarnicion());
                pos=elegirOpcion(scan);
                guarni=(Guarnicion)restaurant.getCartaComidas().getComidaPos(pos);

                combo=new Combo(plato,bebida,postre,guarni);
                System.out.println("\033[33m"+"Combo a agregar "+"\u001B[0m");
                System.out.println(combo.getCombo());
                confirmar=scan.next();

                if (confirmar.equalsIgnoreCase("si")){
                    restaurant.agregarCombo(combo);
                    System.out.println("\033[33m"+"Combo agregado al Resto"+"\u001B[0m");
                }
                break;
            case 2:
                System.out.println("Eliga un combo a " +"\033[31m"+"Eliminar"+"\u001B[0m");
                System.out.println(restaurant.listarCombos());

                pos=elegirOpcion(scan);
                combo= restaurant.getSetCombos().getComboPos(pos);
                System.out.println("\033[33m"+"Combo a "+"\033[31m"+"Eliminar"+"\u001B[0m"+"\u001B[0m");
                System.out.println(combo.getCombo());
                System.out.println("\033[33m"+"Desea borrar este combo (SI/NO) "+"\u001B[0m");
                confirmar=scan.next();
                if(confirmar.equalsIgnoreCase("si")){
                    restaurant.eliminarCombo(combo);
                    System.out.println("\033[33m"+"Combo Eliminado del Restaurant "+"\u001B[0m");
                }
                break;

            case 3:
                break;
            case 4:
            System.out.println("\033[33m"+"Eliga una comida a Borrar"+"\u001B[0m");
            System.out.println("\033[35m"+"Eliga una comida a "+"\033[31m"+"Eliminar"+"\u001B[0m"+ "\u001B[0m");
            System.out.println(restaurant.listarComidaConPosicion());
            pos=elegirOpcion(scan);
            comida=restaurant.getCartaComidas().getComidaPos(pos);

            System.out.println("Desea borra esta comida (SI/NO)");
                System.out.println("\033[31m"+comida.toString()+"\u001B[0m");

            confirmar=scan.next();
            if (confirmar.equalsIgnoreCase("si")){
                restaurant.eliminarComida(comida);
                System.out.println("\033[33m"+"Comida eliminada con exito"+"\u001B[0m");
            }

            break;
            case 5:
                break;
            case 6:
                break;
            case 0:
                break;

        }
        MenuPrincipal(scan,restaurant);
    }




}
