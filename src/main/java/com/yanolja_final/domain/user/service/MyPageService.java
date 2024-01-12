package com.yanolja_final.domain.user.service;

import com.yanolja_final.domain.user.dto.request.UpdateMyPageRequest;
import com.yanolja_final.domain.user.dto.response.MyPageResponse;
import com.yanolja_final.domain.user.entity.User;
import com.yanolja_final.domain.user.exception.UserNotFoundException;
import com.yanolja_final.domain.user.repository.UserRepository;
import com.yanolja_final.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final UserRepository userRepository;

    public ResponseDTO<MyPageResponse> updateUserInfo(UpdateMyPageRequest request, Long userId) {
        User existingUser = userRepository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException());
        request.updateSelectiveInfo(existingUser);
        User user = userRepository.save(existingUser);
        MyPageResponse response = MyPageResponse.fromUser(user);
        return ResponseDTO.okWithData(response);
    }
}
