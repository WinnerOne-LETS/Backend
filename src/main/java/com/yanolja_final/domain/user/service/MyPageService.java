package com.yanolja_final.domain.user.service;

import com.yanolja_final.domain.user.dto.request.UpdateMyPageRequest;
import com.yanolja_final.domain.user.dto.request.UpdatePasswordRequest;
import com.yanolja_final.domain.user.dto.response.MyPageResponse;
import com.yanolja_final.domain.user.entity.User;
import com.yanolja_final.domain.user.exception.DuplicatedCurrentPasswordException;
import com.yanolja_final.domain.user.exception.UserNotFoundException;
import com.yanolja_final.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public MyPageResponse updateUserInfo(UpdateMyPageRequest request, Long userId) {
        User existingUser = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);
        existingUser.updateUserInfo(request.phone(), request.addr1(), request.addr2(), request.postCode());
        User user = userRepository.save(existingUser);
        MyPageResponse response = MyPageResponse.from(user);
        return response;
    }

    public MyPageResponse getUserInfo(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);
        MyPageResponse response = MyPageResponse.from(user);
        return response;
    }

    public void updatePassword(UpdatePasswordRequest request, Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(UserNotFoundException::new);
        String currentEncryptedPassword = user.getEncryptedPassword();
        String newEncryptedPassword = passwordEncoder.encode(request.password());

        if (!passwordEncoder.matches(request.password(), currentEncryptedPassword)) {
            user.updatePassword(newEncryptedPassword);
        } else {
            throw new DuplicatedCurrentPasswordException();
        }
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(UserNotFoundException::new);
    }
}
