package com.yanolja_final.domain.user.facade;

import com.yanolja_final.domain.order.entity.Order;
import com.yanolja_final.domain.order.service.OrderService;
import com.yanolja_final.domain.packages.entity.PackageDepartureOption;
import com.yanolja_final.domain.packages.service.PackageService;
import com.yanolja_final.domain.user.dto.request.UpdateMyPageRequest;
import com.yanolja_final.domain.user.dto.request.UpdatePasswordRequest;
import com.yanolja_final.domain.user.dto.response.MyPageResponse;
import com.yanolja_final.domain.user.dto.response.UpcomingPackageResponse;
import com.yanolja_final.domain.user.entity.User;
import com.yanolja_final.domain.user.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageFacade {

    private final MyPageService myPageService;
    private final OrderService orderService;
    private final PackageService packageService;

    public MyPageResponse updateUserInfo(UpdateMyPageRequest request, Long userId) {
        MyPageResponse response = myPageService.updateUserInfo(request, userId);
        return response;
    }

    public MyPageResponse getUserInfo(Long userId) {
        MyPageResponse response = myPageService.getUserInfo(userId);
        return response;
    }

    public void updatePassword(UpdatePasswordRequest request, Long userId) {
        myPageService.updatePassword(request, userId);
    }

    public UpcomingPackageResponse getUpcomingPackage(Long userId) {
        User user = userId == null ? null : myPageService.findById(userId);
        Order userOrder = orderService.userOrderWithEarliestDeparture(userId);
        PackageDepartureOption departureOption = orderService.getPackageDepartureOption(userOrder);
        Long dday = packageService.calculateDday(departureOption);
        String departureDate = packageService.formattedDepartureDate(departureOption);
        String endDate = packageService.formattedEndDate(departureOption);

        return new UpcomingPackageResponse(
            userOrder.getAPackage().getId(),
            userOrder.getAPackage().getThumbnailImageUrl(),
            userOrder.getAPackage().getTitle(),
            dday,
            userOrder.getAPackage().getNationName(),
            departureDate,
            endDate
            );
    }
}
