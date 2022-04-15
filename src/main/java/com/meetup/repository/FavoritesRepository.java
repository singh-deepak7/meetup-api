package com.meetup.repository;

import com.meetup.model.Favorites;
import com.meetup.model.Meetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

    List<Favorites> findByActiveSw(@Param("active_sw") boolean activeSw);
}
