package com.yanolja_final.domain.user.dto.response;

public record UpcomingPackageResponse(
    Long packageId,
    String imageUrl,
    String title,
    Long dday,
    String nationName,
    String departureDate,
    String endDate
) {

}
