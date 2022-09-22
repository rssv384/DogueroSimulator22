import java.awt.*;
import javax.swing.*;

public class Animacion extends JLabel implements Runnable {

	boolean pausar, reanudar, stop;
	public String[] urlList;
	public ImageIcon img;
	public int y, max;

	public Animacion(String [] urlList, int y) {
		this.urlList = urlList;
		this.y = y;
	} // end constructor

	public void run() {
		stop = false;
		int index = 0;
		max = urlList.length-1;

		for (int i = 10; i <= 410; i++) {

			img = new ImageIcon(this.getClass().getResource(urlList[index]));
			
			if (index == max) {
				index = 0;
			} else {
				index++;
			}

			setIcon(img);
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

				Thread.sleep(50);
				//setText(Integer.toString(i) + "hot dog");
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
