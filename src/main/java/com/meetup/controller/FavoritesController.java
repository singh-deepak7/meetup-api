package com.meetup.controller;

import com.meetup.exception.ResourceNotFoundException;
import com.meetup.model.FavMeetup;
import com.meetup.model.Favorites;
import com.meetup.model.Meetup;
import com.meetup.repository.FavoritesRepository;
import com.meetup.repository.MeetupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class FavoritesController {

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Autowired
    private MeetupRepository meetupRepository;

    @GetMapping("/favorites")
    public List<Optional<FavMeetup>> getAllFavorites() {
        List<Favorites>  favList = favoritesRepository.findByActiveSw(true);
       // List<Favorites>  filteredFavList = favList.stream().filter( x -> x.isActiveSw() == true).collect(Collectors.toList());
        List<Optional<FavMeetup>> meetupList = new ArrayList<>();
        for(Favorites fav: favList){
            FavMeetup favMeetup = new FavMeetup();
            Optional<Meetup> meetup = meetupRepository.findById(fav.getMeetupId());

            favMeetup.setMeetupId(fav.getId());
            favMeetup.setId(meetup.get().getId());
            favMeetup.setAddress(meetup.get().getAddress());
            favMeetup.setImage(meetup.get().getImage());
            favMeetup.setDescription(meetup.get().getDescription());
            favMeetup.setTitle(meetup.get().getTitle());

            meetupList.add(Optional.of(favMeetup));
        }
        return meetupList;
    }

    @PostMapping("/favorites")
    public Favorites createFavorites(@Valid @RequestBody Favorites favorites) {
        return favoritesRepository.save(favorites);
    }

    @PostMapping("/favorite")
    public ResponseEntity<Favorites> updateFavorites(@Valid @RequestBody Favorites favorites) throws ResourceNotFoundException {
        Favorites favorite = favoritesRepository.findById(favorites.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Favorite not found for this id :: " + favorites.getId()));
        favorite.setMeetupId(favorite.getMeetupId());
        favorite.setActiveSw(false);
        final Favorites updatedFavorite = favoritesRepository.save(favorite);
        return ResponseEntity.ok(updatedFavorite);
    }

}
