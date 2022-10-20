import java.awt.*;
import javax.swing.*;

public class Animacion extends JLabel implements Runnable {

	boolean pausar, reanudar, stop, hayRecursos;
	public String[] urlList;
	public ImageIcon img;
	private String[] listaIngredientes = new String[] {"pan", "salchicha", "tocino", "mayonesa", "tomate", "lechuga"};
	public Recursos recursos;
	public Factores factores;

	public Animacion(String [] urlList) {
		this.urlList = urlList;
	} // end constructor

	public void run() {
		stop = false; hayRecursos = true;
		int hotDogsPreparados = 0; // Contador de hot dogs

		// Obtener la ventana del reporte, la cual se muestra al terminar la simulación
		VistaSimulacion vs = (VistaSimulacion) this.getParent();

		// La simulación correrá mientras se tengan recursos disponibles
		while (hayRecursos) {
			try {
				synchronized (this) {
					while (pausar) {
						wait();
					}
					if (stop) {
						break;
					}
				} // end sync

				// Iterar la lista de ingredientes y cambiar el icono para representar
				// que se agregó un nuevo ingrediente
				for (String ing : listaIngredientes) {
					// Espera correspondiente al tiempo es que tarda en servirse el ingrediente (Factores)
					double wait = 0;

					switch(ing) {
						case "pan":
							img = new ImageIcon(this.getClass().getResource(urlList[0]));
							recursos.setPanD(recursos.getPanD() - factores.getCantPan()); // Disminuir recursos disp.
							recursos.setPanU(recursos.getPanU() + factores.getCantPan()); // Aumentar recursos usados
							wait = factores.getTiempoPan(); // Obtener tiempo para servir el ingrediente
							break;
						case "salchicha":
							img = new ImageIcon(this.getClass().getResource(urlList[1]));
							recursos.setSalchichaD(recursos.getSalchichaD() - factores.getCantSalch());
							recursos.setSalchichaU(recursos.getSalchichaU() + factores.getCantSalch());
							wait = factores.getTiempoSalch();
							recursos.setTocinoD(recursos.getTocinoD() - factores.getCantToc());
							recursos.setTocinoU(recursos.getTocinoU() + factores.getCantToc());
							break;
						case "mayonesa":
							img = new ImageIcon(this.getClass().getResource(urlList[2]));
							recursos.setMayonesaD(recursos.getMayonesaD() - factores.getCantMayo());
							recursos.setMayonesaU(recursos.getMayonesaU() + factores.getCantMayo());
							wait = factores.getTiempoMayo();
							break;
						case "tomate":
							img = new ImageIcon(this.getClass().getResource(urlList[3]));
							recursos.setTomateD(recursos.getTomateD() - factores.getCantTom());
							recursos.setTomateU(recursos.getTomateU() + factores.getCantTom());
							wait = factores.getTiempoTom();
							break;
						case "lechuga":
							img = new ImageIcon(this.getClass().getResource(urlList[4]));
							recursos.setLechugaD(recursos.getLechugaD() - factores.getCantLec());
							recursos.setLechugaU(recursos.getLechugaU() + factores.getCantLec());
							wait = factores.getTiempoLec();
							break;
					}

					// Cambiar la imagen
					setIcon(img);
					setBounds(576, 50, 128, 128);

					Thread.sleep((int)(wait*1000)); // Espera entre agregar un ingrediente y otro
					recursos.setTiempoTotal(recursos.getTiempoTotal() + wait); // Incrementar el contador de tiempo de preparación

					// Validar que ningún recurso esté en 0
					if(recursos.getPanD() == 0 || recursos.getSalchichaD() == 0 || recursos.getTocinoD() == 0 || 
						recursos.getMayonesaD() == 0 || recursos.getTomateD() <= 0 || recursos.getLechugaD() <= 0) {
						hayRecursos = false;
					}
				}

				// Incrementar el total de hot dogs preparados
				hotDogsPreparados++;
				recursos.setTotalHotDogs(hotDogsPreparados);
				vs.contadorHotDogs.setText("Hot dogs preparados: " + Integer.toString(hotDogsPreparados));

			} catch (Exception e) {
				System.out.println("Hubo un error con la simulación!");
				System.out.println(e.getMessage());
			}
		} // end for

		// Al terminar de ejecutar la animación, cambiar a la vista del reporte
		vs.verReporte();

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
