package implementacion;

public class Artista {
    private String nombre;

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Artista{" + "nombre='" + nombre + '\'' + '}';
    }
}
