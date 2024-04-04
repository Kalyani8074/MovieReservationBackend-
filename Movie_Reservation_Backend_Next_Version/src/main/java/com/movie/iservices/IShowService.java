package com.movie.iservices;

import java.time.LocalDate;
import java.util.List;

import com.movie.entites.Show;
import com.movie.excpetion.ShowNotFoundException;

public interface IShowService {
	
	public Show registerShow(Show show);
	
	public Show updateShow(long showId, Show show) throws ShowNotFoundException;
	
	public List<Show> getAllShows();
	public List<Show> getShowsByMovieAndDateAndCityAndLanguage(String movie,LocalDate date,String city,String language);
	public Show getById(long id);
}
