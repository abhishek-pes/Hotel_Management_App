package com.hotel_management.model;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eid;

    @Column(name = "employee_name")
    private String Employeename;

    @Column(name = "age")
    private Integer age;

    @Column(name = "department")
    private  String department;

    @Column(name = "salary")
    private Float salary;

    @Column(name="work_exp")
    private Integer workExp;

    public long getEid() {
        return eid;
    }

    public void setEid(long eid) {
        this.eid = eid;
    }

    public String getEmployeename() {
        return Employeename;
    }

    public void setEmployeename(String employeename) {
        Employeename = employeename;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Integer getWorkExp() {
        return workExp;
    }

    public void setWorkExp(Integer workExp) {
        this.workExp = workExp;
    }
}
