import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class EmployeeAPIService {
    private final String baseUrl;

    public EmployeeAPIService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Employee getEmployeeData(String code) throws Exception {
        URL url = new URL(baseUrl + "/employees/" + code);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder json = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                json.append(line);
            }

            JSONObject obj = new JSONObject(json.toString());
            return new Employee(obj.getString("code"), obj.getString("name"), obj.getString("position"));
        }
    }
}
