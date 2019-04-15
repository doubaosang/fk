package com.chentuo.springboot.repository;

import com.chentuo.model.NoticeInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 孟翔飞
 * @date 2019/3/25
 */
public interface NoticeRepo extends JpaRepository<NoticeInfo, String > {
}
