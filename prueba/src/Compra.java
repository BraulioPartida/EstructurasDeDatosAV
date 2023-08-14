public class Compra {
    public static void main(String[] args) {
        Casa casa1 = new Casa(10, "Lactea", "Perez", "117");
        Departamentos dep1 = new Departamentos(5, "Narvarte", "Martinez", 60);
        System.out.println(casa1.toString() + "\n" + casa1.precioImpuestos() + "\n");
        System.out.println(dep1.toString() + "\n" + dep1.precioImpuestos());
    }

}
