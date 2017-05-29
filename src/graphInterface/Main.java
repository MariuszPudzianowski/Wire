package graphInterface;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		//Wire.Wire.main(args);
//		Window aaa = new Window();
//		aaa.board.repaint();
		/* plansza rysowanie bez usuwania przyciskow */
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Window();
				
			}
		});
	}
}