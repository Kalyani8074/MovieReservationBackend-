package com.movie.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.movie.entites.Movie;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateMovieFromMovie(Movie m1, @MappingTarget Movie m2);
}
