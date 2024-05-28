/**
 * Clase principal que inicia el juego Digimon.
 * Permite al jugador ingresar su nombre, crear un Domador y participar en batallas digitales contra Digimon salvajes.
 * El juego termina cuando el equipo del Domador es derrotado o el jugador decide no continuar la aventura.
 * @author Alberto
 */
package digimon;

import java.util.Scanner;
/**
 * Clase Principal con el metodo main
 */
public class Main {
    /**
     * Constructor predeterminado de la clase Main.
     * Se utiliza para iniciar el juego Digimon.
     */
    public Main() {
        // Este constructor no realiza ninguna operación en particular.
    }

    /**
     * Método principal que inicia el juego Digimon.
     * @param args Los argumentos de la línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {

        String asciiArt = ",------.  ,--. ,----.   ,--.,--.   ,--. ,-----. ,--.  ,--. \n"
                + "|  .-.  \\ |  |'  .-./   |  ||   `.'   |'  .-.  '|  ,'.|  | \n"
                + "|  |  \\  :|  ||  | .---.|  ||  |'.'|  ||  | |  ||  |' '  | \n"
                + "|  '--'  /|  ||  '--'  ||  ||  |   |  |'  '-'  '|  | `   | \n"
                + "`-------' `--'`------' `--'`--'   `--' `-----' `--'  `--' ";

        System.out.println(asciiArt);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombreDomador = scanner.nextLine();
        Domador domador = new Domador(nombreDomador);

        while (domador.estaVivo()) {
            BatallaDigital batalla = new BatallaDigital();
            Digimon digimonElegido = batalla.elige(domador);
            batalla.pelea(digimonElegido, domador);

            if (!domador.estaVivo()) {
                System.out.println("¡Tu equipo está derrotado!");
                for (Digimon digimon : domador.getMuertos()) {
                    System.out.println(digimon.nombre + " está muerto.");
                }
                break;
            }

            System.out.print("¿Quieres continuar la aventura? (s/n): ");
            String continuar = scanner.next();
            if (!continuar.equalsIgnoreCase("s")) {
                break;
            }
        }
        System.out.println("¡Fin de la aventura!");
    }
}
