import java.io.*;

public class Insert {
    static String inicializar(){
        String buzon="";
        InputStreamReader flujo=new InputStreamReader(System.in);
        BufferedReader teclado=new BufferedReader(flujo);
        try {
            buzon = teclado.readLine();
        }
        catch(Exception e){
            System.out.print("Entrada incorrecta");
        }
        return buzon;
    }

    // Metodo para entrar int
    static int entero(){
        int valor = 0;
        boolean entradaValida = false;
        while (!entradaValida){
            try{
                valor = Integer.parseInt(inicializar());
                entradaValida = true;
            }
            catch (NumberFormatException e) {
                System.out.print("Entrada no válida.\nIntroduzca un número entero:");
            }
        }
        return valor;
    }

    // Metodo para entrar double
    static double real(){
        double valor = 0.0;
        boolean entradaValida = false;
        while (!entradaValida){
            try{
                valor = Double.parseDouble(inicializar());
                entradaValida = true;
            }
            catch (NumberFormatException e) {
                System.out.print("Entrada no válida.\nIntroduzca un número:");
            }
        }
        return valor;
    }

    // Metodo para entrar texto
    static String texto(){
        String valor=inicializar();
        return valor;
    }

    // Metodo para entrear char
    static char caracter(){
        String valor=inicializar();
        return valor.charAt(0);
    }
}
