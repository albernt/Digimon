package digimon;
import java.util.Random;

public class Digimon {
    String nombre;
    int nivel;
    int puntosAtaque;
    int salud;
    int dp1;
    int dp2;
/**
 * 
 * @param nombre
 */
    public Digimon(String nombre) {
        this.nombre = nombre;
        this.nivel = new Random().nextInt(5) + 1;
        this.puntosAtaque = 5 * nivel;
        this.salud = 10 * nivel;
        this.dp1 = 10;
        this.dp2 = 10;
    }

    public int ataque1() {
        if (dp1 > 0) {
            dp1 -= 1;
            return puntosAtaque;
        }
        return 0;
    }

    public int ataque2() {
        if (dp2 > 1) {
            dp2 -= 2;
            return puntosAtaque * 2;
        }
        return 0;
    }
}
