package com.pmoran.spring.torre.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.pmoran.spring.torre.api.ApplicationAPI;
import com.pmoran.spring.torre.model.TestDTO;

@RestController
public class ApplicationController implements ApplicationAPI {

    @Override
    public ResponseEntity<TestDTO> getTestMessageInfo() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        TestDTO testMessage = new TestDTO();
        testMessage.setMessage("This is a test message");
        testMessage.setDate(dateFormat.format(date));
        return new ResponseEntity<TestDTO>(testMessage, HttpStatus.OK);
    }
    
    

}
