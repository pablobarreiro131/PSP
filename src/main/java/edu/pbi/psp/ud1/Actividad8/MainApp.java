package edu.pbi.psp.ud1.Actividad8;

import java.io.*;

public class MainApp {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Lanzando Worker en un proceso independiente…");

        // Obtenemos el classpath actual del proyecto
        String classpath = System.getProperty("java.class.path");

        // Comando para iniciar la segunda JVM
        ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", classpath, "edu.pbi.psp.ud1.Actividad8.Worker"
        );

        Process proceso = pb.start();
        int exitCode = proceso.waitFor();
        System.out.println("Proceso finalizado con código: " + exitCode);
    }
}
