import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DogueroSimulator extends JFrame {

	public DogueroSimulator() {
		initValues();
	}
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		// Crear elementos
		JPanel mainPanel = new JPanel(new CardLayout()); // JPanel con CardLayout
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		EditarFactores editarFactores = new EditarFactores(mainPanel);
		MenuSimulacion ms1 = new MenuSimulacion();
		// VistaSimulacion
		
		// Agregar paneles al panel principal
		mainPanel.add(menuPrincipal, "MenuPrincipal");
		mainPanel.add(ms1, "MenuSimulacion");
		mainPanel.add(editarFactores, "EditarFactores");
		// mainPanel.add(miPanel,"NombrePanel");

		// Agregar paneles al panel principal
		mainPanel.add(menuPrincipal, "MenuPrincipal");
		mainPanel.add(editarFactores, "EditarFactores");
		mainPanel.add(menuSimulacion, "MenuSimulacion");
		
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
