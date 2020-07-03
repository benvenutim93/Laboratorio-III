package Menu;

import java.util.Scanner;

import Archivos.JsonUtiles;
import Colecciones.*;
import Excepciones.*;
import Humanos.*;
import Comidas.*;
import Objetos.*;
import org.json.JSONException;


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
            case 3312:
                try {
                    JsonUtiles.grabar(restaurant.codeRestaurant());
                    System.out.println(restaurant.codeRestaurant());
                } catch (JSONException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 0:
                System.out.println("Gracias, vuelva pronto! =) ");
                break;
            default:
                try{
                    throw new IngresoInvalidoException("Ingreso invalido");
                }
                catch (IngresoInvalidoException a)
                {

                    System.out.println(a.getMessage());
                    System.out.println("Precione enter para Continuar...");
                    new java.util.Scanner(System.in).nextLine();
                    MenuPrincipal(scan,restaurant);

                }
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
        System.out.println(" ---- MENU CLIENTE ----");
        System.out.println("1- Nuevo Cliente");
        System.out.println("2- Cliente existente");
        System.out.println("3- Tomar pedido");
        System.out.println("4- Mostrar datos Cliente");
        System.out.println("5- Eliminar un cliente");
        System.out.println("0- Regresar");
    }

    public static void imprimirOpcionesDelivery ()
    {
        System.out.println("\n\n");
        System.out.println(" ---- MENU DELIVERY ----");
        System.out.println("1- Tomar datos del cliente");
        System.out.println("2- Tomar pedido");
        System.out.println("3- Mostrar datos cliente");
        System.out.println("4- Entregar Pedido");
        System.out.println("5- Eliminar un cliente");
        System.out.println("0- Regresar");
    }
    public static void imprimirOpcionesMesas()
    {
        System.out.println("\n\n");
        System.out.println(" ---- MENU MESAS ----");
        System.out.println("1- Mesas disponibles");
        System.out.println("2- Liberar mesa");
        System.out.println("3- Agregar mesa");
        System.out.println("4- Eliminar mesa");
        System.out.println("0- Regresar");
    }
    public static void imprimirOpcionesGestionCombosComidas ()
    {
        System.out.println("\n\n");
        System.out.println(" ---- MENU GESTION COMIDAS ----");
        System.out.println("1- Agregar combos");
        System.out.println("2- Eliminar combos");
        System.out.println("3- Agregar comidas");
        System.out.println("4- Eliminar comidas");
        System.out.println("5- Modificar precio");
        System.out.println("6- Listado de comidas/combos");
        System.out.println("0-Regresar");
    }
    public static void ImprimirOpcionesSubMenuComida()
    {
        System.out.println(" ---- MENU PLATOS ----");
        System.out.println("1-Bebida");
        System.out.println("2-Plato Principal");
        System.out.println("3-Postre");
        System.out.println("4-Guarnicion");
        System.out.println("0-Regresar");
    }
    public static  void imprimirOpcionesTomarPedido(){
        System.out.println(" ---- MENU COMIDAS ----");
        System.out.println("1-Combos");
        System.out.println("2-Comidas");
        System.out.println("0-Regresar");
    }
    public static void imprimirOpcionesTomarPedidoComidas(){
        System.out.println(" ---- MENU COMIDAS ----");
        System.out.println("1-Bebida");
        System.out.println("2-Plato Princiapl");
        System.out.println("3-Postre");
        System.out.println("4-Guarnicion");
    }

    public static void MenuClientePresencial (int op, Scanner scan, Restaurant restaurant, String dni)
    {
        boolean bande=true;
        Presencial cliente;
        Cliente cliente1;
        if (dni.equalsIgnoreCase(" ") && op<7 && op>0 ) {
            System.out.println(" Ingrese Dni del  Cliente: ");
            dni = scan.next();
        }
        switch (op)
        {
            case 1:
                cliente = crearClientePresencial(scan, dni);
                try {
                    if (!restaurant.agregarCliente(cliente)) {
                        throw new DniExistenteException();

                    }else {
                        System.out.println(cliente.toString());
                        System.out.println("Precione enter para Continuar...");
                        new Scanner(System.in).nextLine();
                    }
                }catch(DniExistenteException e){
                    System.out.println(e.getMessage());

                    bande=true;
                    while(bande)
                    {
                        System.out.println("Ingrese el DNI nuevamente");
                        dni=scan.next();
                        cliente = crearClientePresencial(scan, dni);
                        if (!restaurant.agregarCliente(cliente)) {
                            System.out.println(e.getMessage());
                        }else {
                            bande=false;
                            System.out.println(cliente.toString());
                            System.out.println("Precione enter para Continuar...");
                            new Scanner(System.in).nextLine();
                        }
                    }
                }
                break;
            case 2:
                try {

                    cliente1=  restaurant.buscarPorDni(dni);

                    if (cliente1 != null) {
                        System.out.println("Cliente existe!");
                        System.out.println(cliente1.toString());
                        System.out.println("Precione enter para Continuar...");
                        new Scanner(System.in).nextLine();
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
                    else if(opc.equalsIgnoreCase("no"))
                    {
                        System.out.println("Volviendo al menu principal");
                    }
                    else
                        System.out.println("Opcion incorrecta, volviendo al menu principal");

                }
                break;
            case 3:
                cliente1 = restaurant.buscarPorDni(dni);

                    try {
                        if (cliente1 == null || cliente1 instanceof Virtual) {
                            throw new DniNOexistenteExecption();
                        }
                        else {
                                cliente=(Presencial) cliente1;
                                if (cliente.getEspera() == false) {
                                    int opc;
                                    imprimirOpcionesTomarPedido();
                                    opc = elegirOpcion(scan);
                                    switch (opc) {
                                        case 1:
                                            String seguir;
                                            do {
                                                System.out.println(restaurant.listarCombos());
                                                opc = elegirOpcion(scan);
                                                cliente.pedirCombo(restaurant.getCartaComidas(), opc);
                                                cliente.calcularFactura();
                                                System.out.println("Desea agregar otro combo? SI/NO");
                                                seguir = scan.next();
                                                if (seguir.equalsIgnoreCase("si")) {
                                                    System.out.println("--------------------------------------------------------");
                                                    System.out.println("Su pedido hasta ahora");
                                                    System.out.println(cliente.mostrarPedidos());
                                                    cliente.calcularFactura();
                                                    System.out.println("|"+" Factura "+cliente.getFactura());
                                                    System.out.println("--------------------------------------------------------");
                                                    System.out.println("Precione enter para Continuar...");
                                                    new Scanner(System.in).nextLine();

                                                }
                                                else if (seguir.equalsIgnoreCase("no")) {
                                                    System.out.println("Su pedido es:");
                                                    System.out.println(cliente.mostrarPedidos());
                                                    cliente.calcularFactura();
                                                    System.out.println("|"+" Factura "+cliente.getFactura());
                                                    System.out.println("\nVolviendo al menu principal");
                                                   // MenuPrincipal(scan,restaurant);;
                                                    System.out.println("Volviendo al menu principal");
                                                }
                                                else
                                                    System.out.println("Ingreso erroneo, volviendo al menu agregar comidas");
                                            } while (seguir.equalsIgnoreCase("Si"));
                                            break;
                                        case 2:
                                            String continuar;
                                            do {
                                                imprimirOpcionesTomarPedidoComidas();
                                                opc = elegirOpcion(scan);
                                                cliente.crearPedido(opc, restaurant.getCartaComidas());
                                                cliente.calcularFactura();
                                                System.out.println("Desea agregar otra comida? SI/NO");
                                                continuar = scan.next();
                                                if (continuar.equalsIgnoreCase("si")) {
                                                    System.out.println("--------------------------------------------------------");
                                                    System.out.println("Su pedido hasta ahora");
                                                    System.out.println(cliente.mostrarPedidos());
                                                    cliente.calcularFactura();
                                                    System.out.println("|"+" Factura "+cliente.getFactura());
                                                    System.out.println("--------------------------------------------------------");
                                                    System.out.println("Precione enter para Continuar...");
                                                    new Scanner(System.in).nextLine();
                                                }
                                                else if (continuar.equalsIgnoreCase("no")) {

                                                    System.out.println("Su pedido es:");
                                                    System.out.println(cliente.mostrarPedidos());
                                                    cliente.calcularFactura();
                                                    System.out.println("|" + " Factura " + cliente.getFactura());
                                                    System.out.println("\nVolviendo al menu principal");


                                                    System.out.println("Volviendo al menu principal");
                                                }
                                                else
                                                    System.out.println("Ingreso erroneo, volviendo al menu agregar comidas");

                                            } while (continuar.equalsIgnoreCase("si"));
                                            break;
                                        case 0:

                                            break;
                                        default:
                                            System.out.println("Opción invalida, volviendo al menu principal");
                                            System.out.println("Precione enter para Continuar...");
                                            new Scanner(System.in).nextLine();
                                            break;
                                    }
                                } else {
                                    try {
                                        throw new SentarPersonaException();
                                    } catch (SentarPersonaException e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Desea ubicarlo ahora? SI/NO");
                                        String rta = scan.next();

                                        if (rta.equalsIgnoreCase("si")) {
                                            try {
                                                cliente.setEspera(restaurant.ocuparMesa(cliente));

                                            } catch (SinMesasException sinMesasException) {
                                                System.out.println(sinMesasException.getMessage());
                                            } catch (CapacidadMaximaException capacidadMaximaException) {
                                                System.out.println(capacidadMaximaException.getMessage());
                                            } catch (IdInexistenteMesaException idInexistenteMesaException) {
                                                idInexistenteMesaException.printStackTrace();
                                            }
                                        } else if (rta.equalsIgnoreCase("no")) {
                                            System.out.println("Volviendo Menu Principal");
                                            System.out.println("\n");
                                            System.out.println("Precione enter para Continuar...");
                                            new Scanner(System.in).nextLine();

                                        } else {
                                            try {
                                                throw new IngresoInvalidoException("Ingreso invalido");

                                            } catch (IngresoInvalidoException h) {
                                                System.out.println(h.getMessage());
                                                System.out.println("Volviendo al menu principal");
                                            }
                                        }
                                    }
                                }

                        }
                    }
                     catch (DniNOexistenteExecption  e) {
                         System.out.println(e.getMessage());
                         bande=true;
                         while(bande) {
                             System.out.println(" Ingrese Dni nuevamente ");
                             dni = scan.next();
                             cliente1 = restaurant.buscarPorDni(dni);

                                 if (cliente1 == null || cliente1 instanceof Virtual) {
                                     System.out.println(e.getMessage());
                                 }
                                 else {
                                     bande=false;
                                     cliente=(Presencial) cliente1;
                                     if (cliente.getEspera() == false) {
                                         int opc;
                                         imprimirOpcionesTomarPedido();
                                         opc = elegirOpcion(scan);
                                         switch (opc) {
                                             case 1:
                                                 String seguir;
                                                 do {
                                                     System.out.println(restaurant.listarCombos());
                                                     opc = elegirOpcion(scan);
                                                     try {
                                                         cliente.pedirCombo(restaurant.getCartaComidas(), opc);
                                                     } catch (ComboNoExistenteException comboNoExistenteException) {
                                                         comboNoExistenteException.printStackTrace();
                                                     }
                                                     cliente.calcularFactura();
                                                     System.out.println("Desea agregar otro combo? SI/NO");
                                                     seguir = scan.next();
                                                     if (seguir.equalsIgnoreCase("si")) {
                                                         System.out.println("--------------------------------------------------------");
                                                         System.out.println("Su pedido hasta ahora");
                                                         System.out.println(cliente.mostrarPedidos());
                                                         cliente.calcularFactura();
                                                         System.out.println("|"+" Factura "+cliente.getFactura());
                                                         System.out.println("--------------------------------------------------------");
                                                         System.out.println("Precione enter para Continuar...");
                                                         new Scanner(System.in).nextLine();

                                                     }
                                                     else if (seguir.equalsIgnoreCase("no")) {
                                                         System.out.println("Su pedido es:");
                                                         System.out.println(cliente.mostrarPedidos());
                                                         cliente.calcularFactura();
                                                         System.out.println("|"+" Factura "+cliente.getFactura());
                                                         System.out.println("\nVolviendo al menu principal");
                                                         // MenuPrincipal(scan,restaurant);;
                                                         System.out.println("Volviendo al menu principal");
                                                     }
                                                     else
                                                         System.out.println("Ingreso erroneo, volviendo al menu agregar comidas");
                                                 } while (seguir.equalsIgnoreCase("Si"));
                                                 break;
                                             case 2:
                                                 String continuar;
                                                 do {
                                                     imprimirOpcionesTomarPedidoComidas();
                                                     opc = elegirOpcion(scan);
                                                     try {
                                                         cliente.crearPedido(opc, restaurant.getCartaComidas());
                                                     } catch (ComidaInexistenteException comidaInexistenteException) {
                                                         comidaInexistenteException.printStackTrace();
                                                     }
                                                     cliente.calcularFactura();
                                                     System.out.println("Desea agregar otra comida? SI/NO");
                                                     continuar = scan.next();
                                                     if (continuar.equalsIgnoreCase("si")) {
                                                         System.out.println("--------------------------------------------------------");
                                                         System.out.println("Su pedido hasta ahora");
                                                         System.out.println(cliente.mostrarPedidos());
                                                         cliente.calcularFactura();
                                                         System.out.println("|"+" Factura "+cliente.getFactura());
                                                         System.out.println("--------------------------------------------------------");
                                                         System.out.println("Precione enter para Continuar...");
                                                         new Scanner(System.in).nextLine();
                                                     }
                                                     else if (continuar.equalsIgnoreCase("no")) {

                                                         System.out.println("Su pedido es:");
                                                         System.out.println(cliente.mostrarPedidos());
                                                         cliente.calcularFactura();
                                                         System.out.println("|" + " Factura " + cliente.getFactura());
                                                         System.out.println("\nVolviendo al menu principal");


                                                         System.out.println("Volviendo al menu principal");
                                                     }
                                                     else
                                                         System.out.println("Ingreso erroneo, volviendo al menu agregar comidas");

                                                 } while (continuar.equalsIgnoreCase("si"));
                                                 break;
                                             case 0:

                                                 break;
                                             default:
                                                 System.out.println("Opción invalida, volviendo al menu principal");
                                                 System.out.println("Precione enter para Continuar...");
                                                 new Scanner(System.in).nextLine();
                                                 break;
                                         }
                                     } else {
                                         try {
                                             throw new SentarPersonaException();
                                         } catch (SentarPersonaException ee) {
                                             System.out.println(ee.getMessage());
                                             System.out.println("Desea ubicarlo ahora? SI/NO");
                                             String rta = scan.next();

                                             if (rta.equalsIgnoreCase("si")) {
                                                 try {
                                                     cliente.setEspera(restaurant.ocuparMesa(cliente));

                                                 } catch (SinMesasException sinMesasException) {
                                                     System.out.println(sinMesasException.getMessage());
                                                 } catch (CapacidadMaximaException capacidadMaximaException) {
                                                     System.out.println(capacidadMaximaException.getMessage());
                                                 } catch (IdInexistenteMesaException idInexistenteMesaException) {
                                                     idInexistenteMesaException.printStackTrace();
                                                 }
                                             } else if (rta.equalsIgnoreCase("no")) {
                                                 System.out.println("Volviendo Menu Principal");
                                                 System.out.println("\n");
                                                 System.out.println("Precione enter para Continuar...");
                                                 new Scanner(System.in).nextLine();

                                             } else {
                                                 try {
                                                     throw new IngresoInvalidoException("Ingreso invalido");

                                                 } catch (IngresoInvalidoException h) {
                                                     System.out.println(h.getMessage());
                                                     System.out.println("Volviendo al menu principal");
                                                 }
                                             }
                                         }
                                     }
                             }
                         }

                    }
                    catch( ComidaInexistenteException a)
                    {
                        System.out.println(a.getMessage());
                     }
                    catch( ComboNoExistenteException f)
                    {
                        System.out.println(f.getMessage());
                    }

                break;
            case 4:
                 cliente1= restaurant.buscarPorDni(dni);
                try{
                    if (cliente1 == null) {
                        throw new DniNOexistenteExecption();
                    }
                    else {
                        if(cliente1 instanceof Virtual)
                        {
                            System.out.println("Su dni ingresado corresponde a un cliente virtual\n");

                            System.out.println(cliente1.toString());
                        }
                        else
                        System.out.println(cliente1.toString());
                    }
                }
                catch (DniNOexistenteExecption e){
                    System.out.println(e.getMessage());

                     bande=true;
                    while(bande) {
                        System.out.println("Ingrese el DNI nuevamente");
                        dni=scan.next();
                        cliente1= restaurant.buscarPorDni(dni);

                        if (cliente1 == null) {
                            System.out.println(e.getMessage());
                        } else {
                            if (cliente1 instanceof Virtual) {
                                System.out.println("Su dni ingresado corresponde a un cliente virtual\n");

                                System.out.println(cliente1.toString());
                                bande=false;
                            } else {
                                System.out.println(cliente1.toString());
                                bande= false;
                            }
                        }
                    }

                }
                break;
            case 5:

                 cliente1=restaurant.buscarPorDni(dni);
                String sino;
                try{
                if(cliente1==null)
                    throw new DniNOexistenteExecption();
                else if(cliente1 instanceof Virtual) {

                    System.out.println("El cliente seleccionado es un cliente Virtual, desea eliminarlo igual? si/no");
                    sino=scan.next();
                    if(sino.equalsIgnoreCase("si")) {
                        System.out.println(cliente1.toString());
                        System.out.println("\nEste cliente ah sido eliminado");
                        restaurant.eliminarCliente(cliente1);
                    }
                    else
                        System.out.println("El cliente no ah sido eliminado");
                }
                else{
                    System.out.println(cliente1.toString());
                    System.out.println("\nEste cliente ah sido eliminado");
                    restaurant.eliminarCliente(cliente1);
                }
                }catch (DniNOexistenteExecption a)
                {
                    System.out.println(a.getMessage());
                         bande=true;
                        while(bande)
                        {
                            System.out.println("Ingrese el dni del cliente a eliminar nuevamente");
                            dni=scan.next();
                            cliente1=restaurant.buscarPorDni(dni);
                            if(cliente1==null)
                                System.out.println(a.getMessage());
                            else if(cliente1 instanceof Virtual) {

                                System.out.println("El cliente seleccionado es un cliente Virtual, desea eliminarlo igual? si/no");
                                sino=scan.next();
                                if(sino.equalsIgnoreCase("si")) {
                                    System.out.println(cliente1.toString());
                                    System.out.println("\nEste cliente ah sido eliminado");
                                    restaurant.eliminarCliente(cliente1);
                                    bande=false;
                                }
                                else {
                                    System.out.println("El cliente no ah sido eliminado");
                                    bande=false;
                                }
                            }
                            else{
                                System.out.println(cliente1.toString());
                                System.out.println("\nEste cliente ah sido eliminado");
                                restaurant.eliminarCliente(cliente1);
                                bande=false;
                            }
                        }
                }
                break;
            case 0: //salir
                break;
            default:
                System.out.println("Opción invalida");
                System.out.println("\nVolviendo al menu principal");

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
    public static Virtual crearClienteVirtual (Scanner scan,String dni)
    {
        String calle = "";
        String altura = "";
        Virtual a = new Virtual ();
        System.out.println("Nombre: ");
        a.setNombre(scan.next());
        System.out.println("Apellido: ");
        a.setApellido(scan.next());
        a.setDNI(dni);
        System.out.println("Telefono: ");
        a.setTelefono(scan.next());
        System.out.println("Calle: ");
        calle = scan.next();
        System.out.println("Altura: " );
        altura = scan.next();
        a.setDireccion(calle, altura);
        return a;
    }
    public static void MenuDelivery (int op, Scanner scan,Restaurant restaurant, String dni)
    {
        boolean bandera;
        Cliente virtual1;
        String sino;
        if (dni.equalsIgnoreCase(" ")&& op!=4 && op>0 && op<6) {
            System.out.println(" Ingrese Dni del  Cliente: ");
            dni = scan.next();
        }

        switch (op)
        {
            case 1:

                virtual1 = crearClienteVirtual(scan,dni);

                try {
                    if (!restaurant.agregarCliente(virtual1)) {
                        throw new DniExistenteException();

                    }else {
                        System.out.println(virtual1.toString());
                    }
                }catch(DniExistenteException e){
                    System.out.println(e.getMessage());
                    System.out.println("Desea probar con otro DNI? si/no");
                    sino=scan.next();
                    if(sino.equalsIgnoreCase("si"))
                    {
                         bandera=true;
                        while(bandera) {
                            System.out.println("Ingrese de nuevo el dni");
                            dni = scan.next();
                            virtual1=crearClienteVirtual(scan,dni);
                            if (!restaurant.agregarCliente(virtual1)) {
                                System.out.println(e.getMessage());

                            }else {
                                System.out.println(virtual1.toString());
                                bandera=false;
                            }
                        }
                    }
                    else
                        System.out.println("Volviendo al menu principal");
                }
                break;
            case 2:
                try {
                   virtual1 = restaurant.buscarPorDni(dni);
                    if (virtual1 == null) {
                        throw new DniNOexistenteExecption();
                    }
                    else if(virtual1 instanceof Presencial)
                    {
                        throw new DniNOexistenteExecption();
                    }
                    else {
                        int opc;
                        imprimirOpcionesTomarPedido();
                        opc = elegirOpcion(scan);
                        switch (opc) {
                            case 1:
                                String seguir;
                                do {
                                    System.out.println(restaurant.listarCombos());
                                    opc = elegirOpcion(scan);
                                    virtual1.pedirCombo(restaurant.getCartaComidas(), opc);
                                    virtual1.calcularFactura();
                                    System.out.println("Desea agregar otro combo? SI/NO");
                                    seguir  = scan.next();
                                    if (seguir.equalsIgnoreCase("si")) {
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Su pedido hasta ahora");
                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|"+" Factura "+virtual1.getFactura());
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Precione enter para Continuar...");
                                        new Scanner(System.in).nextLine();

                                    }
                                    else if(seguir.equalsIgnoreCase("no"))
                                    {
                                        System.out.println("Su pedido es:");
                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|"+" Factura "+virtual1.getFactura());
                                        System.out.println("\nVolviendo al menu principal");

                                    }
                                    else {
                                        System.out.println("Ingreso invalido, volviendo al menu principal");

                                    }
                                }while (seguir.equalsIgnoreCase("Si"));
                                break;
                            case 2:

                                String continuar;
                                do {
                                    imprimirOpcionesTomarPedidoComidas();
                                    opc = elegirOpcion(scan);
                                    virtual1.crearPedido(opc, restaurant.getCartaComidas());
                                    virtual1.calcularFactura();
                                    System.out.println("Desea agregar otra comida? SI/NO");
                                    continuar  = scan.next();
                                    if (continuar.equalsIgnoreCase("si")) {
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Su pedido hasta ahora");

                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|"+" Factura "+virtual1.getFactura());
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Precione enter para Continuar...");
                                        new Scanner(System.in).nextLine();

                                    }
                                    else if(continuar.equalsIgnoreCase("no"))
                                    {
                                        System.out.println("Su pedido es:");
                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|"+" Factura "+virtual1.getFactura());
                                        System.out.println("\nVolviendo al menu principal");

                                    }
                                    else {
                                        System.out.println("Ingreso invalido, volviendo al menu principal");
                                    }
                                }while (continuar.equalsIgnoreCase("si"));
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion invalida, volviendo al menu principal");
                                break;
                        }
                    }
                }
                catch (DniNOexistenteExecption e) {
                    System.out.println(e.getMessage());
                     bandera = true;
                    while (bandera){
                        System.out.println(" Ingrese Dni nuevamente ");
                    dni = scan.next();
                    virtual1 = restaurant.buscarPorDni(dni);
                    if (virtual1 == null) {
                        System.out.println(e.getMessage());
                    }
                    else if(virtual1 instanceof Presencial)
                    {
                        System.out.println("El DNI es de un cliente presencial");
                        System.out.println("Desea buscar otro? si/no");
                        sino=scan.next();
                        if (sino.equalsIgnoreCase("no"))
                            bandera= false;
                        else if (sino.equalsIgnoreCase("si"))
                            System.out.println("Seguira buscando");
                        else
                            System.out.println("Opcion incorrecta, seguira buscando");
                    }
                    else {
                        bandera=false;
                        int opc;
                        imprimirOpcionesTomarPedido();
                        opc = elegirOpcion(scan);
                        switch (opc) {
                            case 1:
                                String seguir;
                                do {
                                    System.out.println(restaurant.listarCombos());
                                    opc = elegirOpcion(scan);
                                    try {
                                        virtual1.pedirCombo(restaurant.getCartaComidas(), opc);
                                    } catch (ComboNoExistenteException comboNoExistenteException) {
                                        comboNoExistenteException.printStackTrace();
                                    }
                                    virtual1.calcularFactura();
                                    System.out.println("Desea agregar otro combo? SI/NO");
                                    seguir = scan.next();
                                    if (seguir.equalsIgnoreCase("si")) {
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Su pedido hasta ahora");
                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|" + " Factura " + virtual1.getFactura());
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Precione enter para Continuar...");
                                        new Scanner(System.in).nextLine();

                                    } else if (seguir.equalsIgnoreCase("no")) {
                                        System.out.println("Su pedido es:");
                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|" + " Factura " + virtual1.getFactura());
                                        System.out.println("\nVolviendo al menu principal");

                                    } else {
                                        System.out.println("Ingreso invalido, volviendo al menu principal");

                                    }
                                } while (seguir.equalsIgnoreCase("Si"));
                                break;
                            case 2:

                                String continuar;
                                do {
                                    imprimirOpcionesTomarPedidoComidas();
                                    opc = elegirOpcion(scan);
                                    try {
                                        virtual1.crearPedido(opc, restaurant.getCartaComidas());
                                    } catch (ComidaInexistenteException comidaInexistenteException) {
                                        comidaInexistenteException.printStackTrace();
                                    }
                                    virtual1.calcularFactura();
                                    System.out.println("Desea agregar otra comida? SI/NO");
                                    continuar = scan.next();
                                    if (continuar.equalsIgnoreCase("si")) {
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Su pedido hasta ahora");

                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|" + " Factura " + virtual1.getFactura());
                                        System.out.println("--------------------------------------------------------");
                                        System.out.println("Precione enter para Continuar...");
                                        new Scanner(System.in).nextLine();

                                    } else if (continuar.equalsIgnoreCase("no")) {
                                        System.out.println("Su pedido es:");
                                        System.out.println(virtual1.mostrarPedidos());
                                        virtual1.calcularFactura();
                                        System.out.println("|" + " Factura " + virtual1.getFactura());
                                        System.out.println("\nVolviendo al menu principal");

                                    } else {
                                        System.out.println("Ingreso invalido, volviendo al menu principal");
                                    }
                                } while (continuar.equalsIgnoreCase("si"));
                                break;
                            case 0:
                                break;
                            default:
                                System.out.println("Opcion invalida, volviendo al menu principal");
                                break;
                        }
                    }
                }
                }
                catch (ClassCastException kk)
                {
                    System.out.println("El DNI ingresado corresponde a un cliente presencial");
                    System.out.println(" Ingrese Dni nuevamente ");
                    dni = scan.next();
                    MenuDelivery(2,scan,restaurant,dni);
                }
                catch(ComidaInexistenteException g)
                {
                    System.out.println(g.getMessage());

                }
                catch( ComboNoExistenteException l)
                {
                    System.out.println(l.getMessage());
                }
                break;
            case 3:
                 virtual1= restaurant.buscarPorDni(dni);
                try{
                    if (virtual1 == null) {
                        throw new DniNOexistenteExecption();
                    }
                    else{

                        if (virtual1 instanceof Presencial)
                        {
                            System.out.println("El dni ingresado corresponde a un cliente Presencial");
                            System.out.println(virtual1.toString());
                        }
                        else
                            System.out.println(virtual1.toString());
                    }
                }
                catch (DniNOexistenteExecption e){
                    System.out.println(e.getMessage());
                    bandera=true;
                    while(bandera=true)
                    {
                        System.out.println("Ingrese el DNI nuevamente");
                        dni=scan.next();
                        virtual1= restaurant.buscarPorDni(dni);
                        if (virtual1 == null) {
                            System.out.println(e.getMessage());
                        }
                        else{
                            if (virtual1 instanceof Presencial)
                            {
                                System.out.println("El dni ingresado corresponde a un cliente Presencial");
                                System.out.println(virtual1.toString());

                            }
                            else
                                System.out.println(virtual1.toString());

                            bandera=false;
                        }
                    }
                }
                break;
            case 4:
                Virtual cliente;
                System.out.println(restaurant.getListaClientes().listarDeliveryEntregado());
                System.out.println("Ingrese el dni del cliente a entregar el pedido");
                dni=scan.next();
                virtual1= restaurant.buscarPorDni(dni);
                try {
                    if (virtual1 == null || virtual1 instanceof Presencial) {
                        throw new DniNOexistenteExecption();
                    } else {
                        cliente = (Virtual) restaurant.buscarPorDni(dni);
                        cliente.setEntregado(true);
                        System.out.println("Precione enter para Continuar...");
                        new Scanner(System.in).nextLine();
                        System.out.println(cliente.toString());
                    }
                }
                catch (DniNOexistenteExecption j)
                {
                    System.out.println(j.getMessage());
                    bandera=true;
                    while(bandera){
                        if (virtual1 == null ) {
                            System.out.println(j.getMessage());
                        }
                        else if(virtual1 instanceof Presencial)
                        {
                            System.out.println("El DNI ingresado corresponde a un cliente presencial");
                            bandera=false;
                        }
                        else {
                            bandera=false;
                            cliente = (Virtual) restaurant.buscarPorDni(dni);
                            cliente.setEntregado(true);
                            System.out.println("Precione enter para Continuar...");
                            new Scanner(System.in).nextLine();
                            System.out.println(cliente.toString());
                        }
                    }
                }
                break;
            case 5:
                System.out.println("Ingrese el dni del cliente a eliminar");
                dni=scan.next();
                virtual1=restaurant.buscarPorDni(dni);
                try{
                    if(virtual1==null)
                        throw new DniNOexistenteExecption();
                    else if(virtual1 instanceof Presencial) {

                        System.out.println("El cliente seleccionado es un cliente Presencial, desea eliminarlo igual? si/no");
                        sino=scan.next();
                        if(sino.equalsIgnoreCase("si")) {
                            System.out.println(virtual1.toString());
                            System.out.println("\nEste cliente ah sido eliminado");
                            restaurant.eliminarCliente(virtual1);
                        }
                        else
                            System.out.println("El cliente no ah sido eliminado");
                    }
                    else{
                        System.out.println(virtual1.toString());
                        System.out.println("\nEste cliente ah sido eliminado");
                        restaurant.eliminarCliente(virtual1);
                    }
                }catch (DniNOexistenteExecption a)
                {

                    System.out.println(a.getMessage());
                    bandera=true;
                    while(bandera==true) {
                        System.out.println("Ingrese el dni del cliente a eliminar");
                        dni=scan.next();
                        virtual1=restaurant.buscarPorDni(dni);

                        if (virtual1 == null) {
                            System.out.println(a.getMessage());
                        }
                        else if (virtual1 instanceof Presencial) {
                            System.out.println("El cliente seleccionado es un cliente Presencial, desea eliminarlo igual? si/no");
                            sino = scan.next();
                            if (sino.equalsIgnoreCase("si")) {
                                System.out.println(virtual1.toString());
                                System.out.println("\nEste cliente ah sido eliminado");
                                restaurant.eliminarCliente(virtual1);
                            } else
                                System.out.println("El cliente no ah sido eliminado");

                            bandera=false;
                        } else {
                            System.out.println(virtual1.toString());
                            System.out.println("\nEste cliente ah sido eliminado");
                            restaurant.eliminarCliente(virtual1);
                            bandera=false;
                        }
                    }
                }
                break;
            case 0:
                //salir
                break;
            default:
                System.out.println("Opción invalida,Volviendo al menu principal");
                break;
        }
        MenuPrincipal(scan,restaurant);
    }

    public static Mesa crearMesa (Scanner scan)
    {
        Mesa a = new Mesa ();
        System.out.println("Capacidad: ");
        a.setCapacidad(scan.nextInt());
        while(a.getCapacidad()<=0)
        {
            System.out.println("ingrese un numero mayor a 0");
            a.setCapacidad(scan.nextInt());
        }
        return a;
    }

    public static void MenuMesas (int op, Scanner scan, Restaurant restaurant)
    {
        Mesa mesa;
        switch (op)
        {
            case 1:
                System.out.println(restaurant.imprimirMesasLibres());
                System.out.println("Precione enter para Continuar...");
                new java.util.Scanner(System.in).nextLine();
                break;
            case 2:
                int id, flag = 0;
                try {
                    if (restaurant.getListaMesas().cantidadMesasLibres() == 0) {
                        throw new MesasLibresException("Todas las mesas estan disponibles");
                    }
                    else
                        {
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
                            } catch (IndexOutOfBoundsException ex) {
                                System.out.println("Ingrese un ID menor o igual a " + restaurant.cantidadMesas());
                                id = scan.nextInt();
                            }
                        } while (flag == 0);
                    }
                }
                catch (MesasLibresException a)
                {
                    System.out.println(a.getMessage());
                }

                break;
            case 3:
                String seguir;
                do{

                    restaurant.agregarMesa(crearMesa(scan));
                    System.out.println("Quiere agregar mas mesas? SI/NO");
                    seguir = scan.next();

                }while (seguir.equalsIgnoreCase("si"));

                if(seguir.equalsIgnoreCase("no"))
                {
                    System.out.println("Rergresando al menu principal");
                    MenuPrincipal(scan,restaurant);
                }
                else
                {
                    System.out.println("Opcion incorrecta, volviendo al menu principal");
                    MenuPrincipal(scan,restaurant);
                }
                break;
            case 4:
                int id2;
                System.out.println(restaurant.mostrarListaMesas());
                System.out.println("Ingrese el ID de la mesa a eliminar");
                id2 = scan.nextInt();
                try {
                    if (id2 > restaurant.getListaMesas().cantidadMesasLibres()) {
                        throw new IdInexistenteMesaException("El id ingresado no existe");
                    }
                    else {
                        restaurant.eliminarMesa(restaurant.buscarMesaIDmesa(id2));
                        System.out.println(restaurant.mostrarListaMesas());
                    }
                }
                catch (IdInexistenteMesaException a)
                {
                    System.out.println(a.getMessage());
                    while(id2 > restaurant.getListaMesas().cantidadMesas())
                    {
                        System.out.println("Ingrese un id valido");
                        id2 = scan.nextInt();
                    }
                    restaurant.eliminarMesa(restaurant.buscarMesaIDmesa(id2));
                    System.out.println(restaurant.mostrarListaMesas());
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Opción invalida");
                op = elegirOpcion(scan);
                MenuMesas(op,scan,restaurant);
                break;
        }
        MenuPrincipal(scan, restaurant);

    }



    public static void MenuCombos (int op, Scanner scan,Restaurant restaurant)
    {
        Combo combo=null;
        Comida comida=null;
        PlatoPrincipal plato =null;
        Bebida bebida=null ;
        Postre postre=null;
        Guarnicion guarni=null;
        int pos;String confirmar;
        switch (op)
        {
            case 1:


                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Elija un PlatoPrincipal"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarPlatosPrincipales());
                pos=elegirOpcion(scan);
                try {
                    if(pos<=restaurant.getCartaComidas().getListaComida().getCantComidas()) {
                        if (restaurant.getCartaComidas().getComidaPos(pos) instanceof PlatoPrincipal) {
                            plato = (PlatoPrincipal) restaurant.getCartaComidas().getComidaPos(pos);
                        } else
                            throw new ComidaInexistenteException("La opcion ingresada no existe");
                    }
                    else
                        throw new ComidaInexistenteException("La opcion ingresada no existe");
                }
                catch(ComidaInexistenteException a)
                    {
                        boolean bandera=true;
                        while(bandera==true) {
                            System.out.println(a.getMessage());
                            pos = elegirOpcion(scan);
                            if (restaurant.getCartaComidas().getComidaPos(pos) instanceof PlatoPrincipal) {
                                plato = (PlatoPrincipal) restaurant.getCartaComidas().getComidaPos(pos);
                                bandera=false;
                            }
                        }
                    }

                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Elija una Bebida"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarBebidas());
                pos=elegirOpcion(scan);

                try {
                    if(pos<=restaurant.getCartaComidas().getListaComida().getCantComidas()) {
                        if (restaurant.getCartaComidas().getComidaPos(pos) instanceof Bebida) {
                            bebida = (Bebida) restaurant.getCartaComidas().getComidaPos(pos);
                        } else
                            throw new ComidaInexistenteException("La opcion ingresada no existe");
                    }
                    else
                        throw new ComidaInexistenteException("La opcion ingresada no existe");
                }
                catch(ComidaInexistenteException a)
                {
                    boolean bandera=true;
                    while(bandera==true) {
                        System.out.println(a.getMessage());
                        pos = elegirOpcion(scan);
                        if (restaurant.getCartaComidas().getComidaPos(pos) instanceof Bebida) {
                            bebida = (Bebida) restaurant.getCartaComidas().getComidaPos(pos);
                            bandera=false;
                        }

                    }

                }

                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Elija un Postre"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarPostres());
                pos=elegirOpcion(scan);
                try {
                    if(pos<=restaurant.getCartaComidas().getListaComida().getCantComidas()) {
                        if (restaurant.getCartaComidas().getComidaPos(pos) instanceof Postre) {
                            postre = (Postre) restaurant.getCartaComidas().getComidaPos(pos);
                        } else
                            throw new ComidaInexistenteException("La opcion ingresada no existe");
                    }
                    else
                        throw new ComidaInexistenteException("La opcion ingresada no existe");
                }
                catch(ComidaInexistenteException a)
                {
                    boolean bandera=true;
                    while(bandera==true) {
                        System.out.println(a.getMessage());
                        pos = elegirOpcion(scan);
                        if (restaurant.getCartaComidas().getComidaPos(pos) instanceof Postre) {
                            postre = (Postre) restaurant.getCartaComidas().getComidaPos(pos);
                            bandera=false;
                        }
                    }
                }

                System.out.println("\033[33m"+"Creando Combo"+"\u001B[0m");
                System.out.println("\033[35m"+"Elija una Guarnicion"+"\u001B[0m");
                System.out.println(restaurant.getCartaComidas().listarGuarnicion());
                pos=elegirOpcion(scan);
                try {
                    if(pos<=restaurant.getCartaComidas().getListaComida().getCantComidas()) {
                        if (restaurant.getCartaComidas().getComidaPos(pos) instanceof Guarnicion) {
                            guarni = (Guarnicion) restaurant.getCartaComidas().getComidaPos(pos);
                        } else
                            throw new ComidaInexistenteException("La opcion ingresada no existe");
                    }
                    else
                        throw new ComidaInexistenteException("La opcion ingresada no existe");
                }
                catch(ComidaInexistenteException a)
                {
                    boolean bandera=true;
                    while(bandera==true) {
                        System.out.println(a.getMessage());
                        pos = elegirOpcion(scan);
                        if(pos<=restaurant.getCartaComidas().getListaComida().getCantComidas()) {
                            if (restaurant.getCartaComidas().getComidaPos(pos) instanceof Guarnicion) {
                                guarni = (Guarnicion) restaurant.getCartaComidas().getComidaPos(pos);
                                bandera = false;
                            }
                        }
                    }
                }

                combo=new Combo(plato,bebida,postre,guarni);
                System.out.println("\033[33m"+"Combo a agregar "+"\u001B[0m");
                System.out.println(combo.getCombo());
                System.out.println("Desea confirmar? si/no");
                confirmar=scan.next();

                if (confirmar.equalsIgnoreCase("si")){
                    restaurant.agregarCombo(combo);
                    System.out.println("\033[33m"+"Combo agregado al Resto"+"\u001B[0m");
                }
                else if(confirmar.equalsIgnoreCase("no")) {
                    System.out.println("Volviendo al menu principal");
                    MenuPrincipal(scan,restaurant);
                }
                else {
                    System.out.println("Ingreso invalido, volviendo al menu principal");
                    MenuPrincipal(scan,restaurant);
                }
                break;
            case 2:
                System.out.println("Elija un combo a " +"\033[31m"+"Eliminar"+"\u001B[0m");
                System.out.println(restaurant.listarCombos());
                pos=elegirOpcion(scan);
                try {
                    if (pos <= restaurant.getCartaComidas().getCantidadCombo()) {
                        combo = restaurant.getSetCombos().getComboPos(pos);
                        System.out.println("\033[33m" + "Combo a " + "\033[31m" + "Eliminar" + "\u001B[0m" + "\u001B[0m");
                        System.out.println(combo.getCombo());
                        System.out.println("\033[33m" + "Desea borrar este combo (SI/NO) " + "\u001B[0m");
                        confirmar = scan.next();
                        if (confirmar.equalsIgnoreCase("si")) {
                            restaurant.eliminarCombo(combo);
                            System.out.println("\033[33m" + "Combo Eliminado del Restaurant " + "\u001B[0m");
                        }
                    } else
                        throw new ComboNoExistenteException("La opcion ingresada no corresponde a ningun combo");
                }
                catch (ComboNoExistenteException a) {
                    boolean bandera = true;

                    while (bandera == true) {
                        System.out.println(a.getMessage());
                        pos = elegirOpcion(scan);
                        if (pos <= restaurant.getCartaComidas().getCantidadCombo()) {
                            combo = restaurant.getSetCombos().getComboPos(pos);
                            bandera = false;
                        }
                    }
                    System.out.println("\033[33m" + "Combo a " + "\033[31m" + "Eliminar" + "\u001B[0m" + "\u001B[0m");
                    System.out.println(combo.getCombo());
                    System.out.println("\033[33m" + "Desea borrar este combo (SI/NO) " + "\u001B[0m");
                    confirmar = scan.next();
                    if (confirmar.equalsIgnoreCase("si")) {
                        restaurant.eliminarCombo(combo);
                        System.out.println("\033[33m" + "Combo Eliminado del Restaurant " + "\u001B[0m");
                    }
                    else if(confirmar.equalsIgnoreCase("no")) {
                        System.out.println("Volviendo al menu principal");
                        MenuPrincipal(scan,restaurant);
                    }
                    else {
                        System.out.println("Ingreso invalido, volviendo al menu principal");
                        MenuPrincipal(scan,restaurant);
                    }
                }
                break;

            case 3:
                ImprimirOpcionesSubMenuComida();
                op=elegirOpcion(scan);
                String nombre="";
                double precio=0;
                switch (op)
                {
                    case 1:
                        System.out.println("Ingrese el precio");
                        precio=scan.nextInt();
                        System.out.println("Ingrese el nombre");
                        nombre=scan.next();
                        System.out.println("desea gas? si/no");
                        boolean gas;
                        String opcion=scan.next();
                        if(opcion.equalsIgnoreCase("si"))
                        {
                            gas=true;
                        }
                        else if(opcion.equalsIgnoreCase("no"))
                            gas=false;
                        else
                        {
                            System.out.println("Opcion invalida sera enviada con gas");
                            gas=true;
                        }
                        System.out.println("Ingrese  temperatura: ");
                        String temperatura="";
                        System.out.println("1-Fria ");
                        System.out.println("2-Caliente");
                        System.out.println("3-Temperatura ambiente");
                        int opcion1=scan.nextInt();
                        if(opcion1==1)
                            temperatura="Fria";
                        else if(opcion1==2)
                            temperatura="Caliente";
                        else if (opcion1==3)
                            temperatura = "Temperatura ambiente";
                        else
                        {
                            System.out.println("Opcion invalida sera enviada con temperatura ambiente");
                            temperatura="Temperatura ambiente";
                        }
                        Bebida b1= new Bebida(precio,nombre,gas,temperatura);
                        System.out.println("Esta es su bebida creada\n");
                        System.out.println(b1.toString());
                        restaurant.getCartaComidas().agregarComida(b1);

                        break;
                    case 2:
                        boolean tcc;
                        System.out.println("Ingrese el precio");
                        precio=scan.nextInt();
                        System.out.println("Ingrese el nombre");
                        nombre=scan.next();
                        System.out.println("Apto celiaco? si/no ");
                        String tacc=scan.next();
                        if(tacc.equalsIgnoreCase("si"))
                        {
                         tcc=true;
                        }
                        else
                            tcc=false;
                        PlatoPrincipal plat1= new PlatoPrincipal(precio,nombre,tcc);
                        System.out.println(plat1.toString());
                        System.out.println("Este es su plato creado\n");
                        restaurant.getCartaComidas().agregarComida(plat1);
                        break;
                    case 3:
                        boolean top;
                        System.out.println("Ingrese el precio");
                        precio=scan.nextInt();
                        System.out.println("Ingrese el nombre");
                        nombre=scan.next();
                        System.out.println("Salsa? si/no");
                        String topito=scan.next();
                        if (topito.equalsIgnoreCase("si"))
                        {
                            top=true;
                        }
                        else
                            top=false;
                        Postre pote1= new Postre(precio,nombre,top);
                        System.out.println("Este es su postre creado\n");
                        System.out.println(pote1.toString());
                        restaurant.getCartaComidas().agregarComida(pote1);
                        break;
                    case 4:
                        boolean sal;
                        System.out.println("Ingrese el precio");
                        precio=scan.nextInt();
                        System.out.println("Ingrese el nombre");
                        nombre=scan.next();
                        System.out.println("Sal? si/no");
                        String salsita=scan.next();
                        if(salsita.equalsIgnoreCase("si"))
                            sal=true;
                        else
                            sal=false;
                        Guarnicion guardian= new Guarnicion(precio,nombre,sal);
                        System.out.println("Esta es su guarnicion creada\n");
                        System.out.println(guardian.toString());
                        restaurant.getCartaComidas().agregarComida(guardian);
                        break;
                    case 0:
                        System.out.println("Regrasando al menu principal");
                        System.out.println("Precione enter para Continuar...");
                        new java.util.Scanner(System.in).nextLine();
                        break;
                    default:
                        System.out.println("Opción invalida");

                        MenuCombos(3,scan,restaurant);
                        break;

                }
                break;
            case 4:
            System.out.println("\033[33m"+"Elija una comida a Borrar"+"\u001B[0m");
            System.out.println("\033[35m"+"Elija una comida a "+"\033[31m"+"Eliminar"+"\u001B[0m"+ "\u001B[0m");
            System.out.println(restaurant.listarComidaConPosicion());
            pos=elegirOpcion(scan);
            try {
                if (pos > restaurant.getCartaComidas().getListaComida().getCantComidas()) {
                    throw new ComidaInexistenteException("La opcion ingresada no corresponde a ninguna comida");
                } else {
                    comida = restaurant.getCartaComidas().getComidaPos(pos);
                    System.out.println("Desea borra esta comida (SI/NO)");
                    System.out.println("\033[31m" + comida.toString() + "\u001B[0m");

                    confirmar = scan.next();
                    if (confirmar.equalsIgnoreCase("si")) {
                        restaurant.eliminarComida(comida);
                        System.out.println("\033[33m" + "Comida eliminada con exito" + "\u001B[0m");
                    }
                    else if(confirmar.equalsIgnoreCase("no"))
                    {
                        System.out.println("Volviendo al menu");
                        MenuPrincipal(scan,restaurant);
                    }
                    else{
                        System.out.println("Opcion erronea, volviendo al menu principal");
                        MenuPrincipal(scan,restaurant);
                    }
                }
            }
            catch (ComidaInexistenteException a)
            {
                boolean bandera=true;
                while(bandera== true)
                {
                    System.out.println(a.getMessage());
                    pos=elegirOpcion(scan);
                    if (pos <= restaurant.getCartaComidas().getListaComida().getCantComidas())
                    {
                        bandera=false;
                        comida = restaurant.getCartaComidas().getComidaPos(pos);
                        System.out.println("Desea borra esta comida (SI/NO)");
                        System.out.println("\033[31m" + comida.toString() + "\u001B[0m");

                        confirmar = scan.next();
                        if (confirmar.equalsIgnoreCase("si")) {
                            restaurant.eliminarComida(comida);
                            System.out.println("\033[33m" + "Comida eliminada con exito" + "\u001B[0m");
                        }
                        else if(confirmar.equalsIgnoreCase("no"))
                        {
                            System.out.println("Volviendo al menu");
                            MenuPrincipal(scan,restaurant);
                        }
                        else{
                            System.out.println("Opcion erronea, volviendo al menu principal");
                            MenuPrincipal(scan,restaurant);
                        }
                    }
                }
            }

            break;
            case 5:
                System.out.println("Desea cambiarle el precio a un ...");
                System.out.println("1-Combo");
                System.out.println("2-Comidas");
                System.out.println("0-Regresar menu principal");
                op=scan.nextInt();
                switch (op)
                {
                    case 1:
                        Combo nuevo;
                        System.out.println(restaurant.listarCombos());
                        System.out.println("Elija el numero del combo a cambiar");
                        op=elegirOpcion(scan);
                            nuevo = restaurant.getSetCombos().getComboPos(op);
                            if(nuevo==null)
                            {
                                System.out.println("Opcion erronea");
                                SetCombo listita= restaurant.getSetCombos();
                                while(op>listita.getCantidad() || op<0) {
                                    System.out.println("Ingrese un nuevo numero del combo a cambiar precio");
                                    op = elegirOpcion(scan);
                                }
                                nuevo= restaurant.getSetCombos().getComboPos(op);
                            }
                        System.out.println("Que precio desea ponerle?");
                        double preci=scan.nextDouble();
                        try {
                            restaurant.getSetCombos().actualizarPrecioCombo(nuevo,preci);
                        } catch (PrecioNegativoException e) {
                            System.out.println(e.getMessage());
                            while(preci<0) {
                                System.out.println("Ingrese un nuevo precio?");
                                preci = scan.nextDouble();
                            }
                            try {
                                nuevo.cambiarPrecio(preci);
                            } catch (PrecioNegativoException precioNegativoException) {
                                System.out.println(precioNegativoException.getMessage());
                            }
                        }
                        System.out.println(nuevo.getDatosCombo());
                        System.out.println("Desea seguir cambiando precios? si/ no");
                        String rta=scan.next();
                        if(rta.equalsIgnoreCase("si"))
                            MenuCombos(5,scan,restaurant);
                        else if (rta.equalsIgnoreCase("no")) {
                            System.out.println("Volviendo al menu principal");
                            MenuPrincipal(scan, restaurant);
                        }
                        else
                        {
                            System.out.println("Opcion erronea, volviendo al menu principal");
                            MenuPrincipal(scan,restaurant);
                        }
                        break;
                    case 2:
                        Comida cambiar;
                        System.out.println(restaurant.listarComidaConPosicion());
                        System.out.println("Ingrese el numero de la comida a cambiar precio");
                        op=elegirOpcion(scan);
                        try {
                             cambiar = restaurant.getCartaComidas().getComidaPos(op);
                        }
                        catch(IndexOutOfBoundsException e)
                        {
                            System.out.println(e.getMessage());
                            System.out.println("Opcion erronea");
                            ListaComidas lista=restaurant.getListaComidas();
                            while(op>=lista.getCantComidas() || op<0) {
                                System.out.println("Ingrese un nuevo numero de la comida a cambiar precio");
                                op = elegirOpcion(scan);

                            }
                            cambiar= restaurant.getCartaComidas().getComidaPos(op);
                        }
                        System.out.println("Ingrese el nuevo precio");
                        double precioo=scan.nextDouble();
                        try {
                            cambiar.cambiarPrecio(precioo);
                        } catch (PrecioNegativoException e) {
                            System.out.println(e.getMessage());
                            while(precioo<0) {
                                System.out.println("Ingrese un nuevo precio?");
                                precioo = scan.nextDouble();
                            }
                            try {
                                cambiar.cambiarPrecio(precioo);
                            } catch (PrecioNegativoException precioNegativoException) {
                                System.out.println(precioNegativoException.getMessage());
                            }
                        }
                        System.out.println(cambiar.toString());
                        System.out.println("Desea seguir cambiando precios? si/ no");
                        String rtaa=scan.next();
                        if(rtaa.equalsIgnoreCase("si"))
                            MenuCombos(5,scan,restaurant);
                        else if (rtaa.equalsIgnoreCase("no")) {
                            System.out.println("Volviendo al menu principal");
                            MenuPrincipal(scan, restaurant);
                        }
                        else
                        {
                            System.out.println("Opcion erronea, volviendo al menu principal");
                            MenuPrincipal(scan,restaurant);
                        }
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opción invalida");
                        MenuCombos(5,scan,restaurant);
                        break;
                }
                break;
            case 6:
                System.out.println(restaurant.listarCompleto());
                System.out.println("Precione enter para Continuar...");
                new java.util.Scanner(System.in).nextLine();
                break;
            case 0:
                break;
            default:
                System.out.println("Opción invalida");
                op = elegirOpcion(scan);
                MenuCombos(op,scan,restaurant);
                break;
        }
        MenuPrincipal(scan,restaurant);
    }
}
