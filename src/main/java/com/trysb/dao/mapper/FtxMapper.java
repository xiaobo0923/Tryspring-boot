package com.trysb.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ProjectName: Tryspring-boot
 * @Package: com.trysb.dao
 * @ClassName: IFtxDAO
 * @Author: xbo
 * @Description:
 * @Date: 2021/4/7 15:50
 */
@Mapper
public interface FtxMapper {

    List<String> selectById(@Param("id") String id);

}
