import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaReporte extends JPanel {
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent

	JTextField tfCantPan;
	JTextField tfCantSalchicha;
	JTextField tfCantTocino;
	JTextField tfCantTomate;
	JTextField tfCantLechuga;
	JTextField tfCantMayonesa;
	JTextField tfResiduoPan;
	JTextField tfResiduoSalchicha;
	JTextField tfResiduoTocino;
	JTextField tfResiduoTomate;
	JTextField tfResiduoLechuga;
	JTextField tfResiduoMayonesa;

	public VistaReporte(JPanel parent) {
		this.parent = parent;
		initValues();
	} // end constructor
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteTexto = new Font("Courier New", 1, 16);
		
        cl = (CardLayout) parent.getLayout();

		// Crear elementos
		JLabel txtTitulo = new JLabel("Reporte Simulacion",SwingConstants.CENTER);
		txtTitulo.setFont(fuenteTitulo);
		JLabel txtTotal = new JLabel("Total: ",SwingConstants.LEFT);
		txtTotal.setFont(fuenteTexto);
		JLabel txtCantDogo = new JLabel("n dogos",SwingConstants.CENTER);
		txtCantDogo.setFont(fuenteTexto);
		JLabel txtTiempo = new JLabel("hh:mm:ss",SwingConstants.CENTER);
		JLabel txtIngredientes = new JLabel("Ingredientes",SwingConstants.LEFT);
		txtIngredientes.setFont(fuenteTexto);
		JLabel txtCantidad = new JLabel("Cantidad",SwingConstants.CENTER);
		txtCantidad.setFont(fuenteTexto);
		JLabel txtResiduo = new JLabel("Residuo",SwingConstants.CENTER);
		txtResiduo.setFont(fuenteTexto);
		JLabel txtPan = new JLabel("Pan (pza.)",SwingConstants.LEFT);
		txtPan.setFont(fuenteTexto);
		JLabel txtSalchicha = new JLabel("Salchicha (pza.)",SwingConstants.LEFT);	
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
		tfResiduoPan = new JTextField();
		tfResiduoSalchicha = new JTextField();
		tfResiduoTocino = new JTextField();
		tfResiduoTomate = new JTextField();
		tfResiduoLechuga = new JTextField();
		tfResiduoMayonesa = new JTextField();

		JButton btnIrMenuP = new JButton("Ir al Menu Principal");

		// Definir propiedades de los elementos
		txtTotal.setBounds(300,115,200,25);
		txtCantDogo.setBounds(535,115,200,25);
		txtTiempo.setBounds(800,115,200,25);


		txtTitulo.setBounds(240,20,800,100);
		txtIngredientes.setBounds(300,155,200,25);
		txtPan.setBounds(300,210,200,25);
		txtSalchicha.setBounds(300,255,200,25);
		txtTocino.setBounds(300,305,200,25);
		txtTomate.setBounds(300,350,200,25);
		txtLechuga.setBounds(300,395,200,25);
		txtMayonesa.setBounds(300,440,200,25);

		txtCantidad.setBounds(535,155,200,25);
		tfCantPan.setBounds(590,210,100,25);
		tfCantSalchicha.setBounds(590,255,100,25);
		tfCantTocino.setBounds(590,305,100,25);
		tfCantTomate.setBounds(590,350,100,25);
		tfCantLechuga.setBounds(590,395,100,25);
		tfCantMayonesa.setBounds(590,440,100,25);

		txtResiduo.setBounds(800,155,200,25);
		tfResiduoPan.setBounds(855,210,100,25);
		tfResiduoSalchicha.setBounds(855,255,100,25);
		tfResiduoTocino.setBounds(855,305,100,25);
		tfResiduoTomate.setBounds(855,350,100,25);
		tfResiduoLechuga.setBounds(855,395,100,25);
		tfResiduoMayonesa.setBounds(855,440,100,25);

		btnIrMenuP.setBounds(550,600,180,25);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnIrMenuP) {
					cl.show(parent, "MenuPrincipal");
				} // end btnIrMenuP
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnIrMenuP.addActionListener(listener);

		// Agregar elementos al panel
		add(txtTitulo);
		add(txtIngredientes);
		add(txtCantidad);
		add(txtResiduo);
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
		add(tfResiduoPan);
		add(tfResiduoSalchicha);
		add(tfResiduoTocino);
		add(tfResiduoTomate);
		add(tfResiduoLechuga);
		add(tfResiduoMayonesa);
		add(btnIrMenuP);
		add(txtTotal);
		add(txtCantDogo);
		add(txtTiempo);

		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
	} // end initValues
	
}