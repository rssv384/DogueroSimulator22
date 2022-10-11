import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaReporte extends JPanel {
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent

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

		JLabel txtCantPan = new JLabel();
		JLabel txtCantSalchicha = new JLabel();
		JLabel txtCantTocino = new JLabel();
		JLabel txtCantTomate = new JLabel();
		JLabel txtCantLechuga = new JLabel();
		JLabel txtCantMayonesa = new JLabel();
		JLabel txtResiduoPan = new JLabel();
		JLabel txtResiduoSalchicha = new JLabel();
		JLabel txtResiduoTocino = new JLabel();
		JLabel txtResiduoTomate = new JLabel();
		JLabel txtResiduoLechuga = new JLabel();
		JLabel txtResiduoMayonesa = new JLabel();

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
		txtCantPan.setBounds(590,210,100,25);
		txtCantSalchicha.setBounds(590,255,100,25);
		txtCantTocino.setBounds(590,305,100,25);
		txtCantTomate.setBounds(590,350,100,25);
		txtCantLechuga.setBounds(590,395,100,25);
		txtCantMayonesa.setBounds(590,440,100,25);

		txtResiduo.setBounds(800,155,200,25);
		txtResiduoPan.setBounds(855,210,100,25);
		txtResiduoSalchicha.setBounds(855,255,100,25);
		txtResiduoTocino.setBounds(855,305,100,25);
		txtResiduoTomate.setBounds(855,350,100,25);
		txtResiduoLechuga.setBounds(855,395,100,25);
		txtResiduoMayonesa.setBounds(855,440,100,25);

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
		add(txtCantPan);
		add(txtCantSalchicha);
		add(txtCantTocino);
		add(txtCantTomate);
		add(txtCantLechuga);
		add(txtCantMayonesa);
		add(txtResiduoPan);
		add(txtResiduoSalchicha);
		add(txtResiduoTocino);
		add(txtResiduoTomate);
		add(txtResiduoLechuga);
		add(txtResiduoMayonesa);
		add(btnIrMenuP);
		add(txtTotal);
		add(txtCantDogo);
		add(txtTiempo);

		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
	} // end initValues
	
}
