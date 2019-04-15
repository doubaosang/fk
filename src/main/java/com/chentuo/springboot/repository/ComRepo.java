package com.chentuo.springboot.repository;

import com.chentuo.model.ComInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
public interface ComRepo extends JpaRepository<ComInfo, String> {
}
