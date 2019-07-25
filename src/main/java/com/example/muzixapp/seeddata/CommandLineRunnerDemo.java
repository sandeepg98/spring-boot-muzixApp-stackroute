package com.example.muzixapp.seeddata;

import com.example.muzixapp.domain.Track;
import com.example.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Autowired
    private TrackRepository trackRepository;

    @Value("${id2}")
    int id2;
    @Value("${name2}")
    String name2;
    @Value("${comment2}")
    String comment2;

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(id2, name2, comment2));
    }
}