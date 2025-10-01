package edu.pbi.psp.ud1.Actividad8;

public class Subordinate {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Esta vacio.");
            return;
        }

        String numerosConcatenados = args[0];

        String[] numeros = numerosConcatenados.split(",");

        int max = 0;
        boolean encontrado = false;

        for (String numStr : numeros) {
            try {
                int num = Integer.parseInt(numStr);
                if (num > max) {
                    max = num;
                }
                encontrado = true;
            } catch (NumberFormatException e) {
                System.err.println("Número inválido: " + numStr);
            }
        }

        if (encontrado) {
            System.out.println(max);
        } else {
            System.out.println("No se encontraron números válidos.");
        }
    }
}
