package objects;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "name")
    private String name;
    @Column(name = "BIRTH_DATE")
    private java.sql.Date birthDate;
    @Column(name = "TELEPHONE")
    private String telephoneNumber;
    @Column(name = "POSITION_ID")
    private int positionID;
    @Column(name = "SALARY")
    private double salary;

    public Employee(int id, String surname, String name, java.sql.Date birthDate, String telephoneNumber, int positionID, double salary) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.telephoneNumber = telephoneNumber;
        this.positionID = positionID;
        this.salary = salary;
    }

    public Employee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.sql.Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.sql.Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", positionID=" + positionID +
                ", salary=" + salary +
                '}';
    }
}
