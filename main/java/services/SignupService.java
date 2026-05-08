package services;

import models.User;
import models.dto.SignupRequestDto;
import models.dto.SignupResponseDto;
import models.mappers.UserMapper;
import repository.UserRepository;

public class SignupService {
    private final UserRepository userRepository = new UserRepository();
    private final UserMapper userMapper = new UserMapper();

    public SignupResponseDto save(SignupRequestDto signUpRequest){
//        Validimi i fushave
        try{
            this.validate(signUpRequest);

            this.validateUsername(signUpRequest.getUsername());

            String salt = HashService.generateSalt();
            String saltedPassword = HashService.generateHash(signUpRequest.getPassword(), salt);

            User user = userMapper.fromSignUpDto(signUpRequest, salt, saltedPassword);
            User createdUser = this.userRepository.create(user);

            if(createdUser == null){
                throw new Exception("User is not created successfully!");
            }

            return new SignupResponseDto(true);
        }catch (Exception e){
            return new SignupResponseDto(false, e.getMessage());
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
        User user = this.userRepository.getByUsername(username);
        if(user != null){
            throw new Exception("User with username='" + username +"' already exists!");
        }
    }
}
