package com.example.muzixapp.service;

import com.example.muzixapp.domain.Track;
import com.example.muzixapp.exceptions.TrackAlreadyExistsException;
import com.example.muzixapp.repository.TrackRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {

    Track track;

    //Create a mock for TrackRepository
    @Mock
    TrackRepository trackRepository;

    //Inject the mocks as dependencies into TrackServiceImpl
    @InjectMocks
    TrackServiceImpl trackService;
    List<Track> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setName("Waake");
        track.setId(101);
        track.setComment("Excellent");
        list = new ArrayList<>();
        list.add(track);
    }

    @Test
    public void saveTrackTestSuccess() throws TrackAlreadyExistsException {

        when(trackRepository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackService.saveTrack(track);
        Assert.assertEquals(track,savedTrack);

        //verify here verifies that trackRepository save method is only called once
        verify(trackRepository,times(1)).save(track);

    }

    @Test(expected = TrackAlreadyExistsException.class)
    public void saveTrackTestFailure() throws TrackAlreadyExistsException {
        when(trackRepository.save((Track) any())).thenReturn(null);
        Track savedTrack = trackService.saveTrack(track);
        System.out.println("savedTrack" + savedTrack);
        //Assert.assertEquals(track,savedTrack);

       /*doThrow(new TrackAlreadyExistException()).when(trackRepository).findById(eq(101));
       trackService.saveTrack(track);*/
    }

    @Test
    public void getAllTracks(){

        trackRepository.save(track);
        //stubbing the mock to return specific data
        when(trackRepository.findAll()).thenReturn(list);
        List<Track> trackslist = trackService.getAllTracks();
        Assert.assertEquals(list,trackslist);
    }
}