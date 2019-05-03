package com.ark.arkbackendrediscache.configure;

import com.ark.arkbackendrediscache.model.StudentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentCacheManagerImpl implements StudentCacheManager {

    public static final String TABLE_STUDENT = "TABLE_STUDENT";
    public static final String STUDENT = "STUDENT_";

    private RedisUtil<StudentBean> redisUtil;

    @Autowired
    public StudentCacheManagerImpl(RedisUtil<StudentBean> redisUtil) {
        this.redisUtil = redisUtil ;
    }

    @Override
    public void cacheStudentDetails(StudentBean studentBean) {

        redisUtil.putMap(TABLE_STUDENT,STUDENT_+studentBean.get);
    }
}
