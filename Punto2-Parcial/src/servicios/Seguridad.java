package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Seguridad {

    public boolean Autorizacion(String user, String password) {
        String url = "jdbc:postgresql://db.dnaxoeupxwgfwxgbnjff.supabase.co:5432/postgres";
        String dbUser = "postgres";
        String dbPassword = "MpJmVTFIxDr39bBI";


        String query = "SELECT COUNT(*) FROM usuarios WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, user);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            int count = rs.getInt(1);

            if (count == 1) {
                System.out.println("Usuario " + user + " autorizado desde base de datos.");
                return true;
            } else {
                System.out.println("Usuario " + user + " no autorizado.");
                return false;
            }

        } catch (Exception e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
            return false;
        }
    }
}
