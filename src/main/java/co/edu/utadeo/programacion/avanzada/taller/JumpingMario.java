package co.edu.utadeo.programacion.avanzada.taller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * UVA Jumping Mario
 * @author Juan Cantor
 *
 */
public class JumpingMario {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("jumping_mario_data"));
		while (in.hasNextLine()) {
			Integer cases = Integer.parseInt(in.nextLine());
			for (int i = 0; i < cases; i++) {
				Integer countHighJumps = 0;
				Integer countLowJumps = 0;
				Integer walls = Integer.parseInt(in.nextLine());
				String wallsSizes[] = in.nextLine().split(" ");
				Integer currentWall = null;
				for (int j = 0; j < walls; j++) {
					if (currentWall != null) {
						if (currentWall < Integer.parseInt(wallsSizes[j])) {
							countHighJumps++;
						}
						if (currentWall > Integer.parseInt(wallsSizes[j])) {
							countLowJumps++;
						}
					}
					currentWall = Integer.parseInt(wallsSizes[j]);
				}
				System.out.println("Case " + (i + 1) + ": " + countHighJumps + " " + countLowJumps);
			}
		}
		in.close();
	}

}
