package com.wikingowie.myecinema.dtos.mappers;

import com.wikingowie.myecinema.dtos.UserAccountDto;
import com.wikingowie.myecinema.entities.UserAccount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserAccountMappers {

    UserAccountMappers INSTANCE = Mappers.getMapper(UserAccountMappers.class);

    UserAccountDto mapToDto(UserAccount userAccount);

    UserAccount mapToEntity(UserAccountDto userAccountDto);
}
