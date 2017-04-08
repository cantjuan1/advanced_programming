package co.edu.utadeo.google.codejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;

public class OversizedPancakeFlipper {

    public static void main(String[] args) throws IOException {
        String test = "A-small-practice";
        Scanner in = new Scanner(new File(test + ".in"));
        OutputStream out = new FileOutputStream(test + ".out");
        Integer cases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= cases; ++i) {
            String data[] = in.nextLine().split(" ");
            String pancakes = data[0];
            String pancakesOrginal = data[0];
            Integer flips = Integer.parseInt(data[1]);
            Integer count = 0;
            int indexUp = 0;
            int indexDown = pancakes.length();
            while (true) {
                if (pancakes.contains("-")) {
                    String flip = pancakes.substring(indexUp, indexUp + flips);
                    System.out.println("up:" + flip);
                    if (flip.contains("-")) {
                        flip = flip.replace("-", "x");
                        flip = flip.replace("+", "-");
                        flip = flip.replace("x", "+");
                        pancakes = flip + pancakes.substring(indexUp + flips,
                                pancakes.length());
                        System.out.println(pancakes);
                        indexUp++;
                        count++;
                    }
                    flip = pancakes.substring(indexDown - flips, indexDown);
                    System.out.println("down:" + flip);
                    if (flip.contains("-")) {
                        flip = flip.replace("-", "x");
                        flip = flip.replace("+", "-");
                        flip = flip.replace("x", "+");
                        pancakes = pancakes.substring(0, indexDown - flips)
                                + flip;
                        System.out.println(pancakes);
                        indexDown--;
                        count++;
                    }
                    if (pancakes == pancakesOrginal
                            || indexUp >= pancakes.length()) {
                        count = -1;
                        break;
                    }
                    System.out.println("Line" + pancakes);
                }
                else {
                    break;
                }
            }
            out.write(("Case #" + i + ": "
                    + (count == -1 ? "IMMPOSIBLE" : count) + "\n").getBytes());
        }
        in.close();
        out.close();
    }

}
