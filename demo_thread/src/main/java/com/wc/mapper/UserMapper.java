package com.wc.mapper;

import com.wc.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @author: wangcheng
 * @date: 2019/12/9
 * @description
 * @version: 1.0
 */
@Repository
public interface UserMapper {

    User queryById(Integer id);
}
