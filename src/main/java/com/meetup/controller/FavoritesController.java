package com.meetup.controller;

import com.meetup.model.Favorites;
import com.meetup.model.Meetup;
import com.meetup.repository.FavoritesRepository;
import com.meetup.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class FavoritesController {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private MeetupRepository meetupRepository;

    @GetMapping("/favorites")
    public List<Optional<Meetup>> getAllFavorites() {
        List<Favorites>  favList = favoritesRepository.findAll();
        List<Optional<Meetup>> meetupList = new ArrayList<>();
        for(Favorites fav: favList){
            Optional<Meetup> meetup = meetupRepository.findById(fav.getMeetupId());
            meetupList.add(meetup);
        }
        return meetupList;
    }

    @PostMapping("/favorites")
    public Favorites createFavorites(@Valid @RequestBody Favorites favorites) {
        return favoritesRepository.save(favorites);
    }

}
