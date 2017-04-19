package co.edu.utadeo.programacion.avanzada;

import java.util.Scanner;

public class HorseMovement {

	private Integer board[][];

	public HorseMovement(Integer boardSize) {
		board = new Integer[boardSize][boardSize];
		board[3][4] = -1;
	}

	public void movement(Integer positionX, Integer positionY, Integer movement) {
		while (!isFull()) {
			System.out.print("paso : " + movement + " ");
			if (isEmptySpace(positionX - 2, positionY + 1)) {
				positionX -= 2;
				positionY++;
				board[positionX][positionY] = movement++;
			} else {
				if (isEmptySpace(positionX - 1, positionY + 2)) {
					positionX--;
					positionY += 2;
					board[positionX][positionY] = movement++;
				} else {
					if (isEmptySpace(positionX + 1, positionY + 2)) {
						positionX++;
						positionY += 2;
						board[positionX][positionY] = movement++;
					} else {
						if (isEmptySpace(positionX + 2, positionY + 1)) {
							positionX += 2;
							positionY++;
							board[positionX][positionY] = movement++;
						} else {
							if (isEmptySpace(positionX + 2, positionY - 1)) {
								positionX += 2;
								positionY--;
								board[positionX][positionY] = movement++;
							} else {
								if (isEmptySpace(positionX + 1, positionY - 2)) {
									positionX++;
									positionY -= 2;
									board[positionX][positionY] = movement++;
								} else {
									if (isEmptySpace(positionX - 1, positionY - 2)) {
										positionX--;
										positionY -= 2;
										board[positionX][positionY] = movement++;
									} else {
										if (isEmptySpace(positionX - 1, positionY - 2)) {
											positionX--;
											positionY -= 2;
											board[positionX][positionY] = movement++;
										} else {
											break;
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println(positionX + "|" + positionY);
			print();

		}
		print();
	}

	public boolean isEmptySpace(Integer positionX, Integer positionY) {
		return positionX >= 0 && positionY >= 0 && positionX < board.length && positionY < board.length
				? board[positionX][positionY] == null || board[positionX][positionY] == 0 : false;
	}

	public boolean isFull() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == null || board[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void print() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.printf("\t" + board[i][j] + "|");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Tamaño de tablero: ");
		Integer boardSize = in.nextInt();
		HorseMovement horseMovement = new HorseMovement(boardSize);
		horseMovement.movement(3, 4, 1);
		in.close();
	}

}
