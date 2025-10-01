package edu.pbi.psp.ud1.Actividad7;

import java.io.IOException;

public class WorkingDirectory {
    static final ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "echo", "Hola");

    public static void main(String[] args) {
        try {
            pb.inheritIO();
            System.out.println("Comando inicial: " + pb.command());

            // TODO: Realizar las tareas propuestas

            pb.start().waitFor();

            System.out.println("Directorio de trabajo: " + pb.directory());
            System.out.println("Comando final ejecutado: " + pb.command());

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
