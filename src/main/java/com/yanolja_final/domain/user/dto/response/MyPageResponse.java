package com.yanolja_final.domain.user.dto.response;

import com.yanolja_final.domain.user.entity.User;

public record MyPageResponse(
    String email,
    String username,
    String phone,
    String addr1,
    String addr2,
    String postCode
) {
    public static MyPageResponse fromUser(User user) {
        return new MyPageResponse(
          user.getEmail(),
          user.getUsername(),
          user.getPhoneNumber(),
          user.getAddr1(),
          user.getAddr2(),
          user.getPostCode()
        );
    }
}
