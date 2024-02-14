package com.CarRentalUser.Controller;


import com.CarRentalUser.Exception.ResourceNotFoundException;
import com.CarRentalUser.Repository.UserRepository;
import com.CarRentalUser.UserEntity.Login;
import com.CarRentalUser.UserEntity.User;
import com.CarRentalUser.jwtConfig.JwtHelper;
import com.CarRentalUser.jwtConfig.JwtResponce;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {

//    @Autowired
//    LoginService loginService;

    @Autowired
    private AuthenticationManager authenticationManager;


//    @PostMapping("/token")
//    public String getToken(@RequestBody Login login) {
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));
//        if (authenticate.isAuthenticated()) {
//            return loginService.generateToken(login.getUserName());
//        } else {
//            throw new RuntimeException("invalid access");
//        }
//    }
//
//    @GetMapping("/validate")
//    public String validateToken(@RequestParam("token") String token) {
//        loginService.validateToken(token);
//        return "Token is valid";
//    }


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @PostMapping("/")
    public ResponseEntity<Map<String,Object> > login(@RequestBody Login request) {

        this.doAuthenticate(request.getEmail(), request.getPassword());


        /*
         If authentication succeeds, it loads the UserDetails for the logged
         in user by calling the UserDetailsService.
         The purpose of this method is that after a user is authenticated (e.g. by validating password),
          the authentication manager can call this method to fetch the UserDetails for that now logged in user.
         */
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());

        User user= userRepository.findByEmail(request.getEmail())
                .orElseThrow(()->new ResourceNotFoundException("user","id",request.getEmail()));


        String token = this.helper.generateToken(userDetails);

        JwtResponce response = JwtResponce.builder()
                .token(token)
                .userName(userDetails.getUsername()).build();

        Map<String,Object> responceMap= new HashMap<>();
        responceMap.put("token",response);
        responceMap.put("user",user);

        return new ResponseEntity<>(responceMap, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        /*
        When Spring Security authenticates a user, it checks if the UsernamePasswordAuthenticationToken
        provided matches the username and password stored in the system.
         */
        /*
        The authentication manager takes an Authentication object such as
        UsernamePasswordAuthenticationToken containing user credentials
       "returning a fully populated Authentication object (including granted authorities) if successful"
         */

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }

}
