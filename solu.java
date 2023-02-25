import java.util.Scanner;
public class solu {
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
