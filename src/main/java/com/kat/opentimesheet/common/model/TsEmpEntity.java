package com.kat.opentimesheet.common.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ts_emp", schema = "public", catalog = "open_timesheet")
public class TsEmpEntity {
    private int empId;
    private int empStatus;
    private String empFullname;

    @Id
    @Column(name = "emp_id")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "emp_status")
    public int getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
    }

    @Basic
    @Column(name = "emp_fullname")
    public String getEmpFullname() {
        return empFullname;
    }

    public void setEmpFullname(String empFullname) {
        this.empFullname = empFullname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsEmpEntity that = (TsEmpEntity) o;
        return empId == that.empId &&
                empStatus == that.empStatus &&
                Objects.equals(empFullname, that.empFullname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(empId, empStatus, empFullname);
    }
}
