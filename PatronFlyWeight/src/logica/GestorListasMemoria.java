package logica;

import implementacion.ListaReproduccion;
import persistencia.ListaReproduccionDAO;

import java.util.LinkedHashMap;
import java.util.Map;

public class GestorListasMemoria {
    private static final int MAX_LISTAS_EN_MEMORIA = 1000;

    private static final LinkedHashMap<String, ListaReproduccion> cache =
            new LinkedHashMap<>(MAX_LISTAS_EN_MEMORIA, 0.75f, true) {
                @Override
                protected boolean removeEldestEntry(Map.Entry<String, ListaReproduccion> eldest) {
                    if (size() > MAX_LISTAS_EN_MEMORIA) {
                        new ListaReproduccionDAO().guardarLista(eldest.getValue());
                        System.out.println("Lista '" + eldest.getKey() + "' guardada en la base de datos y eliminada del cache.");
                        return true;
                    }
                    return false;
                }
            };

    public static void agregarLista(ListaReproduccion lista) {
        cache.put(lista.getNombreLista(), lista);
        System.out.println("Lista '" + lista.getNombreLista() + "' agregada al cache.");
    }

    public static ListaReproduccion obtenerLista(String nombre) {
        if (cache.containsKey(nombre)) {
            return cache.get(nombre);
        } else {
            ListaReproduccion lista = new ListaReproduccionDAO().cargarLista(nombre);
            if (lista != null) {
                agregarLista(lista);
            }
            return lista;
        }
    }

    public static int obtenerCantidadEnCache() {
        return cache.size();
    }
}
