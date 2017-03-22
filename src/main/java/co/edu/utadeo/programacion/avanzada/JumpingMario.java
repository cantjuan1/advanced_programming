package co.edu.utadeo.programacion.avanzada;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class JumpingMario {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("jumping_mario_data"));
        Integer cases = 0;
        Integer caseI = 1;
        while (scanner.hasNextLine()) {
            if (cases == 0) {
                cases = Integer.parseInt(scanner.nextLine());
            }
            else {
                Integer walls = Integer.parseInt(scanner.nextLine());
                String wallsSizes = scanner.nextLine();
                Integer countHighJumps = 0;
                Integer countLowJumps = 0;
                String wallsA[] = wallsSizes.split(" ");
                Integer currentWall = null;
                for (String wallSize : wallsA) {
                    if (currentWall != null) {
                        if (currentWall < Integer.parseInt(wallSize)) {
                            countHighJumps++;
                        }
                        if (currentWall > Integer.parseInt(wallSize)) {
                            countLowJumps++;
                        }
                    }
                    currentWall = Integer.parseInt(wallSize);
                }
                System.out.println("Case " + caseI + " " + countHighJumps + " "
                        + countLowJumps);
                caseI++;
            }
        }
        scanner.close();
    }

}
