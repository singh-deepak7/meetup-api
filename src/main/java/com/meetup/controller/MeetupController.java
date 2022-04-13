package com.meetup.controller;

import javax.validation.Valid;

import com.meetup.exception.ResourceNotFoundException;
import com.meetup.model.Meetup;
import com.meetup.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MeetupController {

    @Autowired
    private MeetupRepository meetupRepository;

    @GetMapping("/meetup")
    public List<Meetup> getAllMeetups() {
        return meetupRepository.findAll();
    }

    @GetMapping("/meetup/{id}")
    public ResponseEntity<Meetup> getEmployeeById(@PathVariable(value = "id") Long meetupId)
            throws ResourceNotFoundException {
        Meetup meetup = meetupRepository.findById(meetupId)
                .orElseThrow(() -> new ResourceNotFoundException("Meetup not found for this id :: " + meetupId));
        return ResponseEntity.ok().body(meetup);
    }

    @PostMapping("/meetup")
    public Meetup createEmployee(@Valid @RequestBody Meetup meetup) {
        return meetupRepository.save(meetup);
    }
}
