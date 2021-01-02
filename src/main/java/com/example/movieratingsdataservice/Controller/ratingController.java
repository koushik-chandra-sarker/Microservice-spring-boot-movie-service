package com.example.movieratingsdataservice.Controller;

import com.example.movieratingsdataservice.Modal.Rating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class ratingController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId){
        return new Rating(movieId,3);
    }
}
