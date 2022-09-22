import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditarFactores extends JPanel {
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent
	
	public EditarFactores(JPanel parent) {
		this.parent = parent;
		initValues();
	} // end constructor
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteTexto = new Font("Courier New", 1, 16);
		
		// Obtener CardLayout del parent
		cl = (CardLayout) parent.getLayout();
		
		// Crear elementos
		JLabel txtTitulo = new JLabel("Editar Factores",SwingConstants.CENTER);
		txtTitulo.setFont(fuenteTitulo);
		JLabel txtIngredientes = new JLabel("Ingredientes",SwingConstants.LEFT);
		txtIngredientes.setFont(fuenteTexto);
		JLabel txtIng1 = new JLabel("Pan",SwingConstants.LEFT);
		txtIng1.setFont(fuenteTexto);
		JLabel txtIng2 = new JLabel("Salchicha",SwingConstants.LEFT);	
		txtIng2.setFont(fuenteTexto);
		JLabel txtCantidad = new JLabel("Cantidad",SwingConstants.CENTER);
		txtCantidad.setFont(fuenteTexto);
		JLabel txtTiempo = new JLabel("Tiempo",SwingConstants.RIGHT);
		txtTiempo.setFont(fuenteTexto);
		JTextField tf1 = new JTextField("",SwingConstants.CENTER);
		JTextField tf2 = new JTextField("",SwingConstants.CENTER);
		JTextField tf3 = new JTextField("");
		JTextField tf4 = new JTextField("");
		JButton btnRegresar = new JButton();
		btnRegresar.setIcon(new ImageIcon("images/regresar.png"));
		JButton btnGuardar = new JButton("Guardar");

		// Definir propiedades de los elementos
		txtTitulo.setBounds(240,20,800,100);
		txtIngredientes.setBounds(300,135,200,25);
		txtIng1.setBounds(300,190,200,25);
		txtIng2.setBounds(300,235,200,25);
		txtCantidad.setBounds(535,135,200,25);
		tf1.setBounds(590,190,100,25);
		tf2.setBounds(590,235,100,25);
		txtTiempo.setBounds(735,135,200,25);
		tf3.setBounds(855,190,100,25);
		tf4.setBounds(855,235,100,25);
		btnRegresar.setBounds(190,20,50,50);
		btnGuardar.setBounds(590,335,100,25);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRegresar) {
					// Regresar al panel anterior (MenuPrincipal)
					cl.show(parent, "MenuPrincipal");
				} // end btnRegresar
				if (e.getSource() == btnGuardar) {
					// Guardar cambios
				} // end btnGuardar
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnRegresar.addActionListener(listener);
		btnGuardar.addActionListener(listener);

		// Agregar elementos al panel
		add(txtTitulo);
		add(txtIngredientes);
		add(txtCantidad);
		add(txtTiempo);
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(txtIng1);
		add(txtIng2);
		add(btnGuardar);
		add(btnRegresar);

		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
	} // end initValues
	
}
