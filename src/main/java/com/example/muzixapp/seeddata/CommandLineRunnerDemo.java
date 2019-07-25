package com.example.muzixapp.seeddata;

import com.example.muzixapp.domain.Track;
import com.example.muzixapp.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerDemo implements CommandLineRunner {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(2, "Prada", "Attt!!!!"));
    }
}