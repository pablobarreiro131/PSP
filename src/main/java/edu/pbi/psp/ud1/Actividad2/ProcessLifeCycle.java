package edu.pbi.psp.ud1.Actividad2;

import java.io.*;
import java.util.Scanner;

public class ProcessLifeCycle {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            // NEW: construimos el proceso
            String IP = teclado.nextLine();
            File salida = new File("C:\\Users\\pablo.barreiroiglesi\\IdeaProjects\\PSP\\src\\main\\java\\edu\\pbi\\psp\\ud1\\Actividad2\\ping_output.txt");
            File error = new File("C:\\Users\\pablo.barreiroiglesi\\IdeaProjects\\PSP\\src\\main\\java\\edu\\pbi\\psp\\ud1\\Actividad2\\ping_error_output.txt");
            System.out.println("Estado: NUEVO (NEW)");
            ProcessBuilder pb = new ProcessBuilder("ping", IP);
            pb.redirectOutput(salida);
            pb.redirectError(error);
                    // el comando hace N pings -> dura unos segundos

                    // READY: proceso creado pero aún no iniciado
                    System.out.println("Estado: LISTO (READY)");

            // RUNNING: arrancamos
            Process p = pb.start();
            System.out.println("Estado: EN EJECUCIÓN (RUNNING)");

            // Esperamos a que termine (el ping tarda unos segundos)
            int exitCode = p.waitFor();

            // FINISHED: terminó su trabajo
            System.out.println("Estado: FINALIZADO (TERMINATED), código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
