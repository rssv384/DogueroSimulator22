import java.awt.*;
import javax.swing.*;

public class LogoAnimado extends JLabel implements Runnable {

	boolean pausar, reanudar;
	public String[] urlList;
	public ImageIcon img;
	public int x, y, max;

	public LogoAnimado(String [] urlList, int x, int y) {
		this.urlList = urlList;
		this.x = x;
		this.y = y;
	} // end constructor

	public void run() {
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
			setBounds(x, y, 63, 77);

			try {
				synchronized (this) {
					while (pausar) {
						wait();
					}
				} // end sync

				Thread.sleep(150);
			} catch (Exception e) {
				System.out.println("Hubo un error con la animación del logo!");
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
}