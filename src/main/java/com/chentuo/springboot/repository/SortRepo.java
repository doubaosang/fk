package com.chentuo.springboot.repository;

import com.chentuo.model.SortInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 孟翔飞
 * @date 2019/3/28
 */
public interface SortRepo extends JpaRepository<SortInfo, String> {
}
