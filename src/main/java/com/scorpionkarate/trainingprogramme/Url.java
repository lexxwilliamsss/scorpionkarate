package com.scorpionkarate.trainingprogramme;

public class Url {
    private Long id;
    private String url;
    private String description;
    private String folder;

    // Constructors, getters, and setters
    public Url() {}

    public Url(Long id, String url, String folder, String description) {
        this.id = id;
        this.url = url;
        this.folder = folder;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
