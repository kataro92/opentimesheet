package com.kat.opentimesheet.common.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ts_timesheet", schema = "public", catalog = "open_timesheet")
public class TsTimesheetEntity {
    private int timesheetId;
    private int empId;
    private int depId;
    private int jobId;
    private Integer dayId;
    private Integer taskId;
    private Timestamp startDatetime;
    private Timestamp endDatetime;
    private double durationInHour;

    @Id
    @Column(name = "timesheet_id")
    public int getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }

    @Basic
    @Column(name = "emp_id")
    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "dep_id")
    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "job_id")
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "day_id")
    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    @Basic
    @Column(name = "task_id")
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    @Basic
    @Column(name = "start_datetime")
    public Timestamp getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Timestamp startDatetime) {
        this.startDatetime = startDatetime;
    }

    @Basic
    @Column(name = "end_datetime")
    public Timestamp getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(Timestamp endDatetime) {
        this.endDatetime = endDatetime;
    }

    @Basic
    @Column(name = "duration_in_hour")
    public double getDurationInHour() {
        return durationInHour;
    }

    public void setDurationInHour(double durationInHour) {
        this.durationInHour = durationInHour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsTimesheetEntity that = (TsTimesheetEntity) o;
        return timesheetId == that.timesheetId &&
                empId == that.empId &&
                depId == that.depId &&
                jobId == that.jobId &&
                Double.compare(that.durationInHour, durationInHour) == 0 &&
                Objects.equals(dayId, that.dayId) &&
                Objects.equals(taskId, that.taskId) &&
                Objects.equals(startDatetime, that.startDatetime) &&
                Objects.equals(endDatetime, that.endDatetime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(timesheetId, empId, depId, jobId, dayId, taskId, startDatetime, endDatetime, durationInHour);
    }
}
