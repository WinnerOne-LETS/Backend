package com.yanolja_final.domain.user.controller;

import com.yanolja_final.domain.user.dto.request.UpdateMyPageRequest;
import com.yanolja_final.domain.user.dto.request.UpdatePasswordRequest;
import com.yanolja_final.domain.user.dto.response.MyPageResponse;
import com.yanolja_final.domain.user.dto.response.UpcomingPackageResponse;
import com.yanolja_final.domain.user.facade.MyPageFacade;
import com.yanolja_final.global.config.argumentresolver.LoginedUserId;
import com.yanolja_final.global.util.ResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
        MyPageResponse response = myPageFacade.updateUserInfo(request, userId);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseDTO<MyPageResponse>> getUserInfo(
        @LoginedUserId Long userId
    ) {
        MyPageResponse response = myPageFacade.getUserInfo(userId);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }

    @PutMapping("/password")
    public ResponseEntity<ResponseDTO<Void>> updatePassword(
        @RequestBody UpdatePasswordRequest request, @LoginedUserId Long userId
    ) {
        myPageFacade.updatePassword(request, userId);
        return ResponseEntity.ok(ResponseDTO.ok());
    }

    @GetMapping("/upcoming-package")
    public ResponseEntity<ResponseDTO<UpcomingPackageResponse>> getUpcomingPackage(@LoginedUserId Long userId) {
        UpcomingPackageResponse response = myPageFacade.getUpcomingPackage(userId);
        return ResponseEntity.ok(ResponseDTO.okWithData(response));
    }
}
