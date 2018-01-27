package com.pnshsh.mybatis.service;

import com.pnshsh.mybatis.bean.Column;
import com.pnshsh.mybatis.common.TypeEnum;
import com.pnshsh.mybatis.common.util.FieldTransUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * mybatis sql块
 */
@Service
public class SqlBlockFactory extends ProductFactory {

    private static final String space = " ";

    @Override
    public String create(String dbName, String table) {

        List<Column> columns = this.getColumns(dbName, table);
        StringBuilder stringBuilder = new StringBuilder();

        for (Column column : columns) {
            String field = column.getName();

            stringBuilder.append("\n").append(field).append(" as ").append(FieldTransUtil.trans(field, true)).append(",");
        }

        return stringBuilder.toString();

    }
}
