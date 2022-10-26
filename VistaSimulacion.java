import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaSimulacion extends JPanel {
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent
	
	private JButton btnPause, btnRestart, btnStop;
	private Animacion imgSimulacion;
	public Factores factores;
	public Recursos recursos;
	public ArrayList<Orden> ordenes;
	public JLabel contadorHotDogs, contadorOrdenes;

	public VistaSimulacion(JPanel parent) {
		this.parent = parent;
		initValues();
	} // end constructor

	// Método para iniciar la animación
	public void start() {
		imgSimulacion.factores = factores;
		imgSimulacion.recursos = recursos;
		imgSimulacion.ordenes = new ArrayList<Orden>(ordenes);
		Thread t1 = new Thread(imgSimulacion);
		t1.start();
		btnPause.setEnabled(true);
		btnRestart.setEnabled(false);
		btnStop.setEnabled(true);
	}

	public void verReporte() {
		btnPause.setEnabled(false);
		btnRestart.setEnabled(false);
		btnStop.setEnabled(false);
		VistaReporte reporte = (VistaReporte) parent.getComponent(4);
		reporte.recursos = recursos;
		reporte.cargarDatos();
		cl.show(parent, "VistaReporte");
	}

	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuente = new Font("Courier New", 1, 20);

        cl = (CardLayout) parent.getLayout();

		// Crear elementos
		//ordenes = new ArrayList<Orden>();
		imgSimulacion = new Animacion();
		imgSimulacion.setHorizontalTextPosition(JLabel.CENTER);
		imgSimulacion.setVerticalTextPosition(JLabel.BOTTOM);
		imgSimulacion.setFont(fuente);
		contadorHotDogs = new JLabel("Hot dogs preparados: 0", SwingConstants.CENTER);
		contadorHotDogs.setFont(fuente);
		contadorOrdenes = new JLabel("Órdenes restantes: ", SwingConstants.CENTER);
		contadorOrdenes.setFont(fuente);
		btnPause = new JButton();
		btnRestart = new JButton();
		btnStop = new JButton();

		btnRestart.setIcon(new ImageIcon("images/play.png"));
		btnPause.setIcon(new ImageIcon("images/pause.png"));
		btnStop.setIcon(new ImageIcon("images/stop.png"));

		// Definir propiedades de los elementos
		imgSimulacion.setBounds(390,50,500,400);
		contadorHotDogs.setBounds(500,450,280,25);
		contadorOrdenes.setBounds(500,475,280,25);
		btnPause.setBounds(340, 500, 200, 100);
		btnRestart.setBounds(540, 500, 200, 100);
		btnStop.setBounds(740, 500, 200, 100);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPause) {
					imgSimulacion.pausarHilo();
					btnPause.setEnabled(false);
					btnRestart.setEnabled(true);
				} // end btnPause
				if (e.getSource() == btnRestart) {
					imgSimulacion.reanudarHilo();
					btnPause.setEnabled(true);
					btnRestart.setEnabled(false);
				} // end btnRestart
				if (e.getSource() == btnStop) {
					imgSimulacion.stopHilo();
					// Mostrar mensaje de que se detuvo la simulación
					JOptionPane.showMessageDialog(null, "La simulación se detuvo. A continuación se muestra el reporte con los datos generados hasta el momento de ser detenida.");
					verReporte();
				} // end btnStop
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnPause.addActionListener(listener);
		btnRestart.addActionListener(listener);
		btnStop.addActionListener(listener);

		// Agregar elementos al panel
		add(imgSimulacion);
		add(contadorHotDogs);
		add(contadorOrdenes);
		add(btnPause);
		add(btnRestart);
		add(btnStop);

		// Propiedades del panel
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		setVisible(false);
	} // end initValues

}
