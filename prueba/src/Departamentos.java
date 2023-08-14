public class Departamentos extends Vivienda {
    private int pisos;

    public Departamentos(int precio, String direccion, String contratante, int pisos) {
        super(precio, direccion, contratante);
        this.pisos = pisos;
    }

    public int getPisos() {
        return pisos;
    }

    public void setPisos(int pisos) {
        this.pisos = pisos;
    }

    @Override
    public double precioImpuestos() {
        return pisos * getPrecio();
    }

    @Override
    public String toString() {
        return super.toString() + "Departamentos [pisos=" + pisos + "]";
    }

}
