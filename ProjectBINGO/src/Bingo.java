import java.util.ArrayList;
import java.util.Arrays;

public class Bingo {
    public static void main (String [] args){

        int [] carton = creaCarton();


        System.out.println("Introduce tu apuesta (€):");
        double apuesta = Insert.real();
        
        System.out.println("En cuantas tiradas crees que saldrá el BINGO?");
        int guess = Insert.entero();

        int[] lineaBingo = ruedaBingo(carton);
        int linea = lineaBingo[0];
        int bingo = lineaBingo[1];
        System.out.printf("Ha salido Línea en %d tiradas y Bingo en %d tiradas",linea,bingo);


        if (guess == bingo) {
            System.out.printf("¡Enhorabuena! ¡Has acertado la apuesta!Habías dicho Bingo en %d tiradas",guess);
            System.out.printf("¡Habías apostado %f € y has obtenido %f!",apuesta,apuesta*10);
        }
        else {
            System.out.printf("¡Que pena! Habias dicho %d tiradas y han sido %d!. ¡Más suerte la próxima!",guess,bingo);
        }

    }

    // Metodo para crear el carton, un array de 10 numeros en [1,99]
    public static int[] creaCarton () {
        int[] carton = new int[10];
        final int min = 1;
        final int max = 99;
        ArrayList<Integer> numBloqueados = new ArrayList<>();

        for (int i=0; i < carton.length; i++) {
            int placeholder;
            do {
                placeholder = randomNum(min,max);
            } while (numBloqueados.contains(placeholder));

            carton [i]= placeholder;
            numBloqueados.add(placeholder);
        }
        return carton;
    }

    // Metodo del "Bingo". Hay que darle un array de int que será el cartón
    public static int[] ruedaBingo (int[] carton) {
        final int min = 1;
        final int max = 99;
        int linea = 0;
        int bingo = 0;
        int cuentaBingo = 0;

        //Aquí guarda los números que han salido
        ArrayList<Integer> numSalidos = new ArrayList<>();

        //Convierte el array que es el cartón en una lista para poder trabajar
        ArrayList<Integer> listaCarton = new ArrayList<>();
        for (int j : carton) {
            listaCarton.add(j);
        }


        for (int i=0;i < 99; i++){
            int numBola = i+1;
            int placeholder;

            // Genera el número aleatorio, si está en la lista de numeros que han salido, vuelve a generar otro
            do {
                placeholder = randomNum(min,max);
            } while (numSalidos.contains(placeholder));

            //Guarda el número que ha salido en la lista de números que han salido.
            numSalidos.add(placeholder);

            // Si el número que ha salido está en la lista cartón, suma uno al contador.
            // Cuando el contador llega a 5, guarda el número de la "linea"
            // Cuando el número llega a 10, guarda el numero y para todo.

            if (listaCarton.contains(placeholder)) {
                cuentaBingo++;
                if (cuentaBingo == 5){
                    linea = numBola;
                }
                else if (cuentaBingo == 10){
                    bingo = numBola;
                    break;
                }
            }
        }
        // Devuelve línea y bingo, que son el número de tiradas que han hecho falta para que salgan 5 y 10 números.
        return new int[]{linea,bingo};
    }

    // Metodo para generar un número aleatorio en un ranto min-max
    public static int randomNum (int min,int max){
        int numeroRandom = (int) (Math.random() * (max - min + 1)+min);
        return numeroRandom;
    }
}
