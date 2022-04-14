package com.meetup.controller;

import javax.validation.Valid;

import com.meetup.exception.ResourceNotFoundException;
import com.meetup.model.Meetup;
import com.meetup.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Meetup> getMeetupById(@PathVariable(value = "id") Long meetupId)
            throws ResourceNotFoundException {
        Meetup meetup = meetupRepository.findById(meetupId)
                .orElseThrow(() -> new ResourceNotFoundException("Meetup not found for this id :: " + meetupId));
        return ResponseEntity.ok().body(meetup);
    }

    @PostMapping("/meetup")
    public Meetup createMeetup(@Valid @RequestBody Meetup meetup) {
        return meetupRepository.save(meetup);
    }

    @PutMapping("/meetup/{id}")
    public ResponseEntity<Meetup> updateMeetup(@PathVariable(value = "id") Long meetupId,
                                                   @Valid @RequestBody Meetup meetupDetails) throws ResourceNotFoundException {
        Meetup meetup = meetupRepository.findById(meetupId)
                .orElseThrow(() -> new ResourceNotFoundException("Meetup not found for this id :: " + meetupId));

        meetup.setAddress(meetupDetails.getAddress());

     /*   set requests */
        final Meetup updatedMeetup = meetupRepository.save(meetup);
        return ResponseEntity.ok(updatedMeetup);
    }

    @DeleteMapping("/meetup/{id}")
    public Map<String, Boolean> deleteMeetup(@PathVariable(value = "id") Long meetupId)
            throws ResourceNotFoundException {
        Meetup meetup = meetupRepository.findById(meetupId)
                .orElseThrow(() -> new ResourceNotFoundException("Meetup not found for this id :: " + meetupId));

        meetupRepository.delete(meetup);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
