import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuSimulacion extends JPanel {
	
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent
	public Recursos recursos;
	public Factores factores;

	JTextField panDisp;
	JTextField salchDisp;
	JTextField tocDisp;
	JTextField tomDisp;
	JTextField lecDisp;
	JTextField mayoDisp;
	JTextField totalOrden;
	
	public MenuSimulacion(JPanel parent, Factores factores, Recursos recursos) {
		this.parent = parent;
		this.factores = factores;
		this.recursos = recursos;
		initValues();
	} // end constructor

	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteSubTitulo = new Font("Courier New", 1, 32);
		Font fuenteTexto = new Font("Courier New", 1, 16);
		
		// Obtener CardLayout del parent
		cl = (CardLayout) parent.getLayout();
		
		// Crear elementos
		JLabel txtTituloUno = new JLabel("Recursos disponibles");
		JLabel txtTituloDos = new JLabel("Ordenar");
		JLabel sub1 = new JLabel("Ingredientes");
		JLabel sub2 = new JLabel("Cantidad");
		JLabel sub3 = new JLabel("Ingredientes");
		JLabel sub4 = new JLabel("Órdenes");
		JLabel txtTotal = new JLabel("Total: ");
		JLabel txtPan = new JLabel("Pan");
		JLabel txtSalch = new JLabel("Salchicha");
		JLabel txtToc = new JLabel("Tocino");
		JLabel txtTom = new JLabel("Tomate");
		JLabel txtLec = new JLabel("Lechuga");
		JLabel txtMayo = new JLabel("Mayonesa");
		panDisp = new JTextField();
		salchDisp = new JTextField();
		tocDisp = new JTextField();
		tomDisp = new JTextField();
		lecDisp = new JTextField();
		mayoDisp = new JTextField();
		totalOrden = new JTextField();
		JList listOrdenes = new JList();
		JCheckBox checkSalch = new JCheckBox("Salchicha");
		JCheckBox checkToc = new JCheckBox("Tocino");
		JCheckBox checkTom = new JCheckBox("Tomate");
		JCheckBox checkLec = new JCheckBox("Lechuga");
		JCheckBox checkMayo = new JCheckBox("Mayonesa");
		JButton btnSimular = new JButton("Iniciar Simulación");
		JButton btnAgregar = new JButton("Agregar");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnRegresar = new JButton();
		btnRegresar.setIcon(new ImageIcon("images/regresar.png"));

		txtTituloUno.setFont(fuenteSubTitulo);
		txtTituloDos.setFont(fuenteSubTitulo);
		sub1.setFont(fuenteTexto);
		sub2.setFont(fuenteTexto);
		sub3.setFont(fuenteTexto);
		sub4.setFont(fuenteTexto);
		txtTotal.setFont(fuenteTexto);
		txtPan.setFont(fuenteTexto);
		txtSalch.setFont(fuenteTexto);
		txtToc.setFont(fuenteTexto);
		txtTom.setFont(fuenteTexto);
		txtLec.setFont(fuenteTexto);
		txtMayo.setFont(fuenteTexto);
		panDisp.setFont(fuenteTexto);
		salchDisp.setFont(fuenteTexto);
		tocDisp.setFont(fuenteTexto);
		tomDisp.setFont(fuenteTexto);
		lecDisp.setFont(fuenteTexto);
		mayoDisp.setFont(fuenteTexto);
		totalOrden.setFont(fuenteTexto);
		listOrdenes.setFont(fuenteTexto);
		checkSalch.setFont(fuenteTexto);
		checkToc.setFont(fuenteTexto);
		checkTom.setFont(fuenteTexto);
		checkLec.setFont(fuenteTexto);
		checkMayo.setFont(fuenteTexto);

		// Definir propiedades de los elementos
		btnRegresar.setBounds(1,1,50,50);

		txtTituloUno.setBounds(75,0,800,100);
		sub1.setBounds(90,60,200,100);
		txtPan.setBounds(100,90,200,100);
		txtSalch.setBounds(100,120,200,100);
		txtToc.setBounds(100,150,200,100);
		txtTom.setBounds(100,180,200,100);
		txtLec.setBounds(100,210,200,100);
		txtMayo.setBounds(100,240,200,100);
		sub2.setBounds(309,60,200,100);
		panDisp.setBounds(300,133,100,20);
		salchDisp.setBounds(300,163,100,20);
		tocDisp.setBounds(300,193,100,20);
		tomDisp.setBounds(300,223,100,20);
		lecDisp.setBounds(300,253,100,20);
		mayoDisp.setBounds(300,283,100,20);
		
		txtTituloDos.setBounds(800,0,800,100);
		sub3.setBounds(693,60,200,100);
		checkSalch.setBounds(700,130,150,30);
		checkToc.setBounds(700,160,150,30);
		checkTom.setBounds(700,190,150,30);
		checkLec.setBounds(700,220,150,30);
		checkMayo.setBounds(700,250,150,30);
		sub4.setBounds(965,60,200,100);
		listOrdenes.setBounds(900,130,200,180);

		txtTotal.setBounds(700,300,200,100);
		totalOrden.setBounds(770,340,100,20);

		btnAgregar.setBounds(760,400,100,30);
		btnEliminar.setBounds(960,400,100,30);
		btnSimular.setBounds(830,460,150,30);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnRegresar) {
					// Regresar al panel anterior (MenuPrincipal)
					cl.show(parent, "MenuPrincipal");
				} // end btnRegresar
				if (e.getSource() == btnAgregar) {
					// Agregar orden
					System.out.println("Orden agregada!");
				} // end btnAgregar
				if (e.getSource() == btnEliminar) {
					// Eliminar orden
					System.out.println("Orden eliminada!");
				} // end btnEliminar
				if (e.getSource() == btnSimular) {
					// Ir al panel de simulacion (VistaSimulacion)
					cl.show(parent, "VistaSimulacion");
					// Iniciar simulación al cambiar de panel
					guardarRecursos();
					VistaSimulacion sim = (VistaSimulacion) parent.getComponent(3);
					sim.factores = factores;
					sim.recursos = recursos;
					sim.start();
				} // end btnSimular
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnSimular.addActionListener(listener);
		btnAgregar.addActionListener(listener);
		btnEliminar.addActionListener(listener);
		btnRegresar.addActionListener(listener);

		// Agregar elementos al panel
		add(btnRegresar);
		add(txtTituloUno);
		add(sub1);
		add(txtPan);
		add(txtSalch);
		add(txtToc);
		add(txtTom);
		add(txtLec);
		add(txtMayo);
		add(sub2);
		add(panDisp);
		add(salchDisp);
		add(tocDisp);
		add(tomDisp);
		add(lecDisp);
		add(mayoDisp);
		add(txtTituloDos);
		add(sub3);
		add(checkSalch);
		add(checkToc);
		add(checkTom);
		add(checkLec);
		add(checkMayo);
		add(sub4);
		add(listOrdenes);
		add(txtTotal);
		add(totalOrden);
		add(btnAgregar);
		add(btnEliminar);
		add(btnSimular);
		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
	} // end initValues
	
	// Método para guardar los recursos disponibles en la clase contenedora
	public void guardarRecursos() {
		try {
			recursos.setPanD(Integer.parseInt(panDisp.getText()));
			recursos.setSalchichaD(Integer.parseInt(salchDisp.getText()));
			recursos.setTocinoD(Integer.parseInt(tocDisp.getText()));
			recursos.setTomateD(Integer.parseInt(tomDisp.getText()));
			recursos.setLechugaD(Integer.parseInt(lecDisp.getText()));
			recursos.setMayonesaD(Integer.parseInt(mayoDisp.getText()));
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Uno o más recursos recibieron valores inválidos. Intente nuevamente.");
		}
	}
}
