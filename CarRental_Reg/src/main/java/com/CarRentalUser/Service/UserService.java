package com.CarRentalUser.Service;




import com.CarRentalUser.Dto.UserDto;

import java.util.List;
import java.util.Map;

public interface UserService {

    public UserDto createNewUser(UserDto user);

    List<UserDto> getAllUser();

    UserDto getUserById(String id);

   // UserDto updateUser(UserDto userDto, String id);

    public UserDto updateSpecificField(String userId, Map<String, Object> fields);


}
