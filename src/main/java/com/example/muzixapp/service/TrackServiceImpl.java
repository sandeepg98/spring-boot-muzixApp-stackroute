package com.example.muzixapp.service;

import com.example.muzixapp.domain.Track;
import com.example.muzixapp.exceptions.TrackAlreadyExistsException;
import com.example.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService{

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository = trackRepository;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getId()))
            throw new TrackAlreadyExistsException("Track already exists");

        Track savedTrack = trackRepository.save(track);

        if(savedTrack == null)
            throw new TrackAlreadyExistsException("Track is null");

        return savedTrack;
    }

    @Override
    public Track getTrackById(int id) {
        Track track = trackRepository.findById(id).get();
        return track;
    }

    @Override
    public void deleteTrack(int id) {
        trackRepository.delete(getTrackById(id));
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(int id, String comment) {
        Optional<Track> track = trackRepository.findById(id);
        Track track1 = track.get();
        track1.setComment(comment);
        Track savedTrack = trackRepository.save(track1);
        return savedTrack;
    }

    @Override
    public List<Track> getTrackByName(String name) {
        return trackRepository.findByName(name);
    }

    @Override
    public List<Track> getTrackByNameSortByName(String name) {
        return trackRepository.findByNameSortById(name);
    }
}
