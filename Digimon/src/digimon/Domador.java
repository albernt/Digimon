package digimon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase Domador
 */
public class Domador {
	/** El nombre del domador. */
	String nombre;
	/** ArrayList para el equipo del usuario */
	List<Digimon> equipo;
	/** ArrayList para los digimon muertos del usuario */
	List<Digimon> muertos;

	/**
	 * Constructor Domador. Inicializa el equipo del domador
	 * con un Digimon aleatorio.
	 * 
	 * @param nombre El nombre del domador.
	 */
	public Domador(String nombre) {
		this.nombre = nombre;
		this.equipo = new ArrayList<>();
		this.muertos = new ArrayList<>();
		this.equipo.add(generarDigimonAleatorio());
	}

	/**
	 * Genera un Digimon aleatorio.
	 * 
	 * @return El Digimon generado aleatoriamente.
	 */
	private Digimon generarDigimonAleatorio() {
		String[] nombresDigimon = { "Agumon", "Gabumon", "Patamon" };
		String nombre = nombresDigimon[new Random().nextInt(nombresDigimon.length)];
		return new Digimon(nombre);
	}

	/**
	 * Intenta capturar un Digimon y agregarlo al equipo del domador. Solo se puede
	 * capturar un Digimon si su salud es menor que 20 y el equipo del domador tiene
	 * menos de 3 Digimon.
	 * 
	 * @param digimon El Digimon que se intenta capturar.
	 */
	public void captura(Digimon digimon) {
		if (digimon.salud < 20 && equipo.size() < 3) {
			equipo.add(digimon);
			System.out.println(digimon.nombre + " se ha unido a su equipo");
		} else {
			System.out.println("No se puede unir");
		}
	}

	/**
	 * Verifica si al menos un Digimon del equipo del domador está vivo. Si un
	 * Digimon está muerto, lo agrega a la lista de Digimon muertos del domador.
	 * 
	 * @return true si al menos un Digimon del equipo está vivo, false de lo
	 *         contrario.
	 */
	public boolean estaVivo() {
		for (Digimon digimon : equipo) {
			if (digimon.salud > 0) {
				return true;
			} else {
				muertos.add(digimon);
			}
		}
		return false;
	}

	/**
	 * Obtiene la lista de Digimon muertos del domador.
	 * 
	 * @return La lista de Digimon muertos del domador.
	 */
	public List<Digimon> getMuertos() {
		return muertos;
	}
}
