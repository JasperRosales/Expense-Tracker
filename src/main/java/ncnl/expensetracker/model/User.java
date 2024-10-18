package ncnl.expensetracker.model;

import lombok.Data;

@Data
public class User {
    private String srcode;
    private String fullname;
    private String gsuite;
    private String password;
    private String department;
    private String role;
    private String program;

    public User(String srcode, String fullname, String gsuite, String password, String role, String department, String program) {
        this.srcode = srcode;
        this.fullname = fullname;
        this.gsuite = gsuite;
        this.password = password;
        this.role = role;
        this.department = department;
        this.program = program;
    }

    public User() {}

}
