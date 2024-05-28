package digimon;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Domador {
    String nombre;
    List<Digimon> equipo;
    List<Digimon> muertos;
/**
 * 
 * @param nombre
 */
    public Domador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
        this.muertos = new ArrayList<>();
        this.equipo.add(generarDigimonAleatorio());
    }

    private Digimon generarDigimonAleatorio() {
        String[] nombresDigimon = {"Agumon", "Gabumon", "Patamon"};
        String nombre = nombresDigimon[new Random().nextInt(nombresDigimon.length)];
        return new Digimon(nombre);
    }
/**
 * 
 * @param digimon
 */
    public void captura(Digimon digimon) {
        if (digimon.salud < 20 && equipo.size() < 3) {
            equipo.add(digimon);
            System.out.println(digimon.nombre + " se ha unido a su equipo");
        } else {
            System.out.println("No se puede unir");
        }
    }

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

    public List<Digimon> getMuertos() {
        return muertos;
    }
}
