package com.example.muzixapp.service;

import com.example.muzixapp.domain.Track;
import com.example.muzixapp.exceptions.TrackAlreadyExistsException;

import java.util.List;

public interface TrackService {

    public Track saveTrack (Track track) throws TrackAlreadyExistsException;

    public Track getTrackById(int id);

    public boolean deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track updateTrack(int id,String comment);
}
