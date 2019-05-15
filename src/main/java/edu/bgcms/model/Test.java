package edu.bgcms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Test {
    private Integer id;

    private LocalDate date;

    private LocalDateTime datetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}