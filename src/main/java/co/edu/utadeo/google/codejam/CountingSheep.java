package co.edu.utadeo.google.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class CountingSheep {

    public String[] records;

    public CountingSheep() {
        records = new String[10];
    }

    public void addRecord(String value) {
        if (records[Integer.parseInt(value)] == null) {
            records[Integer.parseInt(value)] = value;
        }
    }

    public boolean isFull() {
        for (String record : records) {
            if (record == null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String test = "A-large-practice";
        Scanner in = new Scanner(new File(test + ".in"));
        OutputStream out = new FileOutputStream(test + ".out");
        Integer cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            int n = in.nextInt();
            int m = 1;
            CountingSheep cs = new CountingSheep();
            while (!cs.isFull() && n > 0) {
                if (n > 0) {
                    String numbers[] = String.valueOf(m * n).split("");
                    for (String number : numbers) {
                        cs.addRecord(number);
                    }
                    m++;
                }
            }
            out.write(("Case #" + i + ": " + (n > 0 ? (m - 1) * n : "INSOMNIA")
                    + "\n").getBytes());
        }
        in.close();
        out.close();
    }

}
