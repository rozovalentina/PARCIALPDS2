package implementacion;
import java.util.HashMap;
import java.util.Map;

public class FabricaCanciones {
    
    public static boolean HabilitarFlyweight = true;
    private static final Map<String,Cancion> PLAY_CANCION = new HashMap<>();
    private static Long Secuencia = 0L;
    
public static Cancion CrearItem(String nombreTema, String nombreArtista) {
    if (HabilitarFlyweight && PLAY_CANCION.containsKey(nombreTema)) {
        return PLAY_CANCION.get(nombreTema);
    } else {
        Artista artista = FabricaArtistas.obtenerArtista(nombreArtista);
        Cancion playItem = new Cancion(++Secuencia, nombreTema, artista);
        PLAY_CANCION.put(nombreTema, playItem);
        return playItem;
    }
}

}
