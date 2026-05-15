package services;

import models.User;
import models.dto.ResetPasswordRequestDto;
import models.dto.ResetPasswordResponseDto;
import repository.UserRepository;

public class ResetPasswordService {

    private final UserRepository userRepository = new UserRepository();

    public ResetPasswordResponseDto reset(ResetPasswordRequestDto resetPassword){
        try{
            this.validate(resetPassword);
            this.validateNewPassword(resetPassword.getUsername(), resetPassword.getSecurityPin(), resetPassword.getNewPassword());

            User user = this.userRepository.getByUsername(resetPassword.getUsername());
            String newSaltedHash = HashService.generateHash(resetPassword.getNewPassword(), user.getSalt());
            user.setSaltedHash(newSaltedHash);
            this.userRepository.update(user);
            return new ResetPasswordResponseDto(true);
        }catch (Exception e){
            return new ResetPasswordResponseDto(false, e.getMessage());
        }
    }

    private void validate(ResetPasswordRequestDto resetPassword) throws Exception{
        if(
                resetPassword.getUsername().isEmpty() ||
                        resetPassword.getSecurityPin().isEmpty() ||
                        resetPassword.getNewPassword().isEmpty() ||
                        resetPassword.getConfirmPassword().isEmpty()
        ){
            throw new Exception("Fields cannot be empty!");
        }

        if(!resetPassword.getNewPassword().equals(
                resetPassword.getNewPassword()
        )){
            throw new Exception("New password doesnt match confirm password");
        }
    }

    private void validateNewPassword(String username, String securityPin, String password) throws Exception{
        User user = this.userRepository.getByUsername(username);
        if(user == null){
            throw new Exception("User doesnt exists!");
        }

        if(!user.getSecurityPin().equals(securityPin)){
            throw new Exception("Security pin doesnt match!");
        }

        if(HashService.validatePassword(password, user.getSalt(), user.getSaltedHash())){
            throw new Exception("New password is same as old password");
        }
    }
}
