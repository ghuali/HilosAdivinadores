package hilosadivinadores;

public class HilosAdivinadores {

    public static void main(String[] args) {
        NumeroSecreto numeroSecreto = new NumeroSecreto();

        // Crear y ejecutar los 10 hilos adivinadores.
        for (int i = 1; i <= 10; i++) {
            new Adivinador(numeroSecreto, i).start();
        }
    }
    
}
