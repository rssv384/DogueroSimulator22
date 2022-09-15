import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DogueroSimulator extends JFrame {

	CardLayout cl;
	public JPanel parent;

	public DogueroSimulator() {
		initValues();
	}
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		// Crear elementos
		JPanel mainPanel = new JPanel(new CardLayout()); // JPanel con CardLayout
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		// EditarFactores
		// MenuSimulacion
		MenuSimulacion ms1 = new MenuSimulacion();
		// VistaSimulacion
		
		// Agregar paneles al panel principal
		mainPanel.add(menuPrincipal, "MenuPrincipal");
		// mainPanel.add(miPanel,"NombrePanel");
		mainPanel.add(ms1, "MenuSimulacion");

		//cambio de ventanas
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == menuPrincipal.btnIrSimular){
					cl = (CardLayout)(mainPanel.getLayout());
					cl.show(mainPanel, "MenuSimulacion");
				}if(e.getSource() == ms1.btnSalir){
					cl = (CardLayout) mainPanel.getLayout();
					cl.show(mainPanel, "MenuPrincipal");
				}
			}
		};

		menuPrincipal.btnIrSimular.addActionListener(listener);
		ms1.btnSalir.addActionListener(listener);
		
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