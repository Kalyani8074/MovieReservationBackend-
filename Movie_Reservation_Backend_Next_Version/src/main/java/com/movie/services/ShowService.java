package com.movie.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.Show;
import com.movie.excpetion.ShowNotFoundException;
import com.movie.iservices.IShowService;
import com.movie.repositories.ShowRepository;

@Service
public class ShowService implements IShowService {

	@Autowired
	private ShowRepository showRepository;

	@Override
	public Show registerShow(Show show) {

		return showRepository.save(show);
	}

	public Show updateShow(long showId, Show show) throws ShowNotFoundException {

		Show existShow = showRepository.findById(showId)
				.orElseThrow(() -> new ShowNotFoundException("Show not found with id: " + showId));

		existShow = mapProperties(show, existShow);

		return showRepository.save(existShow);

	}	
	
	@Override
	public List<Show> getShowsByMovieAndDateAndCityAndLanguage(String movie, LocalDate date, String city,
			String language) {

		List<Show> shows = showRepository.findAll();

		List<Show> filteredShows = shows.stream() // It filters the show based on city and language
				.filter((show) -> show.getMovie().getMovieName().equals(movie)
						&& show.getMovieTheater().getCity().equals(city) && show.getShowLanguage().equals(language)
						&& show.getDate().compareTo(date) == 0)
				.toList();

		return filteredShows;
	}

	@Override
	public List<Show> getAllShows() {
		return showRepository.findAll();
	}

	public Show getById(long id) {
		Show show = showRepository.findById(id).get();
		System.out.println(show);
		return show;
	}
	
	 public Show mapProperties(Show newShow, Show existingShow)
	 {
		 existingShow.setDate(newShow.getDate());
		 existingShow.setShowLanguage(newShow.getShowLanguage());
		 existingShow.setMovie(newShow.getMovie());
		 existingShow.setMovieTheater(newShow.getMovieTheater());
		 existingShow.setScheduleShows(newShow.getScheduleShows());
		 
		 return existingShow;
	 }


}
