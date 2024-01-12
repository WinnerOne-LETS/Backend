package com.yanolja_final.domain.user.controller;

import com.yanolja_final.domain.user.dto.request.UpdateMyPageRequest;
import com.yanolja_final.domain.user.dto.response.MyPageResponse;
import com.yanolja_final.domain.user.facade.MyPageFacade;
import com.yanolja_final.global.config.argumentresolver.LoginedUserId;
import com.yanolja_final.global.util.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/my")
@RequiredArgsConstructor
public class MyPageController {

    private final MyPageFacade myPageFacade;

    @PatchMapping("/info")
    public ResponseEntity<ResponseDTO<MyPageResponse>> updateUserInfo(
        @Valid @RequestBody UpdateMyPageRequest request,
        @LoginedUserId Long userId
    ) {
        ResponseDTO<MyPageResponse> response = myPageFacade.updateUserInfo(request, userId);
        return ResponseEntity.status(HttpStatus.valueOf(response.getCode())).body(response);
    }
}
