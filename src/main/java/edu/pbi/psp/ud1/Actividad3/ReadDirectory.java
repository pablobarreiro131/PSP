package edu.pbi.psp.ud1.Actividad3;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ReadDirectory {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el directorio que quieres leer: ");
        String directorio = sc.nextLine();
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","dir", directorio);
        Process p = pb.start();
        int exitCode = p.waitFor();
    }
}
