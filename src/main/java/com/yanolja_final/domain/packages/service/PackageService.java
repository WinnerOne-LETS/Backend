package com.yanolja_final.domain.packages.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yanolja_final.domain.packages.dto.response.PackageScheduleResponse;
import com.yanolja_final.domain.packages.entity.Hashtag;
import com.yanolja_final.domain.packages.entity.Package;
import com.yanolja_final.domain.packages.exception.PackageNotFoundException;
import com.yanolja_final.domain.packages.repository.PackageRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PackageService {

    private final PackageRepository packageRepository;
    private final ObjectMapper objectMapper;

    public Package findById(Long id) {
        return packageRepository.findById(id)
            .orElseThrow(PackageNotFoundException::new);
    }

    public Page<Package> findAll(Pageable pageable) {
        return packageRepository.findAll(pageable);
    }

    public Page<Package> findAllByViewedCount(Pageable pageable) {
        return packageRepository.findAllByOrderByViewedCountDesc(pageable);
    }

    public Page<Package> findAllByPurchasedCount(Pageable pageable) {
        return packageRepository.findAllByOrderByMonthlyPurchasedCountDesc(pageable);
    }

    public List<PackageScheduleResponse> getSchedulesById(Long packageId) {
        Package aPackage = findById(packageId);
        try {
            return List.of(
                objectMapper.readValue(aPackage.getSchedules(), PackageScheduleResponse[].class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void viewed(Package aPackage) {
        aPackage.viewed();
        packageRepository.save(aPackage);
    }

    public Page<Package> getPackagesByHashtag(Hashtag hashtag, String sortBy, Pageable pageable) {
        Sort sort = Sort.by("departureTime").ascending();
        if ("price_desc".equals(sortBy)) {
            sort = Sort.by("price").descending();
        } else if ("price_asc".equals(sortBy)) {
            sort = Sort.by("price").ascending();
        }
        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), sort);
        return packageRepository.findByHashtagsContains(hashtag, pageable);
    }
}
