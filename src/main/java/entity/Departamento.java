package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Departamento {
    private long id;
    private String name;
    private Collection<Empleado> empleadosById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departamento that = (Departamento) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dept")
    public Collection<Empleado> getEmpleadosById() {
        return empleadosById;
    }

    public void setEmpleadosById(Collection<Empleado> empleadosById) {
        this.empleadosById = empleadosById;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", name=" + name + '\'' +
                '}';
    }
}
