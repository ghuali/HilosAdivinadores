package hilosadivinadores;
import java.util.Random;

public class Adivinador extends Thread{
    private NumeroSecreto numeroOculto;
    private int id;

    // Constructor que recibe el objeto compartido NumeroOculto y el identificador del hilo.
    public Adivinador(NumeroSecreto numeroOculto, int id) {
        this.numeroOculto = numeroOculto;
        this.id = id;
    }

    // Adivinar un número aleatorio hasta que alguien acierte.
    @Override
    public void run() {
        Random rand = new Random();
        while (true) {
            int intento = rand.nextInt(101); // Número aleatorio entre 0 y 100.
            int resultado = numeroOculto.propuestaNumero(intento);

            if (resultado == -1) {
                System.out.println("Hilo " + id + ": El juego ya ha terminado");
                break; // Termina el hilo si el número ya fue adivinado por otro hilo.
            } else if (resultado == 1) {
                System.out.println("Hilo " + id + ": Adiviné el número era " + intento);
                break; // Termina el hilo si adivinó el número correcto.
            } else {
                System.out.println("Hilo " + id + ": Intento con " + intento + " incorrecto");
            }
        }
    }
}
