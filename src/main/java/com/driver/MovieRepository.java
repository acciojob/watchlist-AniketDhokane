package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        // your code here
        movieMap.put(movie.getName(),movie);

    }

    public void saveDirector(Director director){
        // your code here
        directorMap.put(director.getName(),director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            // your code here

            if (directorMovieMapping.containsKey(director)) {
                List<String> list= directorMovieMapping.get(director);
                list.add(movie);
                directorMovieMapping.put(director,list);
            }
            else{
                List<String> list= new ArrayList<>();
                list.add(movie);
                directorMovieMapping.put(director,list);

            }




        }
    }

    public Movie findMovie(String movie){
        // your code here

        Movie movie1=movieMap.get(movie);
        return movie1;
    }

    public Director findDirector(String director){
        // your code here
        Director director1=directorMap.get(director);

        return director1;
    }

    public List<String> findMoviesFromDirector(String director){
        // your code here
        List<String> stringList=directorMovieMapping.get(director);
        return stringList;
    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
        // your code here
      List<String> list=findMoviesFromDirector(director);
        for (String s : list){
            if(movieMap.containsKey(s)) {
                movieMap.remove(s);
            }
        }
       directorMap.remove(director);

    }

    public void deleteAllDirector(){
        // your code here
        List<String> list=findAllMovies();
        for (String s : list){
            directorMovieMapping.remove(s);
        }
        movieMap.clear();
        directorMap.clear();

    }
}