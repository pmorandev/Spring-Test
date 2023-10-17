package com.pmoran.spring.torre.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorMessageDTO implements BaseDTO {

    @JsonProperty("status")
    private int status;

    @JsonProperty("issue")
    private String issue;

    @JsonProperty("date")
    private String date;

    public ErrorMessageDTO(int status, String issue, String date) {
        this.status = status;
        this.issue = issue;
        this.date = date;
    }

    public ErrorMessageDTO() {
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public String getIssue() {
        return issue;
    }

    public String getDate() {
        return date;
    }

}
