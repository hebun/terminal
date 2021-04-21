package tui;

import java.awt.Rectangle;

public class Main {
	public static void main(String[] args) {
		Terminal ter = new Terminal();
		ter.move(20, 20);
		ter.print("this should apear on 20:20");
		ter.renderBlock("my block", new Rectangle(30, 25, 100, 20));
		ter.move(32, 28);
		ter.print("inside the block");
		ter.flush();
	}
}
