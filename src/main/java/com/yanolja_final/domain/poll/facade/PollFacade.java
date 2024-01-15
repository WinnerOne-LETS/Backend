package com.yanolja_final.domain.poll.facade;

import com.yanolja_final.domain.poll.controller.request.PollAnswerRequest;
import com.yanolja_final.domain.poll.controller.response.PollResponse;
import com.yanolja_final.domain.poll.controller.response.PollResultResponse;
import com.yanolja_final.domain.poll.service.PollService;
import com.yanolja_final.domain.user.entity.User;
import com.yanolja_final.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PollFacade {

    private final UserService userService;
    private final PollService pollService;

    public void savePollAnswer(Long userId, PollAnswerRequest request) {
        User user = userService.findActiveUserById(userId);
        pollService.savePollAnswer(user, request);
    }

    public PollResponse getActivePoll(Long userId) {
        User user = userService.findActiveUserById(userId);
        return pollService.getActivePoll(user);
    }

    public PollResultResponse getActivePollResult(Long userId) {
        User user = userService.findActiveUserById(userId);
        return pollService.getActivePollResult(user);
    }
}
