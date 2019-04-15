package com.chentuo.springboot.repository;

import com.chentuo.model.SkuInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuRepo extends JpaRepository<SkuInfo, String> {
}
