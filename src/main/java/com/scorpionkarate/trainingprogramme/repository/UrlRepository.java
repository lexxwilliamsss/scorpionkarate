package com.scorpionkarate.trainingprogramme.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.scorpionkarate.trainingprogramme.Url;

@Repository
public class UrlRepository {
    private final List<Url> urls = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Url> findAll() {
        return urls;
    }

    public Optional<Url> findById(Long id) {
        return urls.stream().filter(url -> url.getId().equals(id)).findFirst();
    }

    public List<Url> findByFolder(String folder) {
        return urls.stream()
                .filter(url -> url.getFolder().equalsIgnoreCase(folder))
                .collect(Collectors.toList());
    }

    public Url save(Url url) {
        url.setId(counter.incrementAndGet());
        urls.add(url);
        return url;
    }

    public boolean deleteById(Long id) {
        return urls.removeIf(url -> url.getId().equals(id));
    }


}

