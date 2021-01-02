package com.example.moviecatalogeservice.Controller;

import com.example.moviecatalogeservice.modal.CatalogItem;
import com.example.moviecatalogeservice.modal.Movie;
import com.example.moviecatalogeservice.modal.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {



    @Autowired
    private RestTemplate restTemplate; // Bean created in application class

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId){




        List<Rating> ratings = Arrays.asList(
                new Rating("1111",4),
                new Rating("1112",3)
        );

        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getName(), "Description test",rating.getRating());
        })
                .collect(Collectors.toList());
    }
}
