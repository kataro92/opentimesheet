package com.kat.opentimesheet.common.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ts_day", schema = "public", catalog = "open_timesheet")
public class TsDayEntity {
    private int dayId;
    private Timestamp startDatetime;
    private Timestamp endDatetime;
    private int dayOfMonth;
    private int monthOfYear;
    private int yearOfGregorian;
    private int workDay;

    @Id
    @Column(name = "day_id")
    public int getDayId() {
        return dayId;
    }

    public void setDayId(int dayId) {
        this.dayId = dayId;
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
    @Column(name = "day_of_month")
    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Basic
    @Column(name = "month_of_year")
    public int getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(int monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    @Basic
    @Column(name = "year_of_gregorian")
    public int getYearOfGregorian() {
        return yearOfGregorian;
    }

    public void setYearOfGregorian(int yearOfGregorian) {
        this.yearOfGregorian = yearOfGregorian;
    }

    @Basic
    @Column(name = "work_day")
    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsDayEntity that = (TsDayEntity) o;
        return dayId == that.dayId &&
                dayOfMonth == that.dayOfMonth &&
                monthOfYear == that.monthOfYear &&
                yearOfGregorian == that.yearOfGregorian &&
                workDay == that.workDay &&
                Objects.equals(startDatetime, that.startDatetime) &&
                Objects.equals(endDatetime, that.endDatetime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(dayId, startDatetime, endDatetime, dayOfMonth, monthOfYear, yearOfGregorian, workDay);
    }
}
