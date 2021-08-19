package com.example.demo;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private String title;
    private int length;
    private int trackNumber;

    @ManyToOne
    public Album album;

    public Song(){


    }
    public Song(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public Song(String title, int length, Album album) {
        this.title = title;
        this.length = length;
        this.album = album;
    }

    public Song(String title, int length, int trackNumber, Album album) {
        this.title = title;
        this.length = length;
        this.album = album;
        this.trackNumber = trackNumber;
    }
    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }
}
