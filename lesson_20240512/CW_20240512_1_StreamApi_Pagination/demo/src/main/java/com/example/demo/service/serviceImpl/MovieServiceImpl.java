package com.example.demo.service.serviceImpl;

import com.example.demo.models.Movie;
import com.example.demo.models.MovieResponse;
import com.example.demo.models.ResponseMovieApi;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${movie.url}")
    private String baseUrl;

    @Value("${movie.api.key}")
    private String apiKey;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public MovieResponse getAllByTitle(String title, int page, int size) {

        String url = baseUrl + "?apikey=" + apiKey + "&s=" + title + "&page=";

        ResponseEntity<ResponseMovieApi> response = restTemplate.getForEntity(url + 1, ResponseMovieApi.class);
        MovieResponse movieResponse = new MovieResponse();

        if (response.getStatusCode().is2xxSuccessful()) {
            List<Movie> arr = new ArrayList<>();
            ResponseMovieApi result = response.getBody();

            // цикл для первой страницы
            for (int i = 0; i < result.Search.size(); i++) {
                arr.add(result.Search.get(i));
            }

            int totalResult = Integer.parseInt(result.totalResults);  //97
            int mSize = (int) Math.ceil(totalResult / 10.0);

            // цикл для последующих страниц
            for (int i = 2; i <= mSize; i++) {
                System.out.println("Request => " + i);
                response = restTemplate.getForEntity(url + i, ResponseMovieApi.class);

                if (response.getStatusCode().is2xxSuccessful() && result != null && result.Search != null) {
                    result = response.getBody();


                    for (int j = 0; j < result.Search.size(); j++) {
//                        System.out.println(result.Search.get(j).getTitle());
                        arr.add(result.Search.get(j));
                    }
                }
            }

            int totalPages = (int) Math.ceil(totalResult / (double) size);

            arr = arr.stream().skip(size*page-size).limit(size).collect(Collectors.toList());

            movieResponse.setMovies(arr);
            movieResponse.setCurrentPage(page);
            movieResponse.setPages(totalPages);
        }

        return movieResponse;
    }
}
