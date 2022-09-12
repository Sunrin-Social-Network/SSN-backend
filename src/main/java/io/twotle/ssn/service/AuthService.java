package io.twotle.ssn.service;

import io.twotle.ssn.component.CustomException;
import io.twotle.ssn.component.ExceptionCode;
import io.twotle.ssn.dto.EmailDTO;
import io.twotle.ssn.dto.RegisterDTO;
import io.twotle.ssn.entity.User;
import io.twotle.ssn.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private PasswordEncoder bCryptPasswordEncoder;

    public User signUp(RegisterDTO registerDTO) throws CustomException{
        if(this.isEmailAvaliable(registerDTO.getEmail())) {
            throw new CustomException(ExceptionCode.ALREADY_REGISTERED);
        }
        User newUser = registerDTO.toUserEntity();
        newUser.hashPassword(bCryptPasswordEncoder);
        return this.userRepository.save(newUser);
    }

    public boolean isEmailAvailable(EmailDTO emailDTO) {
        Optional<User> byEmail = this.userRepository.findByEmail(emailDTO.getEmail());
        return !byEmail.isEmpty();
    }
    private boolean isEmailAvaliable(String email) {
        Optional<User> byEmail = this.userRepository.findByEmail(email);
        return !byEmail.isEmpty();
    }

}
