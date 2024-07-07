package com.example.LinteRobert406.dtos;

import com.example.LinteRobert406.enums.ReportHeaderType;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

public class PostReportHeader {
    @NotBlank
    @Length(max = 200)
    private String title;
    @NotBlank
    @Enumerated(EnumType.STRING)
    private ReportHeaderType type;
    @NotBlank
    @Past(message = "Data nu trebuie să fie în viitor")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date creationDate;
    @NotNull
    @NotBlank
    @Positive
    private int creationUser;

    public PostReportHeader() {
    }

    public PostReportHeader(String title, ReportHeaderType type, Date creationDate, int creationUser) {
        this.title = title;
        this.type = type;
        this.creationDate = creationDate;
        this.creationUser = creationUser;
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
