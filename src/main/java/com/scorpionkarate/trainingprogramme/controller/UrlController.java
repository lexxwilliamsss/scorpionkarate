package com.scorpionkarate.trainingprogramme.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scorpionkarate.trainingprogramme.Url;
import com.scorpionkarate.trainingprogramme.repository.UrlRepository;

@RestController
@RequestMapping("/api/urls")
public class UrlController {

    @Autowired
    private UrlRepository urlRepository;

    @GetMapping
    public List<Url> getAllUrls() {
        return urlRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Url> getUrlById(@PathVariable Long id) {
        Optional<Url> url = urlRepository.findById(id);
        if (url.isPresent()) {
            return ResponseEntity.ok(url.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/folder/{folder}")
    public ResponseEntity<List<Url>> getUrlsByFolder(@PathVariable String folder) {
        List<Url> urls = urlRepository.findByFolder(folder);
        if (urls.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(urls);
        }
    }

    @PostMapping
    public ResponseEntity<Url> createUrl(@RequestBody Url url) {
        Url savedUrl = urlRepository.save(url);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUrl);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Url> updateUrl(@PathVariable Long id, @RequestBody Url urlDetails) {
        Optional<Url> urlOptional = urlRepository.findById(id);
        if (urlOptional.isPresent()) {
            Url url = urlOptional.get();
            url.setUrl(urlDetails.getUrl());
            url.setDescription(urlDetails.getDescription());
            urlRepository.save(url);
            return ResponseEntity.ok(url);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUrl(@PathVariable Long id) {
        if (urlRepository.deleteById(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    


}
