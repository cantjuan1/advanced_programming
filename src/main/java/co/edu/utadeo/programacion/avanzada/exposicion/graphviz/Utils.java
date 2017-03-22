/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utadeo.programacion.avanzada.exposicion.graphviz;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author usuario
 */
public class Utils {

    public static void writeFile(String fileName, String s) {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(fileName));
            out.println(s);
            out.close();
        }
        catch (IOException e1) {
            System.out.println("Error durante lectura o escritura del archivo");
        }
    }

    public static String execute(String command) {
        return executeCommand(command);
    }

    private static String executeCommand(String command) {
        StringBuilder output = new StringBuilder();
        Process p;
        try {
            // crear proceso externo
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            // esperar a que termine el proceso
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }
}
