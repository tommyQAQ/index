package com.xzm.myspringboot.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderMapper {
    void deleteGenderBygenderId(@Param("genderId") Integer genderId);
}
