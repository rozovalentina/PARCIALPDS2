package persistencia;

import implementacion.Cancion;
import implementacion.FabricaCanciones;
import implementacion.ListaReproduccion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListaReproduccionDAO {
        String URL = "jdbc:postgresql://db.dnaxoeupxwgfwxgbnjff.supabase.co:5432/postgres";
        String USER = "postgres";
        String PASSWORD = "MpJmVTFIxDr39bBI";


    public void guardarLista(ListaReproduccion lista) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO listas (nombre) VALUES (?) RETURNING id");
            stmt.setString(1, lista.getNombreLista());
            ResultSet rs = stmt.executeQuery();
            rs.next();
            long idLista = rs.getLong("id");

            for (Cancion cancion : lista.getCanciones()) {
                PreparedStatement songStmt = conn.prepareStatement(
                    "INSERT INTO canciones_lista (id_lista, nombre_cancion) VALUES (?, ?)");
                songStmt.setLong(1, idLista);
                songStmt.setString(2, cancion.getNombreCancion());
                songStmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ListaReproduccion cargarLista(String nombreLista) {
        ListaReproduccion lista = new ListaReproduccion(nombreLista);
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT nombre_cancion FROM canciones_lista JOIN listas l ON l.id = canciones_lista.id_lista WHERE l.nombre = ?");
            stmt.setString(1, nombreLista);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String nombreCancion = rs.getString("nombre_cancion");
                lista.addCancion(nombreCancion, "Desconocido"); // Aquí podrías mejorar para obtener el artista real.
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
