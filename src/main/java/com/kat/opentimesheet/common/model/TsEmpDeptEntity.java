package com.kat.opentimesheet.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ts_emp_dept", schema = "public", catalog = "open_timesheet")
public class TsEmpDeptEntity {
    private int empDeptId;

    @Id
    @Column(name = "emp_dept_id")
    public int getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(int empDeptId) {
        this.empDeptId = empDeptId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsEmpDeptEntity that = (TsEmpDeptEntity) o;
        return empDeptId == that.empDeptId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(empDeptId);
    }
}
