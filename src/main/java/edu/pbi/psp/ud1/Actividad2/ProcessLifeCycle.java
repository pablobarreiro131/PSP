package edu.pbi.psp.ud1.Actividad2;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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
            //pb.redirectOutput(salida);
            //pb.redirectError(error);
            pb.inheritIO(); //redirige la salida a la consola.
                    // el comando hace N pings -> dura unos segundos

                    // READY: proceso creado pero aún no iniciado
                    System.out.println("Estado: LISTO (READY)");

            // RUNNING: arrancamos
            Instant start = Instant.now();
            Process p = pb.start();
            System.out.println("Estado: EN EJECUCIÓN (RUNNING)");
            //if(!p.waitFor(2, TimeUnit.SECONDS)){
            //    p.destroyForcibly();
            //    System.out.println("Proceso parado.");
            //}
            // Esperamos a que termine (el ping tarda unos segundos)
            int exitCode = p.waitFor();
            Instant end =Instant.now();
            Long duracion = Duration.between(start,end).toMillis();
            // FINISHED: terminó su trabajo
            System.out.println("Estado: FINALIZADO (TERMINATED), código de salida: " + exitCode + "\nDuración: " + duracion + " ms");
            Instant start1 = Instant.now();
            Process p1 = pb.start();
            System.out.println("Estado: EN EJECUCIÓN (RUNNING)");
            //if(!p.waitFor(2, TimeUnit.SECONDS)){
            //    p.destroyForcibly();
            //    System.out.println("Proceso parado.");
            //}
            // Esperamos a que termine (el ping tarda unos segundos)
            int exitCode1 = p1.waitFor();
            Instant end1 =Instant.now();
            Long duracion1 = Duration.between(start1,end1).toMillis();
            // FINISHED: terminó su trabajo
            System.out.println("Estado: FINALIZADO (TERMINATED), código de salida: " + exitCode1 + "\nDuración: " + duracion1 + " ms");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
