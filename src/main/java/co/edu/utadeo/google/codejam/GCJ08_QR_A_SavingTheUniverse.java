package co.edu.utadeo.google.codejam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Google Code Jam 2008 - Qualification Round - Problem A Saving the Universe
 * 
 * @author juan.cantor
 *
 */
public class GCJ08_QR_A_SavingTheUniverse {

    public static void main(String[] args) throws IOException {
        String fileName = "08-QA-PA-large-practice.";
        Scanner in = new Scanner(new File(fileName + "in"));
        PrintWriter out = new PrintWriter(new File(fileName + "out"));
        HashSet<String> enginesNames = new HashSet<String>();
        String querie;
        int engines = 0;
        int queries = 0;
        int switches = 0;
        int inputs = Integer.parseInt(in.nextLine());
        for (int i = 0; i < inputs; i++) {
            enginesNames.clear();
            switches = 0;
            engines = Integer.parseInt(in.nextLine());
            for (int e = 0; e < engines; e++) {
                in.nextLine();
            }
            queries = Integer.parseInt(in.nextLine());
            for (int q = 0; q < queries; q++) {
                querie = in.nextLine();
                enginesNames.add(querie);
                if (enginesNames.size() == engines) {
                    switches++;
                    enginesNames.clear();
                    enginesNames.add(querie);
                }
            }
            out.println("Case #" + (i + 1) + ": " + switches);
        }
        in.close();
        out.close();
    }

}
