package com.example.LinteRobert406.entities;

import com.example.LinteRobert406.enums.ReportHeaderType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

@Entity
public class ReportHeader extends RepresentationModel<ReportHeader> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Enumerated(EnumType.STRING)
    private ReportHeaderType type;

    @Past(message = "Data nu trebuie să fie în viitor")
    private Date creationDate;

    private int creationUser;

    public ReportHeader() {
    }

    public ReportHeader(String title, ReportHeaderType type, Date creationDate, int creationUser) {
        this.title = title;
        this.type = type;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
    }

    public ReportHeader(int id, String title, ReportHeaderType type, Date creationDate, int creationUser) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ReportHeaderType getType() {
        return type;
    }

    public void setType(ReportHeaderType type) {
        this.type = type;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(int creationUser) {
        this.creationUser = creationUser;
    }
}
