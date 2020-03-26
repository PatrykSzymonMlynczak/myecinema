package com.wikingowie.myecinema.dtos.mappers;

import com.wikingowie.myecinema.dtos.ExampleEntityDto;
import com.wikingowie.myecinema.entities.ExampleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExampleEntityMappers {

    ExampleEntityMappers INSTANCE = Mappers.getMapper(ExampleEntityMappers.class);

    ExampleEntity mapToEntity(ExampleEntityDto exampleEntityDto);

    ExampleEntityDto mapToDto(ExampleEntity exampleEntity);
}
