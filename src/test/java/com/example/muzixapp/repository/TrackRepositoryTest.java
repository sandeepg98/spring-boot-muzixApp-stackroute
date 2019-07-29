package com.example.muzixapp.repository;

import com.example.muzixapp.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    Track track;

    @Before
    public void setUp() {
        track = new Track();
        track.setName("Waake");
        track.setId(101);
        track.setComment("Excellent");
    }

    @After
    public void tearDown(){
        trackRepository.deleteAll();
    }


    @Test
    public void testSaveTrack(){
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertEquals(101,fetchTrack.getId());
    }

    @Test
    public void testSaveTrackFailure(){
        Track testTrack = new Track(102, "Photo", "good");
        trackRepository.save(track);
        Track fetchTrack = trackRepository.findById(track.getId()).get();
        Assert.assertNotSame(testTrack,track);
    }

    @Test
    public void testGetAllTracks(){
        Track t = new Track(102, "Photo", "good");
        Track t1 = new Track(103, "Jimmy Choo", "excellent");
        trackRepository.save(t);
        trackRepository.save(t1);

        List<Track> list = trackRepository.findAll();
        Assert.assertEquals("Photo",list.get(0).getName());
    }

    @Test
    public void testUpdateComment(){
        trackRepository.save(track);
        track.setComment("good");
        trackRepository.save(track);
        String comment = (trackRepository.findById(101).get()).getComment();
        Assert.assertEquals("good", comment);
    }

    @Test
    public void testUpdateCommentFailure(){
        trackRepository.save(track);
        track.setComment("good");
        String comment = (trackRepository.findById(101).get()).getComment();
        Assert.assertNotEquals("good", comment);
    }
}