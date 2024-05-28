package digimon;

import java.util.Random;
import java.util.Scanner;

/**
 * Representa una batalla digital entre un Digimon del domador y un Digimon
 * salvaje.
 */
public class BatallaDigital {
	/** El Digimon enemigo en la batalla. */
	Digimon enemigo;

	/**
	 * Crea una nueva batalla digital con un Digimon salvaje aleatorio. Imprime un
	 * mensaje indicando que un Digimon salvaje ha aparecido.
	 */
	public BatallaDigital() {
		this.enemigo = generarDigimonAleatorio();
		System.out.println("¡Un " + enemigo.nombre + " salvaje ha aparecido!");
	}

	/**
	 * Genera un Digimon salvaje aleatorio para la batalla.
	 * 
	 * @return El Digimon salvaje generado aleatoriamente.
	 */
	private Digimon generarDigimonAleatorio() {
		String[] nombresDigimon = { "Agumon", "Gabumon", "Patamon" };
		String nombre = nombresDigimon[(int) (Math.random() * nombresDigimon.length)];
		return new Digimon(nombre);
	}

	/**
	 * Muestra al usuario los Digimon disponibles en su equipo, y permite elegir
	 * a uno de ellos
	 * 	 * @param domador El domador que elige el Digimon para la batalla.
	 * @return El Digimon elegido para la batalla.
	 */
	public Digimon elige(Domador domador) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Equipo disponible:");
			for (int i = 0; i < domador.equipo.size(); i++) {
				Digimon digimon = domador.equipo.get(i);
				System.out.println((i + 1) + ". " + digimon.nombre + " (Nivel " + digimon.nivel + ")");
				if (digimon.salud <= 0) {
					System.out.println("   --> ¡Está muerto!");
				}
			}
			System.out.print("Elige el Digimon para la batalla: ");
			int eleccion = scanner.nextInt() - 1;
			if (eleccion >= 0 && eleccion < domador.equipo.size()) {
				Digimon digimonElegido = domador.equipo.get(eleccion);
				if (digimonElegido.salud > 0) {
					return digimonElegido;
				} else {
					System.out.println("Este Digimon está muerto, elige otro.");
				}
			} else {
				System.out.println("Opción inválida.");
			}
		}
	}

	/**
	 * Realiza la pelea entre el Digimon del domador y el enemigo. Muestra el estado
	 * de la batalla y permite al usuario elegir entre diferentes acciones.
	 * 
	 * @param digimon El Digimon del domador que participa en la batalla.
	 * @param domador El domador que participa en la batalla.
	 */
	public void pelea(Digimon digimon, Domador domador) {
		Scanner scanner = new Scanner(System.in);
		while (enemigo.salud > 0 && digimon.salud > 0) {
			System.out.println("----- Estado de la Batalla -----");
			System.out.println("Vida del enemigo (" + enemigo.nombre + "): " + enemigo.salud);
			System.out.println("Vida de tu Digimon (" + digimon.nombre + "): " + digimon.salud);
			System.out.println("-------------------------------");
			System.out.println("1. Ataque1");
			System.out.println("2. Ataque2");
			System.out.println("3. Capturar");
			System.out.print("Elige tu acción: ");
			int eleccion = scanner.nextInt();

			switch (eleccion) {
			case 1:
				int dano1 = digimon.ataque1();
				enemigo.salud -= dano1;
				System.out.println(digimon.nombre + " usa Ataque1 y causa " + dano1 + " de daño.");
				break;
			case 2:
				int dano2 = digimon.ataque2();
				enemigo.salud -= dano2;
				System.out.println(digimon.nombre + " usa Ataque2 y causa " + dano2 + " de daño.");
				break;
			case 3:
				domador.captura(enemigo);
				return;
			default:
				System.out.println("Opción no válida");
			}

			if (enemigo.salud <= 0) {
				System.out.println("¡Has derrotado al " + enemigo.nombre + " salvaje!");
				return;
			}

			System.out.println("----- Turno del enemigo -----");
			int danoEnemigo = enemigo.ataque1();
			digimon.salud -= danoEnemigo;
			System.out.println(enemigo.nombre + " ataca y causa " + danoEnemigo + " de daño.");

			if (digimon.salud <= 0) {
				System.out.println("¡Tu " + digimon.nombre + " ha sido derrotado!");
				return;
			}
		}
	}
}
