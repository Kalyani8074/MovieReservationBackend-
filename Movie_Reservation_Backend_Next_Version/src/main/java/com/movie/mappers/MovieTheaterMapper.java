package com.movie.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.movie.entites.MovieTheater;

@Mapper
public interface MovieTheaterMapper {

    MovieTheater INSTANCE = Mappers.getMapper(MovieTheater.class);

    @Mapping(target = "id", ignore = true)
    void updateExistTheaterFromTheater(MovieTheater m1, @MappingTarget MovieTheater m2);
}
