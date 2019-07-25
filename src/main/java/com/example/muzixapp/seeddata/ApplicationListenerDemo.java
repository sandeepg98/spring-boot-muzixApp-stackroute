package com.example.muzixapp.seeddata;

import com.example.muzixapp.domain.Track;
import com.example.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class ApplicationListenerDemo implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private TrackRepository trackRepository;

    @Value("${id1}")
    int id1;
    @Value("${name1}")
    String name1;
    @Value("${comment1}")
    String comment1;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        trackRepository.save(new Track(id1, name1, comment1));
    }
}