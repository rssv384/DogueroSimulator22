import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuSimulacion extends JPanel {
	JPanel parent
	
	public MenuSimulacion() {
		initValues();
	} // end constructor
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteTexto = new Font("Courier New", 1, 16);
		
		// Crear elementos
		

		// Definir propiedades de los elementos
		

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == /*btnIrSimular*/) {
					// Regresar al panel anterior (MenuPrincipal)
				} // end btnRegresar
				if (e.getSource() == /*btnAgregar*/) {
					// Agregar orden
				} // end btnAgregar
				if (e.getSource() == /*btnEliminar*/) {
					// Eliminar orden
				} // end btnEliminar
				if (e.getSource() == /*btnSimular*/) {
					// Ir al panel de simulacion (VistaSimulacion)
				} // end btnSimular
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		

		// Agregar elementos al panel

		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
	} // end initValues
	
}