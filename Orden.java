public class Orden {
    public boolean salchicha;
    public boolean tocino;
    public boolean tomate;
    public boolean lechuga;
    public boolean mayonesa;
    public int cantidad;

    public Orden(boolean salchicha, boolean tocino, boolean tomate, boolean lechuga, boolean mayonesa, int cantidad) {
        this.salchicha = salchicha;
        this.tocino = tocino;
        this.tomate = tomate;
        this.lechuga = lechuga;
        this.mayonesa = mayonesa;
        this.cantidad = cantidad;
    }
	
	@Override
    public String toString() {
        String orden = "";
        
        if (salchicha) orden += "Salc ";
        if (tocino) orden += "Toc ";
        if (tomate) orden += "Tom ";
        if (lechuga) orden += "Lec ";
        if (mayonesa) orden += "May ";
        orden += "x " + cantidad;
        
        return orden;
    }
    
}
