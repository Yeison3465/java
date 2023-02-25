import java.util.ArrayList;
import java.util.Scanner;

public class Texto {

    private String texto;
    private ArrayList<String> palabras;
    private ArrayList<Character> letras;
    private ArrayList<Character> numeros;
    private ArrayList<Character> caracteresEspeciales;

    public Texto(String texto) {
        this.texto = texto;
        palabras = new ArrayList<>();
        letras = new ArrayList<>();
        numeros = new ArrayList<>();
        caracteresEspeciales = new ArrayList<>();
    }

    public void separarPalabras() {
        String[] palabrasArray = texto.split("\\W+");
        for (String palabra : palabrasArray) {
            palabras.add(palabra);
        }
    }

    public void contarCaracteres() {
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                letras.add(caracter);
            } else if (Character.isDigit(caracter)) {
                numeros.add(caracter);
            } else {
                caracteresEspeciales.add(caracter);
            }
        }
    }

    public void mostrarInfo() {
        System.out.println("El texto introducido es: " + texto);
        System.out.println("Número de palabras: " + palabras.size());
        System.out.println("Número de letras: " + letras.size());
        System.out.println("Número de números: " + numeros.size());
        System.out.println("Número de caracteres especiales: " + caracteresEspeciales.size());
        System.out.println("Posiciones de las letras: " + obtenerPosiciones(letras));
        System.out.println("Posiciones de los números: " + obtenerPosiciones(numeros));
        System.out.println("Posiciones de los caracteres especiales: " + obtenerPosiciones(caracteresEspeciales));
    }

    private ArrayList<Integer> obtenerPosiciones(ArrayList<Character> lista) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        for (int i = 0; i < texto.length(); i++) {
            if (lista.contains(texto.charAt(i))) {
                posiciones.add(i);
            }
        }
        return posiciones;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un texto: ");
        String texto = scanner.nextLine();
        Texto t = new Texto(texto);
        t.separarPalabras();
        t.contarCaracteres();
        t.mostrarInfo();
        scanner.close();
    }
}
