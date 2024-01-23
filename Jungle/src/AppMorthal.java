import java.util.Scanner;
public abstract class AppMorthal {

    public static void main(String[] args) {
        String orange = "\u001B[38;2;255;165;0m", reset = "\u001B[0m", green = "\033[32m", red = "\033[31m";
        Scanner sc = new Scanner(System.in);
        int numOpc = 0, numOpcTipoAnimal = 0, numSeleccTipoAnimal = 0, seleccionAnimal = 0;
        boolean agua = true, buenClima = true;
        //Crear los animales y las plantas que se van a utilizar en el programa
        System.out.println(orange + "BIENVENIDO A MORTAL" + reset);

        boolean bandera = true;
        
        while (bandera == true) {
            System.out.println("Ingrese la opcion que desee realizar: ");
            System.out.println("1. Crear un animal (@ _ @) ");
            System.out.println("2. Alimentar a un animal (^ __ ^)");
            System.out.println("3. Eliminar a todos los animales (+ __ +)");
            System.out.println("4. Mostrar Animales existentes");
            System.out.println("5. Salir");
            numOpc = sc.nextInt();
            switch (numOpc) {
                case 1:// Crear Animal
                    opcionTipoAnimal();
                    numOpcTipoAnimal = sc.nextInt();
                    //Control por si se ingresa mal una opcion en el tipo de animal que se escoja
                    while (opcionAnimales(numOpcTipoAnimal)==true) {
                        opcionTipoAnimal();
                        numSeleccTipoAnimal = sc.nextInt();
                    }
                    //Seleccionar animal
                    seleccionAnimal = sc.nextInt();
                    generarAnimal(numSeleccTipoAnimal,seleccionAnimal);
                    break;
            
                case 2: // Alimentar animales
                    opcionTipoAnimal();
                    numOpcTipoAnimal = sc.nextInt();

                    while (opcionAnimales(numSeleccTipoAnimal)==true) {
                        opcionTipoAnimal();
                        numSeleccTipoAnimal = sc.nextInt();
                    }
                    
                    break;

                case 3: // Eliminar animales
                    agua = false;
                    buenClima = false;
                    condicionesVidaAnimal(agua, buenClima);
                    break;

                case 4:
                    break;

                case 5:// Salir
                    System.out.println(orange + "Gracias por jugar..." + reset);
                    bandera = false;
                    break;

                default:
                System.out.println(red + "Por favor ingrese una opcion valida :("+reset);
                bandera = true;
                    break;
            }
            
        }

        sc.close();

    }

    private static void generarAnimal(int numSeleccTipoAnimal, int seleccionAnimal) {
        if ((numSeleccTipoAnimal ^ seleccionAnimal)==1) {
            Rana rana = new Rana();
        } else if(numSeleccTipoAnimal==1 && seleccionAnimal ==2) {
            Sapo sapo = new Sapo();
        } else if(numSeleccTipoAnimal==2 && seleccionAnimal ==1) {
            CorreCamino ccamino = new CorreCamino();
        } else if(numSeleccTipoAnimal==2 && seleccionAnimal ==2) {
            Pato pato = new Pato();
        } else if(numSeleccTipoAnimal==3 && seleccionAnimal ==1) {
            Leon leon = new Leon();
        } else if(numSeleccTipoAnimal==3 && seleccionAnimal ==2) {
            Tigre tigre = new Tigre();
        } else if(numSeleccTipoAnimal==4 && seleccionAnimal ==1) {
            Payaso pezPayaso = new Payaso();
        } else if(numSeleccTipoAnimal==4 && seleccionAnimal ==2) {
            Tiburon tiburon = new Tiburon();
        } else if(numSeleccTipoAnimal==5 && seleccionAnimal ==1) {
            Cocodrilo cocodrilo = new Cocodrilo();
        } else if(numSeleccTipoAnimal==5 && seleccionAnimal ==2) {
            Serpiente serpiente = new Serpiente();
        }
    }

    /**
     * Este metodo sirve para indicar el tipo de animal que se puede crear en base a los
     * deseos del usuario
     * @param numOpcTipoAnimal
     * @return boolean
     */
    private static boolean opcionAnimales(int numOpcTipoAnimal) {
        String red = "\033[31m", reset = "\u001B[0m" ;
        boolean bandera3 = true;
        System.out.println("Escoja el animal que desee: ");
            if (numOpcTipoAnimal == 1 ) {
                System.out.println("1. Rana \n2. Sapo");
                return bandera3 = false;
            } else if(numOpcTipoAnimal ==2){
                System.out.println("1. Corre Caminos \n2. Pato");
                return bandera3 = false;
            } else if(numOpcTipoAnimal ==3){
                System.out.println("1. Leon \n2. Tigre");
                return bandera3 = false;
            } else if(numOpcTipoAnimal ==4){
                System.out.println("1. Pez Payaso \n2. Tiburon");
                return bandera3 = false;
            } else if(numOpcTipoAnimal ==5){
                System.out.println("1. Cocodrilo \n2. Serpiente");
                return bandera3 = false;
            }else{
                System.out.println(red+"Error en el numero de animal, intentelo de nuevo" + reset);
                return bandera3=true;
            }
        
    }

    /**
     * Este metodo presenta las opciones de los tipos de animales existentes
     * Anfibios, mamiferos, peces, reptiles
     */
    private static void opcionTipoAnimal() {
        System.out.println("Selecciona que grupo de animal quieres modificar");
        System.out.println("1. Anfibios");
        System.out.println("2. Aves");
        System.out.println("3. Mamiferos");
        System.out.println("4. Peces");
        System.out.println("5. Reptiles");
    }

    /**
     * Este metodo sirve para determinar si existira vida en Morthal
     * @param agua
     * @param buenClima
     * @return boolean
     */
    public static boolean condicionesVidaAnimal(boolean agua, boolean buenClima) {
        if ((buenClima && agua) == true) {
            return true; // Existe vida
        } else {
            return false;
        }
    }

}
