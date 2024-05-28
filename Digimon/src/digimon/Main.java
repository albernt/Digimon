/**
 * @author AlbertoBernet
 */
package digimon;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// ASCII art
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
