import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class EditarFactores extends JPanel {
	public JPanel parent; // Panel parent
	public Factores factores; // Factores de preparación
	private CardLayout cl; // LayoutManager del panel parent

	JTextField tfCantPan;
	JTextField tfCantSalchicha;
	JTextField tfCantTocino;
	JTextField tfCantTomate;
	JTextField tfCantLechuga;
	JTextField tfCantMayonesa;
	JTextField tfTiempoPan;
	JTextField tfTiempoSalchicha;
	JTextField tfTiempoTocino;
	JTextField tfTiempoTomate;
	JTextField tfTiempoLechuga;
	JTextField tfTiempoMayonesa;
	
	public EditarFactores(JPanel parent, Factores factores) {
		this.parent = parent;
		this.factores = factores;
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
		JLabel txtCantidad = new JLabel("Cantidad (g)",SwingConstants.CENTER);
		txtCantidad.setFont(fuenteTexto);
		JLabel txtTiempo = new JLabel("Tiempo en servir (s)",SwingConstants.CENTER);
		txtTiempo.setFont(fuenteTexto);
		JLabel txtPan = new JLabel("Pan (pza.)",SwingConstants.LEFT);
		txtPan.setFont(fuenteTexto);
		JLabel txtSalchicha = new JLabel("Salchicha (pza.",SwingConstants.LEFT);	
		txtSalchicha.setFont(fuenteTexto);
		JLabel txtTocino = new JLabel("Tocino (pza.)",SwingConstants.LEFT);
		txtTocino.setFont(fuenteTexto);
		JLabel txtTomate = new JLabel("Tomate",SwingConstants.LEFT);	
		txtTomate.setFont(fuenteTexto);
		JLabel txtLechuga = new JLabel("Lechuga",SwingConstants.LEFT);
		txtLechuga.setFont(fuenteTexto);
		JLabel txtMayonesa = new JLabel("Mayonesa",SwingConstants.LEFT);	
		txtMayonesa.setFont(fuenteTexto);

		tfCantPan = new JTextField();
		tfCantSalchicha = new JTextField();
		tfCantTocino = new JTextField();
		tfCantTomate = new JTextField();
		tfCantLechuga = new JTextField();
		tfCantMayonesa = new JTextField();
		tfTiempoPan = new JTextField();
		tfTiempoSalchicha = new JTextField();
		tfTiempoTocino = new JTextField();
		tfTiempoTomate = new JTextField();
		tfTiempoLechuga = new JTextField();
		tfTiempoMayonesa = new JTextField();

		// Cargar valores de los factores
		cargarFactores();

		JButton btnRegresar = new JButton();
		btnRegresar.setIcon(new ImageIcon("images/regresar.png"));
		JButton btnGuardar = new JButton("Guardar y salir");

		// Definir propiedades de los elementos
		txtTitulo.setBounds(240,20,800,100);
		txtIngredientes.setBounds(300,135,200,25);
		txtPan.setBounds(300,190,200,25);
		txtSalchicha.setBounds(300,235,200,25);
		txtTocino.setBounds(300,285,200,25);
		txtTomate.setBounds(300,330,200,25);
		txtLechuga.setBounds(300,375,200,25);
		txtMayonesa.setBounds(300,420,200,25);

		txtCantidad.setBounds(535,135,200,25);
		tfCantPan.setBounds(590,190,100,25);
		tfCantSalchicha.setBounds(590,235,100,25);
		tfCantTocino.setBounds(590,285,100,25);
		tfCantTomate.setBounds(590,330,100,25);
		tfCantLechuga.setBounds(590,375,100,25);
		tfCantMayonesa.setBounds(590,420,100,25);

		txtTiempo.setBounds(755,135,200,25);
		tfTiempoPan.setBounds(855,190,100,25);
		tfTiempoSalchicha.setBounds(855,235,100,25);
		tfTiempoTocino.setBounds(855,285,100,25);
		tfTiempoTomate.setBounds(855,330,100,25);
		tfTiempoLechuga.setBounds(855,375,100,25);
		tfTiempoMayonesa.setBounds(855,420,100,25);

		btnRegresar.setBounds(190,20,50,50);
		btnGuardar.setBounds(550,600,180,25);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRegresar) {
					// Regresar al panel anterior (MenuPrincipal)
					cl.show(parent, "MenuPrincipal");
				} // end btnRegresar
				if (e.getSource() == btnGuardar) {
					guardarCambios();
					cl.show(parent, "MenuPrincipal");
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
		add(txtPan);
		add(txtSalchicha);
		add(txtTocino);
		add(txtTomate);
		add(txtLechuga);
		add(txtMayonesa);
		add(tfCantPan);
		add(tfCantSalchicha);
		add(tfCantTocino);
		add(tfCantTomate);
		add(tfCantLechuga);
		add(tfCantMayonesa);
		add(tfTiempoPan);
		add(tfTiempoSalchicha);
		add(tfTiempoTocino);
		add(tfTiempoTomate);
		add(tfTiempoLechuga);
		add(tfTiempoMayonesa);
		add(btnGuardar);
		add(btnRegresar);


		// Deshabilitar los campos de edición de cantidad de pan (ya que es 1/dogo)
		// y de tiempo de tocino (ya que se sirve junto a la salchicha).
		tfCantPan.setEnabled(false);
		tfTiempoTocino.setEnabled(false);

		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
		setLayout(null);
	} // end initValues
	
	private void cargarFactores() {
		tfCantPan.setText(Integer.toString(factores.CantidadIng.get("Pan")));
		tfCantSalchicha.setText(Integer.toString(factores.CantidadIng.get("Salchicha")));
		tfCantTocino.setText(Integer.toString(factores.CantidadIng.get("Tocino")));
		tfCantTomate.setText(Integer.toString(factores.CantidadIng.get("Tomate")));
		tfCantLechuga.setText(Integer.toString(factores.CantidadIng.get("Lechuga")));
		tfCantMayonesa.setText(Integer.toString(factores.CantidadIng.get("Mayonesa")));

		tfTiempoPan.setText(Integer.toString(factores.TiempoIng.get("Pan")));
		tfTiempoSalchicha.setText(Integer.toString(factores.TiempoIng.get("Salchicha")));
		tfTiempoTocino.setText(Integer.toString(factores.TiempoIng.get("Tocino")));
		tfTiempoTomate.setText(Integer.toString(factores.TiempoIng.get("Tomate")));
		tfTiempoLechuga.setText(Integer.toString(factores.TiempoIng.get("Lechuga")));
		tfTiempoMayonesa.setText(Integer.toString(factores.TiempoIng.get("Mayonesa")));
	}


	private void guardarCambios() {
		factores.CantidadIng.put("Pan",Integer.parseInt(tfCantPan.getText()));
		factores.CantidadIng.put("Salchicha",Integer.parseInt(tfCantPan.getText()));
		factores.CantidadIng.put("Tocino",Integer.parseInt(tfCantPan.getText()));
		factores.CantidadIng.put("Tomate",Integer.parseInt(tfCantPan.getText()));
		factores.CantidadIng.put("Lechuga",Integer.parseInt(tfCantPan.getText()));
		factores.CantidadIng.put("Mayonesa",Integer.parseInt(tfCantPan.getText()));

		factores.TiempoIng.put("Pan",Integer.parseInt(tfTiempoPan.getText()));
		factores.TiempoIng.put("Salchicha",Integer.parseInt(tfTiempoSalchicha.getText()));
		factores.TiempoIng.put("Tocino",Integer.parseInt(tfTiempoTocino.getText()));
		factores.TiempoIng.put("Tomate",Integer.parseInt(tfTiempoTomate.getText()));
		factores.TiempoIng.put("Lechuga",Integer.parseInt(tfTiempoLechuga.getText()));
		factores.TiempoIng.put("Mayonesa",Integer.parseInt(tfTiempoMayonesa.getText()));
	}

}
