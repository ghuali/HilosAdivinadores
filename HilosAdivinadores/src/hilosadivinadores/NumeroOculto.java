package hilosadivinadores;
import java.util.Random;

public class NumeroOculto {
    private int numeroOculto;
    private boolean adivinado = false; // Para saber si ya fue adivinado

   
    public NumeroOculto() {
        Random rand = new Random();
        this.numeroOculto = rand.nextInt(101); // Genera número aleatorio entre 0 y 100.
        System.out.println("El número oculto ha sido generado.");
    }

    // Método sincronizado para que los hilos propongan números.
    public synchronized int propuestaNumero(int num) {
        if (adivinado) {
            return -1; // El juego ya ha terminado.
        }
        if (num == numeroOculto) {
            adivinado = true; // Alguien ha adivinado el número.
            return 1; // Número correcto.
        }
        return 0; // Número incorrecto.
    }
}
