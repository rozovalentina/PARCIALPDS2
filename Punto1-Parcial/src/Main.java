public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO ===");

        try {
            // BASE DE DATOS
            EmployeeDBService dbService = new EmployeeDBService("jdbc:postgresql://db.dnaxoeupxwgfwxgbnjff.supabase.co:5432/postgres?user=postgres&password=MpJmVTFIxDr39bBI");
            
            EmployeeAdapter dbAdapter = new EmployeeAdapter(dbService, "db");
            Employee empDb = dbAdapter.getEmployeeByCode("E001");
            System.out.println("Desde BD: " + (empDb != null ? empDb : "No encontrado"));

            // API REST
            EmployeeAPIService apiService = new EmployeeAPIService("http://localhost:3001");
            EmployeeAdapter apiAdapter = new EmployeeAdapter(apiService, "api");
            Employee empApi = apiAdapter.getEmployeeByCode("E002");
            System.out.println("Desde API: " + (empApi != null ? empApi : "No encontrado"));

        } catch (Exception e) {
            System.err.println("Error general:");
            e.printStackTrace();
        }

        System.out.println("=== FIN ===");
    }
}
