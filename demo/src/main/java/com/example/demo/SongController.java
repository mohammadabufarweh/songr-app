package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/songs")
    public String getSongs( Model model){
        model.addAttribute("songRepository", songRepository.findAll());
        return "songs.html";
    }
    @PostMapping("/songsadded/{id}")
    public RedirectView addSong(Model model, @RequestParam (value="title")String title ,
                                @RequestParam (value="length")int length,
                                @RequestParam (value="trackNumber")int trackNumber, @PathVariable int id){

        Song song=new Song(title,length,trackNumber,albumRepository.findById(id).get());
        songRepository.save(song);
        System.out.println("ssssssss222222222s"+id);
        return new RedirectView("/addsong/{id}");


    }
}
