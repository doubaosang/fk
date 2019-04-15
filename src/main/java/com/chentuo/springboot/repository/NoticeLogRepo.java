package com.chentuo.springboot.repository;

import com.chentuo.model.NoticeLogInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeLogRepo extends JpaRepository<NoticeLogInfo, String> {
}
