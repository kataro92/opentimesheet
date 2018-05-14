package com.kat.opentimesheet.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "ts_emp_job", schema = "public", catalog = "open_timesheet")
public class TsEmpJobEntity {
    private int empJobId;

    @Id
    @Column(name = "emp_job_id")
    public int getEmpJobId() {
        return empJobId;
    }

    public void setEmpJobId(int empJobId) {
        this.empJobId = empJobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsEmpJobEntity that = (TsEmpJobEntity) o;
        return empJobId == that.empJobId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(empJobId);
    }
}
