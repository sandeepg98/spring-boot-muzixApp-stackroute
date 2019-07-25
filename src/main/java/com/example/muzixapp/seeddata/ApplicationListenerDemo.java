package com.example.muzixapp.seeddata;

import com.example.muzixapp.domain.Track;
import com.example.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListenerDemo implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        trackRepository.save(new Track(1, "Suit Punjabi", "Siraa!"));
    }
}