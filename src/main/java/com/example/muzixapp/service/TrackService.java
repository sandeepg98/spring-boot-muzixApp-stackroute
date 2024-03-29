package com.example.muzixapp.service;

import com.example.muzixapp.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track);

    public Track getTrackById(int id);

    public void deleteTrack(int id);

    public List<Track> getAllTracks();

    public Track updateTrack(int id,String comment);
}
