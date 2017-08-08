package com.xswer.giflib.data;

import com.xswer.giflib.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", 1, LocalDate.of(2015,2,13), "Chris Ramacciotti", false),
            new Gif("ben-and-mike", 2, LocalDate.of(2015,10,30), "Ben Jakuben", true),
            new Gif("book-dominos", 3, LocalDate.of(2015,9,15), "Craig Dennis", false),
            new Gif("compiler-bot", 3, LocalDate.of(2015,2,13), "Ada Lovelace", true),
            new Gif("cowboy-coder", 2, LocalDate.of(2015,2,13), "Grace Hopper", false),
            new Gif("infinite-andrew",1, LocalDate.of(2015,8,23), "Marissa Mayer", true)
    );

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public Gif findByName(String name) {
        for (Gif gif : ALL_GIFS) {
            if(gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> findByCategoryId(int id) {
        List<Gif> gifs = new ArrayList<>();
        for (Gif gif : ALL_GIFS){
            if (id == gif.getCategoryId()) {
                gifs.add(gif);
            }
        }
        return gifs;
    }

    public List<Gif> getFavoriteGifs() {
        List<Gif> favorites = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.isFavorite()) {
                favorites.add(gif);
            }
        }
        return favorites;
    }

    public List<Gif> lookForGifs(String input) {
        List<Gif> found = new ArrayList<>();
        for (Gif gif : ALL_GIFS) {
            if (gif.getName().contains(input.toLowerCase())) {
                found.add(gif);
            }
        }
        return found;
    }
}
