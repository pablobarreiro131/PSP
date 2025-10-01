package edu.pbi.psp.ud1.Actividad2;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class ProcessLifeCycle2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce la IP: ");
        String IP = teclado.nextLine();
        CompletableFuture<Long> proceso1 = ping(IP);
        CompletableFuture<Long> proceso2 = ping(IP);
        try {
            long duracion1 = proceso1.get();
            long duracion2 = proceso2.get();
            System.out.println("\n" + "Proceso 1: " + duracion1 + "\n" + "Proceso 2: " + duracion1);
        } catch (Exception e) {
            e.getMessage();
        }


    }

    public static CompletableFuture<Long> ping(String IP) {
        return CompletableFuture.supplyAsync(() -> {
            long inicio = System.currentTimeMillis();
            try {
                ProcessBuilder pb = new ProcessBuilder("ping", IP);
                Instant start = Instant.now();
                Process p = pb.start();
                System.out.println("Estado: EN EJECUCIÓN (RUNNING)");
                int exitCode = p.waitFor();
                Instant end = Instant.now();
                Long duracion = Duration.between(start, end).toMillis();
                return duracion;
            } catch (Exception e) {
                e.getMessage();
                return -1L;
            }
        });
    }
}
