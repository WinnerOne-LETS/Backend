package com.yanolja_final.domain.user.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.yanolja_final.domain.user.dto.request.EmailRequest;
import com.yanolja_final.domain.user.service.EmailService;
import com.yanolja_final.global.util.ResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/confirmation")
    public ResponseEntity<ResponseDTO<Void>> mailConfirm(@RequestBody EmailRequest emailRequest)
        throws Exception {
        emailService.sendVerificationEmail(emailRequest.getEmail());
        return ResponseEntity.ok(ResponseDTO.ok());
    }

    @GetMapping("/verify/{code}")
    public ResponseEntity<ResponseDTO<Void>> verifyEmail(@RequestParam("email") String email,
        @PathVariable("code") String code) {
        boolean isVerified = emailService.verifyEmailCode(email, code);
        if (isVerified) {
            return ResponseEntity.ok(ResponseDTO.okWithData(true));
        } else {
            return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ResponseDTO.errorWithMessage(HttpStatus.BAD_REQUEST, "이메일 인증 실패."));
        }
    }
}