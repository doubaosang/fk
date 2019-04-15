package com.chentuo.springboot.repository;

import com.chentuo.model.OrgInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepo extends JpaRepository<OrgInfo, String> {
}
