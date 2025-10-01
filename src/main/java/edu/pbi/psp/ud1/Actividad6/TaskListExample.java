package edu.pbi.psp.ud1.Actividad6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class TaskListExample {
    public static void main(String[] args) {
        try (Scanner teclado = new Scanner(System.in)) {
            System.out.print("Ingrese el término de búsqueda: ");
            String busqueda = teclado.nextLine();
            String comando = "tasklist | findstr " + busqueda;
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", comando);
            Process process = pb.start();
            List<String> outputLines = getProcessOutputLines(process);
            outputLines.stream()
                    .filter(x -> x.toLowerCase().contains(busqueda))
                    .forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> getProcessOutputLines(Process process) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            return br.lines().toList();
        }
    }
}




