import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VistaSimulacion extends JPanel {
	private JButton btnPause, btnRestart, btnStop;
	private Animacion animacion;
	//public JPanel parent; // Panel parent
	
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
		btnPause = new JButton("Pause");
        btnRestart = new JButton("Restart");
        btnStop = new JButton("Stop");

		// Definir propiedades de los elementos
		animacion.setBounds(240,10,800,400);
		btnPause.setBounds(340,500,200,100);
		btnRestart.setBounds(540,500,200,100);
		btnStop.setBounds(740,500,200,100);		

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
		
		// Propiedades del panel
		setPreferredSize(new Dimension(1280,720));
        setLayout(null);
		setVisible(false);
	} // end initValues
	
}