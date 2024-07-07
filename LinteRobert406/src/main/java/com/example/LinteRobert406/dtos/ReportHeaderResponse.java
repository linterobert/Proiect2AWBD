package com.example.LinteRobert406.dtos;

import com.example.LinteRobert406.entities.ReportHeader;
import com.example.LinteRobert406.enums.ReportHeaderType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.Length;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

public class ReportHeaderResponse extends RepresentationModel<ReportHeader> {
    private int id;
    @Length(max = 200)
    private String title;

    @Enumerated(EnumType.STRING)
    private ReportHeaderType type;

    @Past(message = "Data nu trebuie să fie în viitor")
    private Date creationDate;

    private int creationUser;

    public ReportHeaderResponse() {
    }

    public ReportHeaderResponse(int id, String title, ReportHeaderType type, Date creationDate, int creationUser) {
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
