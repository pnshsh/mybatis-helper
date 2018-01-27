package com.pnshsh.mybatis.service;

import com.pnshsh.mybatis.bean.Column;
import com.pnshsh.mybatis.mapper.MetadataMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 抽象工程
 */
public abstract class ProductFactory {

    @Autowired
    private MetadataMapper metadataMapper;

    protected List<Column> getColumns(String dbName, String table) {
        List<Column> columns = metadataMapper.queryColumns(dbName, table);
        return columns;
    }

    abstract public String create(String dbName, String table);
}
