//Clase de las cartas
public class Card {

    //Declarar variables locales
    public String palo, color, valor;

    //Constructor de carta
    public Card(String palo, String color, String valor){
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }

    //Sobreescritura para converisón de string
    @Override
    public String toString(){
        return palo+ " "+ color + " "+ valor + " ";
    }
}
