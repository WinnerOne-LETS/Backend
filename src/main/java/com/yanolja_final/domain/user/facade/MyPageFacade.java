package com.yanolja_final.domain.user.facade;

import com.yanolja_final.domain.user.dto.request.UpdateMyPageRequest;
import com.yanolja_final.domain.user.dto.response.MyPageResponse;
import com.yanolja_final.domain.user.service.MyPageService;
import com.yanolja_final.global.util.ResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageFacade {

    private final MyPageService myPageService;

    public ResponseDTO<MyPageResponse> updateUserInfo(UpdateMyPageRequest request, Long userId) {
        ResponseDTO<MyPageResponse> response = myPageService.updateUserInfo(request, userId);
        return response;
    }
}
