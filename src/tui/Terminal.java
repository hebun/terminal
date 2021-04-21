package tui;

import java.awt.Rectangle;

public class Terminal {

	public static boolean IS_TERMINAL = false;

	class ConsoleChar {
		public ConsoleChar(int i) {
			this(i, ConsoleColors.BLACK);
		}

		public ConsoleChar(int i, String black) {
			this.c = (char) i;
			this.color = black;
			// TODO Auto-generated constructor stub
		}

		char c;
		String color;

		@Override
		public String toString() {
			return c + "";
		}
	}

	public static final int HEIGHT = 48;

	public static final int WIDTH = 200;

	private static ConsoleChar[][] screen = new ConsoleChar[HEIGHT][WIDTH];

	int x = 0;
	int y = 0;

	public Terminal() {
		clear();
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void print(String str, String color) {
		for (char c : str.toCharArray()) {
			try {
				screen[y][x++] = new ConsoleChar(c, color);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(y + ":" + x);
			}
		}
	}

	public void print(String str) {
		 print(str,ConsoleColors.BLACK);
	}

	public void renderBlock(String title, Rectangle r) {

		int i = 0;
		screen[r.y][r.x + i] = new ConsoleChar('┌');
		int headLine = (r.width - title.length()) / 2;
		for (i = 1; i < 1; i++) {
			screen[r.y][r.x + i] = new ConsoleChar('─');
		}
		int k = i;

		for (char c : title.toCharArray()) {

			screen[r.y][r.x + k] = new ConsoleChar(c, ConsoleColors.YELLOW);
			k++;
		}
		for (i = k; i < k + (r.width - title.length()) - 1; i++) {
			screen[r.y][r.x + i] = new ConsoleChar('─');
		}
		screen[r.y][r.x + i - 1] = new ConsoleChar('┐');

		for (i = 1; i < r.height; i++) {
			screen[r.y + i][r.x] = new ConsoleChar('│');
		}

		for (i = 1; i < r.height; i++) {
			screen[r.y + i][r.x + r.width - 1] = new ConsoleChar('│');
		}
		screen[r.y + r.height][r.x] = new ConsoleChar('└');
		for (i = 1; i < r.width; i++) {
			screen[r.y + r.height][r.x + i] = new ConsoleChar('─');
		}
		screen[r.y + r.height][r.x + i - 1] = new ConsoleChar('┘');

	}

	public void popup(Rectangle r) {
		

		for (int i = r.y-1; i < r.y + r.height + 1; i++) {

			for (int j = r.x-1; j < r.x + r.width + 1; j++) {

				screen[i][j] = new ConsoleChar(' ');
			}
		}
		renderBlock("popup", r);
	}

	public void flush() {

		clearScreen();

		for (int i = 0; i < HEIGHT; i++) {

			for (int j = 0; j < WIDTH; j++) {

				if (screen[i][j].c == 0) {
					System.out.print(" ");
				} else {
					if (IS_TERMINAL)
						System.out.print(screen[i][j].color + screen[i][j].c);
					else {
						System.out.print(screen[i][j].c);

					}
				}
			}
			System.out.println();
		}
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");

		System.out.flush();
	}

	public void clear() {

		for (int i = 0; i < HEIGHT; i++) {

			for (int j = 0; j < WIDTH; j++) {
				if (i == HEIGHT - 1) {
					screen[i][j] = new ConsoleChar('-');
				} else {

					screen[i][j] = new ConsoleChar(0);
				}
			}
		}
	}

	public static void main(String[] args) {
		Terminal ter = new Terminal();
		ter.move(6, 11);
		ter.print("kajdflkjdfklj");
		ter.popup(new Rectangle(10, 10, 60, 20));
		ter.flush();

	}
}
























