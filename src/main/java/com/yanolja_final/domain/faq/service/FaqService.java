package com.yanolja_final.domain.faq.service;

import com.yanolja_final.domain.faq.dto.request.RegisterFaqRequest;
import com.yanolja_final.domain.faq.dto.response.FaqListResponse;
import com.yanolja_final.domain.faq.dto.response.FaqResponse;
import com.yanolja_final.domain.faq.entity.Faq;
import com.yanolja_final.domain.faq.repository.FaqRepository;
import com.yanolja_final.global.util.ResponseDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public ResponseDTO<FaqResponse> registerFaq(RegisterFaqRequest request) {
        Faq faq = request.toEntity();
        Faq newFaq = faqRepository.save(faq);
        FaqResponse response = FaqResponse.fromFaq(faq);
        return ResponseDTO.okWithData(response);
    }

    public ResponseDTO<List<FaqListResponse>> getFaqList() {
        List<Faq> faqs = faqRepository.findAll();
        List<FaqListResponse> response = FaqListResponse.fromFaqs(faqs);
        return ResponseDTO.okWithData(response);
    }
}
