package services;

import models.User;
import models.dto.LoginRequestDto;
import models.dto.LoginResponseDto;
import repository.UserRepository;

public class LoginService {

    private final UserRepository userRepository = new UserRepository();

    public LoginResponseDto login(LoginRequestDto loginRequest){
        LoginResponseDto response = validate(loginRequest);
        if(response != null){
            return response;
        }

        User user = this.userRepository.getByUsername(loginRequest.getUsername());

        if(user == null){
            return new LoginResponseDto(false, "Username or Password is not correct!");
        }

        if(!HashService.validatePassword(loginRequest.getPassword(), user.getSalt(), user.getSaltedHash())){
            return new LoginResponseDto(false, "Username or Password is not correct!");
        }

        return new LoginResponseDto(true);

    }

    private LoginResponseDto validate(LoginRequestDto loginRequestDto){
        if(loginRequestDto.getPassword().isEmpty() || loginRequestDto.getUsername().isEmpty()){
            return new LoginResponseDto(
                    false, "Username and Password cannot be empty!"
            );
        }

        return null;
    }
}
