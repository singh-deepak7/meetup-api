package com.meetup.controller;

import com.meetup.model.Meetup;
import com.meetup.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MeetupController {

    @Autowired
    private MeetupRepository meetupRepository;

    @GetMapping("/meetup")
    public List<Meetup> getAllEmployees() {
        return meetupRepository.findAll();
    }
}
