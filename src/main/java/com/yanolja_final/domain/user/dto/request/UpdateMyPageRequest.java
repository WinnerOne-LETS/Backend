package com.yanolja_final.domain.user.dto.request;

import com.yanolja_final.domain.user.entity.User;

public record UpdateMyPageRequest(
    String phone,
    String addr1,
    String addr2,
    String postCode
) {
    public void updateSelectiveInfo(User existingUser) {
        if (phone != null) {
            existingUser.setPhoneNumber(formatPhoneNumber(phone));
        }
        if (addr1 != null) {
            existingUser.setAddr1(addr1);
        }
        if (addr2 != null) {
            existingUser.setAddr2(addr2);
        }
        if (postCode != null) {
            existingUser.setPostCode(postCode);
        }
    }

    private String formatPhoneNumber(String rawPhoneNumber) {
        return rawPhoneNumber.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1-$2-$3");
    }
}
