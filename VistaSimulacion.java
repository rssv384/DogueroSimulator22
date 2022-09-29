import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaSimulacion extends JPanel {
	public JPanel parent; // Panel parent
	private CardLayout cl; // LayoutManager del panel parent
	
	private JButton btnPause, btnRestart, btnStop;
	private Animacion imgSimulacion;
	public String[] urlList1 = new String[] {"images/hot-dog.png", "images/hot-dog2.png", "images/hot-dog3.png" };
	// public JPanel parent; // Panel parent

	public VistaSimulacion(JPanel parent) {
		this.parent = parent;
		initValues();
	} // end constructor

	// Método para iniciar la animación
	public void start() {
		Thread t1 = new Thread(imgSimulacion);
		t1.start();
		btnPause.setEnabled(true);
		btnRestart.setEnabled(false);
		btnStop.setEnabled(true);
	}

	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteTexto = new Font("Courier New", 1, 16);

        cl = (CardLayout) parent.getLayout();

		// Crear elementos
		imgSimulacion = new Animacion(urlList1, 60);
		btnPause = new JButton();
		btnRestart = new JButton();
		btnStop = new JButton();

		btnRestart.setIcon(new ImageIcon("images/play.png"));
		btnPause.setIcon(new ImageIcon("images/pause.png"));
		btnStop.setIcon(new ImageIcon("images/stop.png"));

		// Definir propiedades de los elementos
		btnPause.setBounds(340, 500, 200, 100);
		btnRestart.setBounds(540, 500, 200, 100);
		btnStop.setBounds(740, 500, 200, 100);
		imgSimulacion.setBounds(619,60,63,77);

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
					btnPause.setEnabled(false);
					btnRestart.setEnabled(false);
					btnStop.setEnabled(false);
					cl.show(parent, "VistaReporte");

				} // end btnStop
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnPause.addActionListener(listener);
		btnRestart.addActionListener(listener);
		btnStop.addActionListener(listener);

		// Agregar elementos al panel
		add(imgSimulacion);
		add(btnPause);
		add(btnRestart);
		add(btnStop);

		// Propiedades del panel
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		setVisible(false);
		//Color fondo = new Color(130,130,130);
		//setBackground(fondo);
	} // end initValues

}
