
//Importar librerias de la colección
import java.util.ArrayList;
import java.util.*;

//Clase de la baraja
public class Deck {

    //Declarar variables globales
    static int contador = 0;
    static int contador2 = 2;
    static ArrayList<String> array = new ArrayList<>();

    //Método principal
    public static void main(String[] args) {

        //Declarar variable de tipo de la clase Card
        Card carta;

        //Inicializar las 52 cartas en la coleccción ArrayList
        for (int i = 0; i < 52; i++) {
            carta = new Card(palo(), color(), valor());
            array.add(carta.toString());
        }

        //Imprimir el ArrayList para visualizar todas las cartas
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-Baraja inicio-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
        imprimirArray(array);

        //llamar métodos e imprimir baraja
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-BARAJEAR-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.-");
        shuffle();
        imprimirArray(array);
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-Quitar primera carta-.-.-.-.-.-.-.-.-.-.-.-.-");
        head();
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-Quitar carta al azar-.-.-.-.-.-.-.-.-.-.-.-.-");
        pick();
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-Quitar cinco cartas-.-.-.-.-.-.-.-.-.-.-.-.-.");
        imprimirArray(hand());
        System.out.println("-.-.-.-.-.-.-.-.-.-.-.-.-.-.-.Baraja final-.-.-.-.-.-.-.-.-.-.-.-.-.-.");
        imprimirArray(array);
    }


    //Método que barajea
    public static void shuffle() {
        Collections.shuffle(array);
        System.out.println("Se mezcló el Deck");
    }

    //Método que elimina la primera carta e imprime en pantalla
    //la cantidad de cartas actuales
    public static void head() {
        System.out.println(array.get(0));
        array.remove(0);
        System.out.println("Quedan " + array.size() + " cartas");
    }

    //Método que elimina una carta al azar e imprime en pantalla
    //la cantidad de cartas actuales
    public static void pick() {
        String carta = array.get((int) (Math.random() * array.size()));
        System.out.println(carta);
        array.remove(carta);
        System.out.println("Quedan " + array.size() + " cartas");
    }

    //Método que elimina 5 cartas y devuelve
    //un arreglo con dichas cartas
    public static ArrayList<String> hand() {
        ArrayList<String> cartas = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            cartas.add(array.get(i));
            array.remove(i);
        }
        return cartas;
    }

    //Método que recibe un arreglo para
    //imprimirlo
    public static void imprimirArray(ArrayList<String> arr) {
        for (Object o : arr) {
            System.out.println(o);
        }
        System.out.println("Quedan " + array.size() + " cartas");
    }

    //Método que devuelve un string
    //del palo correspondiente
    public static String palo() {
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
    public static String color() {
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
    public static String valor(){
        String valor="";
        if(contador2==15){
            contador2=2;
        }
        if(contador2<11){
            valor=( " " + contador2);
        }else{
            switch(contador2){
                case 11:
                    valor= " A"; break;
                case 12:
                    valor= " J"; break;
                case 13:
                    valor= " K"; break;
                case 14:
                    valor= " Q"; break;
            }
        }
        contador2++;
        return valor;
    }
}
