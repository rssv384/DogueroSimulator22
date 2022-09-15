import java.awt.*;
import javax.swing.*;

public class Animacion extends JLabel implements Runnable{

	boolean pausar, reanudar, stop;

	public Animacion(String name) {
		setText(name);
	} // end constructor

	public void run() {
		stop = false;
		for(int i=1; i<=10; i++) {
			try {
				synchronized(this) {
					while(pausar) {
						wait();
					}
					if(stop) {
						break;
					}
				} // end sync

				Thread.sleep(1000);
				setText(Integer.toString(i) + "hot dog");
			} catch(Exception e) {
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