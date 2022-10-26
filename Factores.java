	public class Factores {
	// Factores de preparación previa de ingredientes.
	private double tiempoPicarTom = 48.0; // 1 tomate o 170 g
	private double tiempoPicarLec = 127.0; // 1/4 de lechuga o 140 g
	private double tiempoEnvToc = 13.0; // 1 tira de tocino por salchicha
	private double tiempoCalSar = 120.0;
	private double tiempoCalPan = 60.0; // 1 pan
	private double tiempoFreir = 70.0; // 1 salchicha (con o sin tocino)

	// Cantidad de cada ingrediente servida en 1 hot dog
	private int cantPan = 1, cantSalch = 1, cantToc = 1; // Piezas del ingrediente
	private double cantTom = 14.0, cantLec = 22, cantMayo = 5.0; // Gramos del ingrediente

	// Tiempo (en segs.) en el que se sirven los ingredientes
	private double tiempoPan = 4.0, tiempoSalch = 4.0, tiempoTom = 4.0, tiempoLec = 4.0, tiempoMayo = 4.0;

	// GETTERS Y SETTERS

	// Tiempos preparación previa
	public double getTiempoPicarTom() { return tiempoPicarTom; }

	public double getTiempoPicarLec() { return tiempoPicarLec; }

	public double getTiempoEnvToc() { return tiempoEnvToc; }

	public double getTiempoCalSar() { return tiempoCalSar; }

	public double getTiempoCalPan() { return tiempoCalPan; }

	// Cantidades al servir
	public void setCantPan(int cPan) { this.cantPan = cPan; }
	public int getCantPan() { return cantPan; }

	public void setCantSalch(int cSalch) { this.cantSalch = cSalch; }
	public int getCantSalch() { return cantSalch; }

	public void setCantToc(int cToc) { this.cantToc = cToc; }
	public int getCantToc() { return cantToc; }

	public void setCantTom(double cTom) { this.cantTom = cTom; }
	public double getCantTom() { return cantTom; }

	public void setCantLec(double cLec) { this.cantLec = cLec; }
	public double getCantLec() { return cantLec; }

	public void setCantMayo(double cMayo) { this.cantMayo = cMayo; }
	public double getCantMayo() { return cantMayo; }

	// Tiempos para servir
	public void setTiempoPan(double tPan) { this.tiempoPan = tPan; }
	public double getTiempoPan() { return tiempoPan; }

	public void setTiempoSalch(double tSalch) { this.tiempoSalch = tSalch; }
	public double getTiempoSalch() { return tiempoSalch; }

	public void setTiempoTom(double tTom) { this.tiempoTom = tTom; }
	public double getTiempoTom() { return tiempoTom; }

	public void setTiempoLec(double tLec) { this.tiempoLec = tLec; }
	public double getTiempoLec() { return tiempoLec; }

	public void setTiempoMayo(double tMayo) { this.tiempoMayo = tMayo; }
	public double getTiempoMayo() { return tiempoMayo; }
}
