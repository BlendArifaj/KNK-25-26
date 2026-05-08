package services;

import models.dto.SignupRequestDto;
import models.dto.SignupResponseDto;

public class SignupService {

    public SignupResponseDto save(SignupRequestDto signUpRequest){
//        Validimi i fushave
        try{
            this.validate(signUpRequest);

            this.validateUsername(signUpRequest.getUsername());
        }catch (Exception e){

        }
    }

    private void validate(SignupRequestDto signupRequest) throws Exception{
        if(signupRequest.getFullName().isEmpty() ||
                signupRequest.getEmail().isEmpty() ||
                signupRequest.getUsername().isEmpty() ||
                signupRequest.getPassword().isEmpty() ||
                signupRequest.getConfirmPassword().isEmpty()){
            throw new Exception("Fields cannot be empty!");
        }

        if(!signupRequest.getPassword().equals(
                signupRequest.getConfirmPassword()
        )){
            throw new Exception("Password doesnt match confirm password!");
        }

//        ...
    }

    private void validateUsername(String username) throws Exception{

    }
}
