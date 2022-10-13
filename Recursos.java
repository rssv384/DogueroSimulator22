public class Recursos {
	
	// Recursos disponibles para preparar hot dogs
	private int panD, salchichaD, tocinoD;
	private double tomateD, lechugaD, mayonesaD;

	// Recursos utilizados en la preparación
	private int panU, salchichaU, tocinoU;
	private double tomateU, lechugaU, mayonesaU;

	private int totalHotDogs;

	// ===== SETTERS Y GETTERS =====
	// Recursos disponibles
	public void setPanD(int panDisp) { this.panD = panDisp; }
	public int getPanD() { return panD; }

	public void setSalchichaD(int salchichaDisp) { this.salchichaD = salchichaDisp; }
	public int getSalchichaD() { return salchichaD; }

	public void setTocinoD(int tocinoDisp) { this.tocinoD = tocinoDisp; }
	public int getTocinoD() { return tocinoD; }

	public void setTomateD(double tomateDisp) { this.tomateD = tomateDisp; }
	public double getTomateD() { return tomateD; }

	public void setLechugaD(double lechugaDisp) { this.lechugaD = lechugaDisp; }
	public double getLechugaD() { return lechugaD; }

	public void setMayonesaD(double mayonesaDisp) { this.mayonesaD = mayonesaDisp; }
	public double getMayonesaD() { return mayonesaD; }

	// Recursos utlizados
	public void setPanU(int panUtil) { this.panU = panUtil; }
	public int getPanU() { return panU; }

	public void setSalchichaU(int salchichaUtil) { this.salchichaU = salchichaUtil; }
	public int getSalchichaU() { return salchichaU; }

	public void setTocinoU(int tocinoUtil) { this.tocinoU = tocinoUtil; }
	public int getTocinoU() { return tocinoU; }

	public void setTomateU(Double tomateUtil) { this.tomateU = tomateUtil; }
	public Double getTomateU() { return tomateU; }

	public void setLechugaU(Double lechugaUtil) { this.lechugaU = lechugaUtil; }
	public Double getLechugaU() { return lechugaU; }

	public void setMayonesaU(Double mayonesaUtil) { this.mayonesaU = mayonesaUtil; }
	public Double getMayonesaU() { return mayonesaU; }

	public void setTotalHotDogs(int totalDogos) { this.totalHotDogs = totalDogos; }
	public int getTotalHotDogs() { return totalHotDogs; }
}
