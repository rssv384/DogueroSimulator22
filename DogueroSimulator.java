import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DogueroSimulator extends JFrame {

	public Factores factores;

	public DogueroSimulator() {
		initValues();
	} // end constructor
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		factores = new Factores();

		// Crear elementos
		JPanel mainPanel = new JPanel(new CardLayout()); // JPanel con CardLayout
		MenuPrincipal menuPrincipal = new MenuPrincipal(mainPanel);
		EditarFactores editarFactores = new EditarFactores(mainPanel,factores);
		MenuSimulacion menuSimulacion = new MenuSimulacion(mainPanel);
		VistaSimulacion vistaSimulacion = new VistaSimulacion();
		
		// Agregar paneles al panel principal
		mainPanel.add(menuPrincipal, "MenuPrincipal");
		mainPanel.add(menuSimulacion, "MenuSimulacion");
		mainPanel.add(editarFactores, "EditarFactores");
		mainPanel.add(vistaSimulacion, "VistaSimulacion");
		
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
