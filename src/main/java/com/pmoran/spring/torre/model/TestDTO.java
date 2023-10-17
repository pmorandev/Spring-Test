package com.pmoran.spring.torre.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestDTO implements BaseDTO {
    @JsonProperty("message")
    private String message;

    @JsonProperty("date")
    private String date;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public String getDate() {
        return date;
    }

}
