package com.kat.opentimesheet.common.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "activity", schema = "public", catalog = "open_timesheet")
public class ActivityEntity {
    private int activityId;
    private String activityName;
    private int leaveOrWork;

    @Id
    @Column(name = "activity_id")
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    @Basic
    @Column(name = "activity_name")
    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    @Basic
    @Column(name = "leave_or_work")
    public int getLeaveOrWork() {
        return leaveOrWork;
    }

    public void setLeaveOrWork(int leaveOrWork) {
        this.leaveOrWork = leaveOrWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivityEntity that = (ActivityEntity) o;
        return activityId == that.activityId &&
                leaveOrWork == that.leaveOrWork &&
                Objects.equals(activityName, that.activityName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(activityId, activityName, leaveOrWork);
    }
}
