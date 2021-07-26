package entity;

import javax.persistence.*;

@Entity
@NamedQuery(name = "Empleado.ByDept", query = "SELECT e FROM Empleado e WHERE e.dept.name= ?1")
public class Empleado {
    private long id;
    private String firstName;
    private String lastName;
    private Departamento dept;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empleado empleado = (Empleado) o;

        if (id != empleado.id) return false;
        if (firstName != null ? !firstName.equals(empleado.firstName) : empleado.firstName != null) return false;
        if (lastName != null ? !lastName.equals(empleado.lastName) : empleado.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    public Departamento getDept() {
        return dept;
    }

    public void setDept(Departamento departamentoByDepartmentId) {
        this.dept = departamentoByDepartmentId;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dept=" + dept +
                '}';
    }
}
