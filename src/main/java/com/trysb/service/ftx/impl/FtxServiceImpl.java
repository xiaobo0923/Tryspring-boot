package com.trysb.service.ftx.impl;

import com.trysb.dao.mapper.FtxMapper;
import com.trysb.service.ftx.IFtxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xbo
 * @Description:
 * @Date: 2021/6/4 16:34
 */
@Service
public class FtxServiceImpl implements IFtxService {

    @Autowired
    private FtxMapper ftxDAO;

    @Override
    public String selectFtx() {
        return ftxDAO.selectById("3d464b4ea0d2491aab8a7bde74c57e95").get(0);
    }
}
