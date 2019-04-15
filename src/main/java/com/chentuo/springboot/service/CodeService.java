package com.chentuo.springboot.service;

import com.chentuo.springboot.repository.CodeRepo;
import com.chentuo.superClass.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 孟翔飞
 * @date 2019/3/29
 */
@Service
public class CodeService extends SuperService {
    @Autowired
    private CodeRepo codeRepo = null;
}
