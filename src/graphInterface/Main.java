package graphInterface;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		//Wire.Wire.main(args);
//		Window aaa = new Window();
//		aaa.board.repaint();
		/* poprawic save        cofanie z bledami*/
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				new Window();
				
			}
		});
	}
}