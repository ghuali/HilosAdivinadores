package hilosadivinadores;
import java.util.Random;

public class NumeroSecreto {
    private int numeroSecreto;
    private boolean adivinado = false; // Para saber si ya fue adivinado

   
    public NumeroSecreto() {
        Random rand = new Random();
        this.numeroSecreto = rand.nextInt(101); // Genera número aleatorio entre 0 y 100.
        System.out.println("El número oculto ha sido generado.");
    }

    // Método sincronizado para que los hilos propongan números.
    public synchronized int propuestaNumero(int num) {
        if (adivinado) {
            return -1; // El juego ya ha terminado.
        }
        if (num == numeroSecreto) {
            adivinado = true; // Alguien ha adivinado el número.
            return 1; // Número correcto.
        }
        return 0; // Número incorrecto.
    }
}

