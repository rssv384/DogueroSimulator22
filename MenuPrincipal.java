import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuPrincipal extends JPanel {
	public JPanel parent; // Panel parent
	public String[] urlList1 = new String[] {"images/img1.png", "images/img2.png", "images/img3.png", "images/img4.png"};
	private CardLayout cl; // LayoutManager del panel parent
	private LogoAnimado  logo;

	int Etiqueta;
	public MenuPrincipal(JPanel parent) {
		this.parent = parent;
		initValues();
		Thread t1 = new Thread(logo);
		t1.start();
	} // end constructor
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteTexto = new Font("Courier New", 1, 24);
		

		// Obtener CardLayout del parent
		cl = (CardLayout) parent.getLayout();
		
		// Crear elementos
		logo = new LogoAnimado(urlList1, 602, 60);
		
		JButton btnIrSimular = new JButton("Ir a simulación");
		btnIrSimular.setFont(fuenteTexto);
		JButton btnEditarFactores = new JButton("Editar factores");
		btnEditarFactores.setFont(fuenteTexto);
		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(fuenteTexto);

		// Definir propiedades de los elementos
		logo.setBounds(602,10,63,77);
		btnIrSimular.setBounds(540,250,200,100);
		btnEditarFactores.setBounds(540,375,200,100);
		btnSalir.setBounds(540,500,200,100);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnIrSimular) {
					// Ir al panel MenuSimulacion
					cl.show(parent, "MenuSimulacion");
				} // end btnIrSimular
				if (e.getSource() == btnEditarFactores) {
					// Ir al panel EditarFactores
					cl.show(parent, "EditarFactores");
				} // end btnEditarFactores
				if (e.getSource() == btnSalir) {
					if (JOptionPane.showConfirmDialog(null,"¿Desea cerrar la aplicación?","Doguero Simulator '22",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
						System.exit(0);
				} // end btnSalir
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnIrSimular.addActionListener(listener);
		btnEditarFactores.addActionListener(listener);
		btnSalir.addActionListener(listener);

		// Agregar elementos al panel
		add(logo);
		add(btnIrSimular);
		add(btnEditarFactores);
		add(btnSalir);
		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
		setVisible(true);
	} // end initValues
	
}
