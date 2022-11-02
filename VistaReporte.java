import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaReporte extends JPanel {
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent
	public Recursos recursos;
	public Factores factores;

	JLabel txtCantDogos;
	JLabel txtTiempoTotal;

	JLabel txtCantPan;
	JLabel txtCantSalchicha;
	JLabel txtCantTocino;
	JLabel txtCantTomate;
	JLabel txtCantLechuga;
	JLabel txtCantMayonesa;

	JLabel txtResiduoPan;
	JLabel txtResiduoSalchicha;
	JLabel txtResiduoTocino;
	JLabel txtResiduoTomate;
	JLabel txtResiduoLechuga;
	JLabel txtResiduoMayonesa;

	JLabel txtTiempoPan;
	JLabel txtTiempoSalchicha;
	JLabel txtTiempoTocino;
	JLabel txtTiempoTomate;
	JLabel txtTiempoLechuga;
	JLabel txtTiempoMayonesa;

	public VistaReporte(JPanel parent, Factores factores) {
		this.parent = parent;
		this.factores = factores;
		initValues();
	} // end constructor
	
	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteSubtitulo = new Font("Courier New", 1, 20);
		Font fuenteTexto = new Font("Courier New", 1, 16);
		
        cl = (CardLayout) parent.getLayout();

		// Crear elementos
		JLabel txtTitulo = new JLabel("Reporte Simulación",SwingConstants.CENTER);
		txtTitulo.setFont(fuenteTitulo);
		JLabel txtTotalD = new JLabel("Hot dogs preparados: ",SwingConstants.RIGHT);
		txtTotalD.setFont(fuenteTexto);
		txtCantDogos = new JLabel("",SwingConstants.LEFT);
		txtCantDogos.setFont(fuenteTexto);
		JLabel txtTotalT = new JLabel("Tiempo total: ",SwingConstants.LEFT);
		txtTotalT.setFont(fuenteTexto);
		txtTiempoTotal = new JLabel("",SwingConstants.LEFT);
		txtTiempoTotal.setFont(fuenteTexto);
		JLabel txtIngredientes = new JLabel("Ingredientes",SwingConstants.CENTER);
		txtIngredientes.setFont(fuenteSubtitulo);
		JLabel txtCantidad = new JLabel("Cantidad",SwingConstants.CENTER);
		txtCantidad.setFont(fuenteSubtitulo);
		JLabel txtResiduo = new JLabel("Residuo",SwingConstants.CENTER);
		txtResiduo.setFont(fuenteSubtitulo);
		JLabel txtTiempo = new JLabel("Tiempo (s)",SwingConstants.CENTER);
		txtTiempo.setFont(fuenteSubtitulo);
		JLabel txtPan = new JLabel("Pan (pza.)",SwingConstants.LEFT);
		txtPan.setFont(fuenteTexto);
		JLabel txtSalchicha = new JLabel("Salchicha (pza.)",SwingConstants.LEFT);	
		txtSalchicha.setFont(fuenteTexto);
		JLabel txtTocino = new JLabel("Tocino (pza.)",SwingConstants.LEFT);
		txtTocino.setFont(fuenteTexto);
		JLabel txtTomate = new JLabel("Tomate (g)",SwingConstants.LEFT);	
		txtTomate.setFont(fuenteTexto);
		JLabel txtLechuga = new JLabel("Lechuga (g)",SwingConstants.LEFT);
		txtLechuga.setFont(fuenteTexto);
		JLabel txtMayonesa = new JLabel("Mayonesa (g)",SwingConstants.LEFT);	
		txtMayonesa.setFont(fuenteTexto);

		txtCantPan = new JLabel("",SwingConstants.RIGHT);
		txtCantSalchicha = new JLabel("",SwingConstants.RIGHT);
		txtCantTocino = new JLabel("",SwingConstants.RIGHT);
		txtCantTomate = new JLabel("",SwingConstants.RIGHT);
		txtCantLechuga = new JLabel("",SwingConstants.RIGHT);
		txtCantMayonesa = new JLabel("",SwingConstants.RIGHT);

		txtResiduoPan = new JLabel("",SwingConstants.RIGHT);
		txtResiduoSalchicha = new JLabel("",SwingConstants.RIGHT);
		txtResiduoTocino = new JLabel("",SwingConstants.RIGHT);
		txtResiduoTomate = new JLabel("",SwingConstants.RIGHT);
		txtResiduoLechuga = new JLabel("",SwingConstants.RIGHT);
		txtResiduoMayonesa = new JLabel("",SwingConstants.RIGHT);

		txtTiempoPan = new JLabel("",SwingConstants.RIGHT);
		txtTiempoSalchicha = new JLabel("",SwingConstants.RIGHT);
		txtTiempoTocino = new JLabel("",SwingConstants.RIGHT);
		txtTiempoTomate = new JLabel("",SwingConstants.RIGHT);
		txtTiempoLechuga = new JLabel("",SwingConstants.RIGHT);
		txtTiempoMayonesa = new JLabel("",SwingConstants.RIGHT);

		JButton btnIrMenuP = new JButton("Ir al Menu Principal");

		// Definir propiedades de los elementos
		txtTotalD.setBounds(200,115,300,25);
		txtCantDogos.setBounds(550,115,100,25);
		txtTotalT.setBounds(680,115,200,25);
		txtTiempoTotal.setBounds(880,115,200,25);


		txtTitulo.setBounds(200,20,800,100);
		txtIngredientes.setBounds(300,155,200,25);
		txtPan.setBounds(300,210,200,25);
		txtSalchicha.setBounds(300,255,200,25);
		txtTocino.setBounds(300,305,200,25);
		txtTomate.setBounds(300,350,200,25);
		txtLechuga.setBounds(300,395,200,25);
		txtMayonesa.setBounds(300,440,200,25);

		txtCantidad.setBounds(550,155,100,25);
		txtCantPan.setBounds(550,210,100,25);
		txtCantSalchicha.setBounds(550,255,100,25);
		txtCantTocino.setBounds(550,305,100,25);
		txtCantTomate.setBounds(550,350,100,25);
		txtCantLechuga.setBounds(550,395,100,25);
		txtCantMayonesa.setBounds(550,440,100,25);

		txtResiduo.setBounds(700,155,100,25);
		txtResiduoPan.setBounds(700,210,100,25);
		txtResiduoSalchicha.setBounds(700,255,100,25);
		txtResiduoTocino.setBounds(700,305,100,25);
		txtResiduoTomate.setBounds(700,350,100,25);
		txtResiduoLechuga.setBounds(700,395,100,25);
		txtResiduoMayonesa.setBounds(700,440,100,25);

		txtTiempo.setBounds(850,155,200,25);
		txtTiempoPan.setBounds(850,210,100,25);
		txtTiempoSalchicha.setBounds(850,255,100,25);
		txtTiempoTocino.setBounds(850,305,100,25);
		txtTiempoTomate.setBounds(850,350,100,25);
		txtTiempoLechuga.setBounds(850,395,100,25);
		txtTiempoMayonesa.setBounds(850,440,100,25);

		btnIrMenuP.setBounds(550,600,180,25);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnIrMenuP) {
					limpiarRecursosUsados();
					cl.show(parent, "MenuPrincipal");
				} // end btnIrMenuP
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnIrMenuP.addActionListener(listener);

		// Agregar elementos al panel
		add(txtTitulo);
		add(txtTotalD);
		add(txtTotalT);
		add(txtCantDogos);
		add(txtTiempoTotal);
		add(txtIngredientes);
		add(txtCantidad);
		add(txtResiduo);
		add(txtTiempo);
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
		add(txtTiempoPan);
		add(txtTiempoSalchicha);
		add(txtTiempoTocino);
		add(txtTiempoTomate);
		add(txtTiempoLechuga);
		add(txtTiempoMayonesa);
		add(btnIrMenuP);
		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
	} // end initValues
	

	public void cargarDatos() {
		//int horas = (int) recursos.getTiempoTotal() / 3600;
		//int mins = (int) (recursos.getTiempoTotal() % 3600) / 60;
		//double segs = recursos.getTiempoTotal() % 60;

		txtCantDogos.setText(Integer.toString(recursos.getTotalHotDogs()));
		txtTiempoTotal.setText(convertirSegundos(recursos.getTiempoTotal()));

		txtCantPan.setText(Integer.toString(recursos.getPanU()));
		txtCantSalchicha.setText(Integer.toString(recursos.getSalchichaU()));
		txtCantTocino.setText(Integer.toString(recursos.getTocinoU()));
		txtCantTomate.setText(Double.toString(recursos.getTomateU()));
		txtCantLechuga.setText(Double.toString(recursos.getLechugaU()));
		txtCantMayonesa.setText(Double.toString(recursos.getMayonesaU()));

		txtResiduoPan.setText(Integer.toString(recursos.getPanD()));
		txtResiduoSalchicha.setText(Integer.toString(recursos.getSalchichaD()));
		txtResiduoTocino.setText(Integer.toString(recursos.getTocinoD()));
		txtResiduoTomate.setText(Double.toString(recursos.getTomateD()));
		txtResiduoLechuga.setText(Double.toString(recursos.getLechugaD()));
		txtResiduoMayonesa.setText(Double.toString(recursos.getMayonesaD()));

		// Se alterna entre obtener el tiempo para cada ingrediente como double y
		// convertirlo a string para mostrarlo en formato hh:mm:ss
		double t = (recursos.getPanU() * factores.getTiempoPan()) / factores.getCantPan();
		txtTiempoPan.setText(convertirSegundos(t));
		t = (recursos.getSalchichaU() * factores.getTiempoSalch()) / factores.getCantSalch();
		txtTiempoSalchicha.setText(convertirSegundos(t));
		t = (recursos.getTocinoU() * 0.0) / factores.getCantToc();
		txtTiempoTocino.setText(convertirSegundos(t));
		t = (recursos.getTomateU() * factores.getTiempoTom()) / factores.getCantTom();
		txtTiempoTomate.setText(convertirSegundos(t));
		t = (recursos.getLechugaU() * factores.getTiempoLec()) / factores.getCantLec();
		txtTiempoLechuga.setText(convertirSegundos(t));
		t = (recursos.getMayonesaU() * factores.getTiempoMayo()) / factores.getCantMayo();
		txtTiempoMayonesa.setText(convertirSegundos(t));
	}

	private String convertirSegundos(double segundos) {
		int horas = (int) segundos / 3600;
		int mins = (int) (segundos % 3600) / 60;
		double segs = segundos % 60;

		return (horas + " : " + mins + " : " + segs);
	}

	private void limpiarRecursosUsados() {
		recursos.setPanU(0);
		recursos.setSalchichaU(0);
		recursos.setTocinoU(0);
		recursos.setTomateU(0.0);
		recursos.setLechugaU(0.0);
		recursos.setMayonesaU(0.0);
		recursos.setTiempoTotal(0.0);
	}
}
