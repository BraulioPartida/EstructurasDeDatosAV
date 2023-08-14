public class Casa extends Vivienda {
    private String numeroCasa;

    public Casa(int precio, String direccion, String contratante, String numeroCasa) {
        super(precio, direccion, contratante);
        this.numeroCasa = numeroCasa;
    }

    public String getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(String numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    @Override
    public String toString() {
        return super.toString() + "Casa [numeroCasa=" + numeroCasa + "]";
    }

}
