package implementacion;

import java.util.ArrayList;
import java.util.List;

public class ListaReproduccion {
    private String NombreLista;
    private List<Cancion> Canciones = new ArrayList<>();
    
    public ListaReproduccion(String NombreLista) {
        this.NombreLista = NombreLista;
    }

    public String getNombreLista() {
        return NombreLista;
    }

    public void setNombreLista(String NombreLista) {
        this.NombreLista = NombreLista;
    }

    public List<Cancion> getCanciones() {
        return Canciones;
    }

    public void setCanciones(List<Cancion> Canciones) {
        this.Canciones = Canciones;
    }
    
public void addCancion(String nombreCancion, String nombreArtista) {
    Canciones.add(FabricaCanciones.CrearItem(nombreCancion, nombreArtista));
}

    
    public void ImprimirLista() {
        String out = "\nPlayList > " + NombreLista;
        for (Cancion playItem : Canciones) {
            out += "\n\t" + playItem.toString();
        }
        System.out.println(out);
    }
    
    
}
