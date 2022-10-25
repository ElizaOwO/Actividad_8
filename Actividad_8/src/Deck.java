
//Importar librerias de la colección
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import java.util.Arrays;
import java.util.function.Function;

//Clase de la baraja
public class Deck {

    //Declarar variables globales
    static int contador = 0;
    static int contador2 = 2;
    static ArrayList<Card> array = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    //Método principal
    public static void main(String[] args) {

        //Inicializar las 52 cartas en la coleccción ArrayList
        for (int i = 0; i < 52; i++) {
            array.add(new Card(palo(),color(),valor()));
        }

        llamarMetodos();
    }

    //Método que despliega el menú
    //y retorna la opción ingresaday
    private static int showMenu(){
        int opcion;

        System.out.println("\n==================================================================================");
        System.out.println("                                  Bienvenido\uD83E\uDD1F");
        System.out.println("==================================================================================");
        System.out.println("\uD83C\uDF38Selecciona una opción: ");
        System.out.println("1.- \uD83D\uDD00Mezclar deck");
        System.out.println("2.- ➡Sacar una carta");
        System.out.println("3.- \uD83D\uDD02Carta al azar");
        System.out.println("4.- \uD83C\uDD95Generar una mano de 5 cartas");
        System.out.println("5.- \uD83D\uDC40Visualizar baraja");
        System.out.println("0.- \uD83D\uDEAASalir");

        opcion = sc.nextInt();

        try{
            int opcionIngresada []= {0,1,2,3,4,5};
            System.out.println("###Se ha seleccionado la opción: "+ opcionIngresada[opcion]);
        }catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("⚠️⚠️Ingresa una opción válida");
        }
        return opcion;
    }

    //Método que valida la opción
    //y llama a los métodos correspondientes
    private static void llamarMetodos(){
        boolean owo=true;

        while (owo) {
            int opcionValidar = showMenu();

            switch (opcionValidar) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-BARAJEAR-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    shuffle();
                    break;
                case 2:
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-Quitar primera carta-.-.-.-.-.-.-.-.-.-.-.-.-");
                    head();
                    break;
                case 3:
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-Quitar carta al azar-.-.-.-.-.-.-.-.-.-.-.-.-");
                    pick();
                    break;
                case 4:
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-Quitar cinco cartas-.-.-.-.-.-.-.-.-.-.-.-.-.");
                    imprimirArray(hand());
                    break;
                case 5:
                    System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-Ver baraja-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
                    imprimirArray(array);
                    break;
            }
        }
    }

    //Método que barajea
    private static void shuffle() {

        if(array.size()!=0) {
            Collections.shuffle(array);
            System.out.println("Se mezcló el Deck");
        }else{
            System.out.println("Ya no hay cartas");
        }
    }


    //Método que elimina la primera carta e imprime en pantalla
    //la cantidad de cartas actuales
    private static void head() {
        try {
            System.out.println(array.get(0));
            array.remove(0);
            System.out.println("Quedan " + array.size() + " cartas");
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Ya no hay cartas");
        }
    }

    //Método que elimina una carta al azar e imprime en pantalla
    //la cantidad de cartas actuales
    private static void pick() {
        try {
            Card carta = (Card) (array.get((int) (Math.random() * array.size())));
            System.out.println(carta);
            array.remove(carta);
            System.out.println("Quedan " + array.size() + " cartas");
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Ya no hay cartas");
        }
    }

    //Método que elimina 5 cartas y devuelve
    //un arreglo con dichas cartas
    private static ArrayList<Card> hand() {
        ArrayList<Card> cartas = new ArrayList<>();
        int i=0;
        try {
            while (i < 5) {
                cartas.add(array.get(0));
                array.remove(0);
                i++;
            }
        }catch (IndexOutOfBoundsException ex){
            System.out.println("Ya no hay cartas");
        }
        return cartas;
    }

    //Método que recibe un arreglo para
    //imprimirlo
    //private static void imprimirArray(ArrayList<String> arr) {
    private static void imprimirArray(ArrayList<Card> arr) {
        for (Object o : arr) {
            System.out.println(o);
        }
        System.out.println("Quedan " + array.size() + " cartas");
    }

    //Método que devuelve un string
    //del palo correspondiente
    private static String palo() {
        String palo = "";
        if (contador < 13) {
            palo = "♣ ";
        } else if (contador < 26) {
            palo = "♠ ";
        } else if (contador < 39) {
            palo = "❤ ";
        } else {
            palo = "♦ ";
        }
        return palo;
    }

    //Método que devuelve un string
    //del color correspondiente
    private static String color() {
        String color = "";
        if (contador < 26) {
            color = "⬛";
        } else {
            color = "\uD83D\uDFE5";
        }
        contador++;
        return color;
    }

    //Método que devuelve un string
    //del valor correspondiente
    private static String valor(){
        String valor=" 2";

        switch(contador2){
            case 11:
                valor= " A"; break;
            case 12:
                valor= " J"; break;
            case 13:
                valor= " K"; break;
            case 14:
                valor= " Q"; break;
            case 15:
                contador2=2; break;
            default:
                valor=( " " + contador2);
        }
        contador2++;
        return valor;
    }
}
