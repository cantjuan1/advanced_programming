package co.edu.utadeo.google.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class RevengeOfThePancakes {

    public static void main(String[] args) throws IOException {
        String test = "B-small-practice";
        Scanner in = new Scanner(new File(test + ".in"));
        OutputStream out = new FileOutputStream(test + ".out");
        Integer cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            String n = in.next();
            //String pancakes[] = n.split("");
            out.write(("Case #" + i + ": " + n + "\n").getBytes());
        }
        in.close();
        out.close();
    }
}
