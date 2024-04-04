package com.movie.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.ScheduleShow;
import com.movie.entites.Seat;
import com.movie.entites.SeatLayout;
import com.movie.entites.Show;
import com.movie.excpetion.ShowNotFoundException;
import com.movie.iservices.IAdminShowService;
import com.movie.iservices.IShowService;

@Service
public class AdminShowService implements IAdminShowService {

	@Autowired
	private IShowService showService;

	@Override
	public Show registerShow(Show show) {

		List<ScheduleShow> scheduleShows = show.getScheduleShows();
		scheduleShows.stream()                                                             // Creates seat layout to each schedule show based on the theater
		           .map((scheduleShow) -> {
			SeatLayout seatLayout = createSeatLayoutsForShow(scheduleShow.getSeatLayout());
			scheduleShow.setSeatLayout(seatLayout);
			return scheduleShow;
		}).collect(Collectors.toList());
		show.setScheduleShows(scheduleShows);
		return showService.registerShow(show);
	}	


	
	@Override
	public Show updateShow(long showId, Show show) throws ShowNotFoundException {

		return showService.updateShow(showId, show);
	}

	@Override
	public List<Show> getShowsByMovieAndDateAndCityAndLanguage(String movie, LocalDate date, String city, String language) {

		return showService.getShowsByMovieAndDateAndCityAndLanguage(movie, date, city, language);
	}



	@Override
	public List<Show> getAllShows() {
		
		return showService.getAllShows();
	}
	
	
	public SeatLayout createSeatLayoutsForShow(SeatLayout seatLayoutOfTheater) {        // Generating Seat layout for the theater

		SeatLayout seatLayout = new SeatLayout();
		seatLayout.setNumRows(seatLayoutOfTheater.getNumRows());
		seatLayout.setSeatsPerRow(seatLayoutOfTheater.getSeatsPerRow());
		List<Seat> seatsOfSeatLayout = seatLayoutOfTheater.getSeats();
		List<Seat> newSeats = seatsOfSeatLayout.stream().map((seatOfSeatLayout) -> {
			Seat seat = new Seat();
			seat.setRowNumber(seatOfSeatLayout.getRowNumber());
			seat.setColNumber(seatOfSeatLayout.getColNumber());
			seat.setSeatName(seatOfSeatLayout.getSeatName());
			seat.setSeatStatus(seatOfSeatLayout.getSeatStatus());
			seat.setSeatCategory(seatOfSeatLayout.getSeatCategory());
			seat.setPrice(seatOfSeatLayout.getPrice());

			return seat;
		}

		).collect(Collectors.toList());
		seatLayout.setSeats(newSeats);

		return seatLayout;

	}



	@Override
	public Show getById(long id) {
	
		return showService.getById(id);
	}


}
