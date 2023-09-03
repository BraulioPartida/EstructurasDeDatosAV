public class Peliculas implements Comparable<Peliculas> {
    private int clave, anio;
    private String titulo;

    public Peliculas(int clave, int anio, String titulo) {
        this.clave = clave;
        this.anio = anio;
        this.titulo = titulo;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String toString() {
        return clave + ", " + anio + ", " + titulo;
    }

    @Override
    public int compareTo(Peliculas o) {
        return this.clave - o.clave;
    }

}
