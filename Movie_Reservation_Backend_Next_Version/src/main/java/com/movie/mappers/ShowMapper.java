package com.movie.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.movie.entites.Show;

@Mapper
public interface ShowMapper {

    ShowMapper INSTANCE = Mappers.getMapper(ShowMapper.class);

    @Mapping(target = "id", ignore = true)
    void updateShowFromShow(Show show, @MappingTarget Show show1);
}
