package com.CarRentalUser.Service;


import com.CarRentalUser.ApiConstant.LoginRespone;
import com.CarRentalUser.UserEntity.Login;


public interface LoginService {

    public LoginRespone userLogin(Login login);

    public String generateToken(String username);

    public void validateToken(String token);
}
