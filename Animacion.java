import java.awt.*;
import javax.swing.*;

public class Animacion extends JLabel implements Runnable {

	boolean pausar, reanudar, stop;
	static String[] urlList1;
	static ImageIcon img1;
	static int y, max;

	public Animacion(String name) {
		setText(name);
	} // end constructor

	public void run() {
		stop = false;
		int index = 0;
		max = urlList1.length-1;

		for (int i = 10; i <= 410; i++) {
			img1 = new ImageIcon(this.getClass().getResource(urlList1[index]));
			if (index == max) {
				index = 0;
			} else {
				index++;
			}

			setIcon(img1);
			setBounds(i, y, 42, 42);

			try {
				synchronized (this) {
					while (pausar) {
						wait();
					}
					if (stop) {
						break;
					}
				} // end sync

				Thread.sleep(250);
				setText(Integer.toString(i) + "hot dog");
			} catch (Exception e) {
				System.out.println("Hubo un error con la simulación!");
			}
		} // end for
	} // end run

	synchronized void pausarHilo() {
		pausar = true;
	}

	synchronized void reanudarHilo() {
		pausar = false;
		notify();
	}

	synchronized void stopHilo() {
		stop = true;
		pausar = false;
		notify();
	}
}