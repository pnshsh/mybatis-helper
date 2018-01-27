package com.pnshsh.mybatis.controller;

import com.pnshsh.mybatis.mapper.MetadataMapper;
import com.pnshsh.mybatis.service.BeanFieldsFactory;
import com.pnshsh.mybatis.service.SqlBlockFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class MetadataController {
    private static Logger logger = LoggerFactory.getLogger(MetadataController.class);

    @Autowired
    private MetadataMapper metadataMapper;

    @Autowired
    private BeanFieldsFactory beanFieldsFactory;

    @Autowired
    private SqlBlockFactory sqlBlockFactory;

    @RequestMapping("/databases")
    public List<String> queryDatabase() {
        logger.info("查询数据库");
        List<String> databases = metadataMapper.queryDatabases();
        return databases;
    }

    @RequestMapping("/databases/{dbName}/tables")
    public List<String> queryTables(@PathVariable String dbName) {
        logger.info("查询表列表");
        List<String> tables = metadataMapper.queryTables(dbName);
        return tables;
    }

    @RequestMapping("/databases/{dbName}/tables/{table}/{product}")
    public String getBeanFields(@PathVariable(name = "dbName") String dbName, @PathVariable(name = "table") String table,
                                @PathVariable(name = "product") String product) {
        if ("bean".equals(product)) {
            return beanFieldsFactory.create(dbName, table);
        }

        if ("sql".equals(product)) {
            return sqlBlockFactory.create(dbName, table);
        }
        return null;
    }
}
