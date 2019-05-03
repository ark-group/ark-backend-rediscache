package com.ark.arkbackendrediscache.service;

import com.ark.arkbackendrediscache.configure.StudentCacheManager;
import org.springframework.beans.factory.annotation.Autowired;

class StudentServiceImpl implements StudentService{
    private StudentCacheManager studentCacheManager;

    @Autowired
    public StudentServiceImpl(StudentCacheManager redisCacheManager)    {
        this.studentCacheManager = studentCacheManager;
    }
    @Override
    public void cacheStudentDetails(boolean checkFlag) throws Exception {
        if(studentCacheManager.checkEmpty()) {// If cache is empty the put the data
            List<StudentsBean> students= studentDAO.getStudentList();
            students.forEach(stud->studentCacheManager.cacheStudentDetails(stud));
        }
    }
}