package com.yanolja_final.domain.packages.repository;

import com.yanolja_final.domain.packages.entity.Package;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Package, Long> {

    Page<Package> findAllByOrderByViewedCountDesc(Pageable pageable);

    Page<Package> findAllByOrderByMonthlyPurchasedCountDesc(Pageable pageable);

    List<Package> findAllByOrderByMonthlyPurchasedCountDesc();
}
