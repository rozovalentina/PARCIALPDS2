public class EmployeeAdapter {
    private final Object service;
    private final String type;

    public EmployeeAdapter(Object service, String type) {
        this.service = service;
        this.type = type;
    }

    public Employee getEmployeeByCode(String code) throws Exception {
        if ("db".equals(type)) {
            return ((EmployeeDBService) service).findByCode(code);
        } else if ("api".equals(type)) {
            return ((EmployeeAPIService) service).getEmployeeData(code);
        }
        throw new UnsupportedOperationException("Unknown service type");
    }
}
