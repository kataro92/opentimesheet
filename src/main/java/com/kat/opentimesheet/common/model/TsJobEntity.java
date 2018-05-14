package com.kat.opentimesheet.common.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ts_job", schema = "public", catalog = "open_timesheet")
public class TsJobEntity {
    private int jobId;
    private String jobName;

    @Id
    @Column(name = "job_id")
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "job_name")
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsJobEntity that = (TsJobEntity) o;
        return jobId == that.jobId &&
                Objects.equals(jobName, that.jobName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(jobId, jobName);
    }
}
