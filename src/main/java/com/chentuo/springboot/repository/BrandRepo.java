package com.chentuo.springboot.repository;

import com.chentuo.model.BrandInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
public interface BrandRepo extends JpaRepository<BrandInfo, String> {

}
