import java.sql.*;

public class EmployeeDBService {
    private final String url;

    public EmployeeDBService(String url) {
        this.url = url;
    }

    public Employee findByCode(String code) throws Exception {
        Class.forName("org.postgresql.Driver");
        try (Connection conn = DriverManager.getConnection(url)) {
            String query = "SELECT code, name, position FROM employees WHERE code = ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, code);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        return new Employee(rs.getString(1), rs.getString(2), rs.getString(3));
                    }
                }
            }
        }
        return null;
    }
}
