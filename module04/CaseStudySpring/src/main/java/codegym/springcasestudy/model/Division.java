package codegym.springcasestudy.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divionId;
    private String divisionName;
    @OneToMany(mappedBy = "division", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Division() {
    }

    public Long getDivionId() {
        return divionId;
    }

    public void setDivionId(Long divionId) {
        this.divionId = divionId;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
