package com.example.muzixapp.repository;

import com.example.muzixapp.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {

}
