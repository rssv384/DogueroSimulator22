import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DogueroSimulator extends JFrame {

	public Factores factores;
	public Recursos recursos;

	public DogueroSimulator() {
		factores = new Factores();
		recursos = new Recursos();
		initValues();
	} // end constructor
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {

		// Crear elementos
		JPanel mainPanel = new JPanel(new CardLayout()); // JPanel con CardLayout
		MenuPrincipal menuPrincipal = new MenuPrincipal(mainPanel);
		EditarFactores editarFactores = new EditarFactores(mainPanel, factores);
		MenuSimulacion menuSimulacion = new MenuSimulacion(mainPanel, factores, recursos);
		VistaSimulacion vistaSimulacion = new VistaSimulacion(mainPanel);
		VistaReporte vistaReporte = new VistaReporte(mainPanel, factores);

		// Agregar paneles al panel principal
		mainPanel.add(menuPrincipal, "MenuPrincipal");
		mainPanel.add(menuSimulacion, "MenuSimulacion");
		mainPanel.add(editarFactores, "EditarFactores");
		mainPanel.add(vistaSimulacion, "VistaSimulacion");
		mainPanel.add(vistaReporte, "VistaReporte");
		
		// Agregar elementos a la ventana (JFrama)
		add(mainPanel);
			
		// Propiedades de la ventana (JFrame)
		setTitle("Doguero Simulator '22");
		setSize(1280, 720);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		setVisible(true);
	} // end initValues
}
