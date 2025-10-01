package edu.pbi.psp.ud1.Actividad8;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Master {
    public static void main(String[] args) {
        try {
            System.out.println("Introduce números uno a uno (escribe 'fin' para terminar):");
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();

            while (true) {
                String input = sc.nextLine();
                if (input.equalsIgnoreCase("fin")) {
                    break;
                }
                try {
                    Integer.parseInt(input);
                    sb.append(input).append(",");
                } catch (NumberFormatException e) {
                    System.out.println("Introduce un número válido o 'fin' para terminar.");
                }
            }

            if (sb.length() == 0) {
                System.out.println("No se introdujeron números.");
                return;
            }
            sb.deleteCharAt(sb.length() - 1);

            String numerosConcatenados = sb.toString();

            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "-cp", classpath, "edu.pbi.psp.ud1.Actividad8.Subordinate", numerosConcatenados
            );
            pb.redirectErrorStream(true);
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String resultado = reader.readLine();

            proceso.waitFor();

            System.out.println("El número más alto es: " + resultado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
