package com.ark.arkbackendrediscache.configure;

import com.ark.arkbackendrediscache.model.StudentBean;

public interface StudentCacheManager {

    void cacheStudentDetails(StudentBean studentBean);
}
