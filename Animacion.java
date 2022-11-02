import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Animacion extends JLabel implements Runnable {

	boolean pausar, reanudar, stop, hayRecursos;
	private String[] urlList = new String[] {"images/hot-dog-pan.png", "images/hot-dog-salchicha.png", "images/hot-dog-mayo.png", "images/hot-dog-tomate.png", "images/hot-dog-lechuga.png"};
	public ImageIcon img;
	private String[] listaIngredientes = new String[] {"pan", "salchicha", "tocino", "mayonesa", "tomate", "lechuga"};
	public Recursos recursos;
	public Factores factores;
	public ArrayList<Orden> ordenes;

	public Animacion() {

	} // end constructor

	public void run() {
		//ordenes = new ArrayList<Orden>();
		stop = false; hayRecursos = true;
		int hotDogsPreparados = 0; // Contador de hot dogs

		// Obtener la ventana del reporte, la cual se muestra al terminar la simulación
		VistaSimulacion vs = (VistaSimulacion) this.getParent();
		vs.contadorOrdenes.setText("Órdenes restantes: " + ordenes.size());

		// La simulación correrá mientras se tengan recursos disponibles o haya ordenes pendientes
		while (hayRecursos && !ordenes.isEmpty()) {
			try {
				// Obtener la primera orden de la lista y removerla
				Orden o = ordenes.remove(0);

				// Ciclo correspondiente a la cantidad de hot dogs de la órden
				for (int i=0; i<o.cantidad; i++) {
					// Iterar la lista de ingredientes y cambiar el icono para representar
					// que se agregó un nuevo ingrediente
					for (String ing : listaIngredientes) {
						synchronized (this) {
							while (pausar) {
								wait();
							}
							if (stop) {
								break;
							}
						} // end sync

						// Espera correspondiente al tiempo es que tarda en servirse el ingrediente (Factores)
						double wait = 0;

						// Switch case que identifica el ingrediente, valida si la orden debe llevarlo
						// y actúa según sea el caso
						switch(ing) {
							case "pan":
								img = new ImageIcon(this.getClass().getResource(urlList[0]));
								recursos.setPanD(recursos.getPanD() - factores.getCantPan()); // Disminuir recursos disp.
								recursos.setPanU(recursos.getPanU() + factores.getCantPan()); // Aumentar recursos usados
								wait = factores.getTiempoPan(); // Obtener tiempo para servir el ingrediente
								break;
							case "salchicha":
								if(o.salchicha) {
									img = new ImageIcon(this.getClass().getResource(urlList[1]));
									recursos.setSalchichaD(recursos.getSalchichaD() - factores.getCantSalch());
									recursos.setSalchichaU(recursos.getSalchichaU() + factores.getCantSalch());
									wait = factores.getTiempoSalch();
									if(o.tocino){
										recursos.setTocinoD(recursos.getTocinoD() - factores.getCantToc());
										recursos.setTocinoU(recursos.getTocinoU() + factores.getCantToc());
									}
								}
								break;
							case "mayonesa":
								if(o.mayonesa) {
									img = new ImageIcon(this.getClass().getResource(urlList[2]));
									recursos.setMayonesaD(recursos.getMayonesaD() - factores.getCantMayo());
									recursos.setMayonesaU(recursos.getMayonesaU() + factores.getCantMayo());
									wait = factores.getTiempoMayo();
								}
								break;
							case "tomate":
								if(o.tomate) {
									img = new ImageIcon(this.getClass().getResource(urlList[3]));
									recursos.setTomateD(recursos.getTomateD() - factores.getCantTom());
									recursos.setTomateU(recursos.getTomateU() + factores.getCantTom());
									wait = factores.getTiempoTom();
								}
								break;
							case "lechuga":
								if(o.lechuga) {
									img = new ImageIcon(this.getClass().getResource(urlList[4]));
									recursos.setLechugaD(recursos.getLechugaD() - factores.getCantLec());
									recursos.setLechugaU(recursos.getLechugaU() + factores.getCantLec());
									wait = factores.getTiempoLec();
								}
								break;
						} // end switch

						// Cambiar la imagen
						setIcon(img);
						setBounds(530, 50, 500, 400);

						setText("Agregando " + ing + ". . .");
						Thread.sleep((int)(wait*1000)); // Espera entre agregar un ingrediente y otro
						recursos.setTiempoTotal(recursos.getTiempoTotal() + wait); // Incrementar el contador de tiempo de preparación

						// Validar que ningún recurso esté en 0 o sea insuficiente
						if(recursos.getPanD() < factores.getCantPan()  || recursos.getSalchichaD() < factores.getCantSalch() || 
							recursos.getTocinoD() < factores.getCantToc() || recursos.getMayonesaD() < factores.getCantMayo() || 
							recursos.getTomateD() < factores.getCantTom() || recursos.getLechugaD() < factores.getCantLec()) {
							hayRecursos = false;
						}
					} // end for
					// Incrementar el total de hot dogs preparados
					hotDogsPreparados++;
					recursos.setTotalHotDogs(hotDogsPreparados);
					vs.contadorHotDogs.setText("Hot dogs preparados: " + Integer.toString(hotDogsPreparados));
				} // end for

				vs.contadorOrdenes.setText("Órdenes restantes: " + ordenes.size()); // Disminuir el contador de ordenes

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null,"Hubo un error con la simulación!");
			}
		} // end while

		// Si se agotan los recursos antes de que se sirvan todas las órdenes
		if(!hayRecursos && ordenes.size() > 0) {
			// Mostrar mensaje de que se acabaron los recursos
			JOptionPane.showMessageDialog(null, "La simulación se ha detenido debido a que uno o más recursos se han agotado.");
		} else if (ordenes.size() == 0) {
			// Mostrar mensaje terminación exitosa de la simulación
			JOptionPane.showMessageDialog(null, "¡Simulación terminada con éxito!");
		}

		// Al terminar de ejecutar la animación, cambiar a la vista del reporte
		vs.contadorHotDogs.setText("Hot dogs preparados: 0"); // Reiniciar contador
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
