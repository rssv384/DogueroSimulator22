import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuSimulacion extends JPanel {
	
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent
	
	public MenuSimulacion(JPanel parent) {
		this.parent = parent;
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
		JLabel labTotal = new JLabel("Total: ");
		JLabel ing1 = new JLabel("Pan");
		JLabel ing2 = new JLabel("Salchicha");
		JLabel ing3 = new JLabel("Tocino");
		JLabel ing4 = new JLabel("Lechuga");
		JLabel ing5 = new JLabel("Tomate");
		JLabel ing6 = new JLabel("Mayonesa");
		JTextField cant1 = new JTextField();
		JTextField cant2 = new JTextField();
		JTextField cant3 = new JTextField();
		JTextField cant4 = new JTextField();
		JTextField cant5 = new JTextField();
		JTextField cant6 = new JTextField();
		JTextField boxTotal = new JTextField();
		JList listOrdenes = new JList();
		JCheckBox checkIng1 = new JCheckBox("Pan");
		JCheckBox checkIng2 = new JCheckBox("Salchicha");
		JCheckBox checkIng3 = new JCheckBox("Tocino");
		JCheckBox checkIng4 = new JCheckBox("Lechuga");
		JCheckBox checkIng5 = new JCheckBox("Tomate");
		JCheckBox checkIng6 = new JCheckBox("Mayonesa");
		JButton btnSimular = new JButton("Iniciar Simulación");
		JButton btnAgregar = new JButton("Agregar");
		JButton btnEliminar = new JButton("Eliminar");
		JButton btnRegresar = new JButton("Regresar");

		txtTituloUno.setFont(fuenteSubTitulo);
		txtTituloDos.setFont(fuenteSubTitulo);
		sub1.setFont(fuenteTexto);
		sub2.setFont(fuenteTexto);
		sub3.setFont(fuenteTexto);
		sub4.setFont(fuenteTexto);
		labTotal.setFont(fuenteTexto);
		ing1.setFont(fuenteTexto);
		ing2.setFont(fuenteTexto);
		ing3.setFont(fuenteTexto);
		ing4.setFont(fuenteTexto);
		ing5.setFont(fuenteTexto);
		ing6.setFont(fuenteTexto);
		cant1.setFont(fuenteTexto);
		cant2.setFont(fuenteTexto);
		cant3.setFont(fuenteTexto);
		cant4.setFont(fuenteTexto);
		cant5.setFont(fuenteTexto);
		cant6.setFont(fuenteTexto);
		boxTotal.setFont(fuenteTexto);
		listOrdenes.setFont(fuenteTexto);
		checkIng1.setFont(fuenteTexto);
		checkIng2.setFont(fuenteTexto);
		checkIng3.setFont(fuenteTexto);
		checkIng4.setFont(fuenteTexto);
		checkIng5.setFont(fuenteTexto);
		checkIng6.setFont(fuenteTexto);

		// Definir propiedades de los elementos
		btnRegresar.setBounds(1,1,50,20);

		txtTituloUno.setBounds(50,0,800,100);
		sub1.setBounds(90,60,200,100);
		ing1.setBounds(100,90,200,100);
		ing2.setBounds(100,120,200,100);
		ing3.setBounds(100,150,200,100);
		ing4.setBounds(100,180,200,100);
		ing5.setBounds(100,210,200,100);
		ing6.setBounds(100,240,200,100);
		sub2.setBounds(309,60,200,100);
		cant1.setBounds(300,133,100,20);
		cant2.setBounds(300,163,100,20);
		cant3.setBounds(300,193,100,20);
		cant4.setBounds(300,223,100,20);
		cant5.setBounds(300,253,100,20);
		cant6.setBounds(300,283,100,20);
		
		txtTituloDos.setBounds(800,0,800,100);
		sub3.setBounds(693,60,200,100);
		checkIng1.setBounds(700,130,150,30);
		checkIng2.setBounds(700,160,150,30);
		checkIng3.setBounds(700,190,150,30);
		checkIng4.setBounds(700,220,150,30);
		checkIng5.setBounds(700,250,150,30);
		checkIng6.setBounds(700,280,150,30);
		sub4.setBounds(965,60,200,100);
		listOrdenes.setBounds(900,130,200,100);

		labTotal.setBounds(760,320,200,100);
		boxTotal.setBounds(830,361,100,20);

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
					System.out.println("Simulación goes brrrrr");
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
		add(ing1);
		add(ing2);
		add(ing3);
		add(ing4);
		add(ing5);
		add(ing6);
		add(sub2);
		add(cant1);
		add(cant2);
		add(cant3);
		add(cant4);
		add(cant5);
		add(cant6);
		add(txtTituloDos);
		add(sub3);
		add(checkIng1);
		add(checkIng2);
		add(checkIng3);
		add(checkIng4);
		add(checkIng5);
		add(checkIng6);
		add(sub4);
		add(listOrdenes);
		add(labTotal);
		add(boxTotal);
		add(btnAgregar);
		add(btnEliminar);
		add(btnSimular);
		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        	setLayout(null);
	} // end initValues
	
}
