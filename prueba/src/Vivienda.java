public class Vivienda {
    private int precio;
    private String direccion, contratante;

    public Vivienda(int precio, String direccion, String contratante) {
        this.precio = precio;
        this.direccion = direccion;
        this.contratante = contratante;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContratante() {
        return contratante;
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public double precioImpuestos() {
        return precio * (1 + 0.5);
    }

    @Override
    public String toString() {
        return "Vivienda [precio=" + precio + ", direccion=" + direccion + ", contratante=" + contratante + "]";
    }

}
