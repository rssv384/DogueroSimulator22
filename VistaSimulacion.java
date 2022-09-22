import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaSimulacion extends JPanel {
	private JButton btnPause, btnRestart, btnStop;
	private Animacion animacion;
	static String[] urlList1;
	// public JPanel parent; // Panel parent

	public VistaSimulacion() {
		initValues();
	} // end constructor

	// Método para iniciar la animación
	public void start() {
		Thread t1 = new Thread(animacion);
		t1.start();
		btnPause.setEnabled(true);
		btnRestart.setEnabled(false);
		btnStop.setEnabled(true);
	}

	// Método que inicializa los elementos y propiedades de la ventana
	public void initValues() {
		Font fuenteTitulo = new Font("Courier New", 1, 52);
		Font fuenteTexto = new Font("Courier New", 1, 16);

		// Crear elementos
		animacion = new Animacion("S I M");
		animacion.setFont(fuenteTitulo);
		Animacion img1 = new Animacion("imagen1");
		btnPause = new JButton("Pause");
		btnRestart = new JButton("Restart");
		btnStop = new JButton("Stop");

		urlList1 = new String[] {"images/hot-dog.png", "images/hot-dog2.png", "images/hot-dog3.png" };
		img1.urlList1 = urlList1;
		img1.y = 20;

		// Definir propiedades de los elementos
		animacion.setBounds(240, 10, 800, 400);
		btnPause.setBounds(340, 500, 200, 100);
		btnRestart.setBounds(540, 500, 200, 100);
		btnStop.setBounds(740, 500, 200, 100);
		img1.setBounds(50,60,42,42);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == btnPause) {
					animacion.pausarHilo();
					btnPause.setEnabled(false);
					btnRestart.setEnabled(true);
				} // end btnPause
				if (e.getSource() == btnRestart) {
					animacion.reanudarHilo();
					btnPause.setEnabled(true);
					btnRestart.setEnabled(false);
				} // end btnRestart
				if (e.getSource() == btnStop) {
					animacion.stopHilo();
					btnPause.setEnabled(false);
					btnRestart.setEnabled(false);
					btnStop.setEnabled(false);
				} // end btnStop
			} // end actionPerformed
		};

		// Agregar ActionListener a los botones
		btnPause.addActionListener(listener);
		btnRestart.addActionListener(listener);
		btnStop.addActionListener(listener);

		// Agregar elementos al panel
		add(animacion);
		add(btnPause);
		add(btnRestart);
		add(btnStop);
		//add(img1);

		// Propiedades del panel
		setPreferredSize(new Dimension(1280, 720));
		setLayout(null);
		setVisible(false);
		Color fondo = new Color(130,130,130);
		setBackground(fondo);
	} // end initValues

}
