package com.movie.iservices;

import java.util.Map;

import com.movie.entites.SeatLayout;

public interface IAdminMovieTheaterService extends  IMovieTheaterService, ISeatLayoutService {

	SeatLayout updateSeatLayoutCategory(long seatLayoutId, Map<String, String[]> seatCategory);

}
