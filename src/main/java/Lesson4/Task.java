package Lesson4;

import java.time.LocalDate;
import java.time.LocalTime;


public class Task {
    private int id;
    private LocalDate createDate;
    private LocalTime createTime;
    private LocalDate executeDate;
    private String firstNameCreator;
    private String lastNameCreator;
    private State urgency;

    enum State {
        Low, Medium, Immediately
    }


    public Task(int id, int urgencyInt, String firstName, String lastName, LocalDate createDate, LocalTime createTime) {
        this.id = id;
        this.createDate = createDate;
        this.createTime = createTime;
        switch (urgencyInt) {
            case 1:
                this.urgency = State.Low;
                this.executeDate = this.createDate.plusDays(5);
                break;
            case 2:
                this.urgency = State.Medium;
                this.executeDate = this.createDate.plusDays(3);
                break;
            case 3:
                this.urgency = State.Immediately;
                this.executeDate = this.createDate.plusDays(1);
                break;
        }
        this.firstNameCreator = firstName;
        this.lastNameCreator = lastName;
    }

    public Task(int id, int urgencyInt, String firstName, String lastName) {
        this(id, urgencyInt, firstName, lastName, LocalDate.now(), LocalTime.now());
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public LocalDate getExecuteDate() {
        return executeDate;
    }

    public String getFirstNameCreator() {
        return firstNameCreator;
    }

    public String getLastNameCreator() {
        return lastNameCreator;
    }

    public State getUrgency() {
        return urgency;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", createDate=" + createDate +
                ", createTime=" + createTime +
                ", executeDate=" + executeDate +
                ", firstNameCreator='" + firstNameCreator + '\'' +
                ", lastNameCreator='" + lastNameCreator + '\'' +
                ", urgency=" + urgency +
                '}';
    }
}
