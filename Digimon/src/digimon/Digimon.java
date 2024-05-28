package digimon;

import java.util.Random;

/**
 * Clase Digimon
 */
public class Digimon {
	/** El nombre del Digimon. */
	String nombre;
	/** El nivel del Digimon. */
	int nivel;
	/** Los puntos de ataque del Digimon. */
	int puntosAtaque;
	/** La salud del Digimon. */
	int salud;
	/** Los puntos de ataque disponibles para el Ataque1. */
	int dp1;
	/** Los puntos de ataque disponibles para el Ataque2. */
	int dp2;

	/**
	 * Constructor
	 * 
	 * @param nombre El nombre del Digimon.
	 */
	public Digimon(String nombre) {
		this.nombre = nombre;
		this.nivel = new Random().nextInt(5) + 1;
		this.puntosAtaque = 5 * nivel;
		this.salud = 10 * nivel;
		this.dp1 = 10;
		this.dp2 = 10;
	}

	/**
	 * Realiza el Ataque1 del Digimon.
	 * 
	 * @return El daño infligido por el Ataque1, o 0 si no hay puntos de ataque
	 *         disponibles.
	 */
	public int ataque1() {
		if (dp1 > 0) {
			dp1 -= 1;
			return puntosAtaque;
		}
		return 0;
	}

	/**
	 * Realiza el Ataque2 del Digimon.
	 * 
	 * @return El daño infligido por el Ataque2, o 0 si no hay puntos de ataque
	 *         disponibles.
	 */
	public int ataque2() {
		if (dp2 > 1) {
			dp2 -= 2;
			return puntosAtaque * 2;
		}
		return 0;
	}
}
