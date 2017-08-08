package com.xswer.giflib.controller;

import com.xswer.giflib.data.GifRepository;
import com.xswer.giflib.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.net.www.content.image.gif;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;


    @RequestMapping("/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String favorites(ModelMap modelMap) {
        List<Gif> gifs = gifRepository.getFavoriteGifs();
        modelMap.put("gifs", gifs);
        return "favorites";
    }

    @RequestMapping(value = "/search")
    public String results(@RequestParam("q") String query, ModelMap modelMap) {
        List<Gif> gifs = gifRepository.lookForGifs(query);
        modelMap.put("gifs", gifs);
        return "results";
    }
}
