package implementacion;

import java.util.HashMap;
import java.util.Map;

public class FabricaArtistas {
    private static final Map<String, Artista> ARTISTAS = new HashMap<>();

    public static Artista obtenerArtista(String nombre) {
        return ARTISTAS.computeIfAbsent(nombre, Artista::new);
    }
}

