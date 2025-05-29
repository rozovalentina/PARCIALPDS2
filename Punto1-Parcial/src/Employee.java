public class Employee {
    private String code;
    private String name;
    private String position;

    public Employee(String code, String name, String position) {
        this.code = code;
        this.name = name;
        this.position = position;
    }

    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Position: " + position;
    }
}
