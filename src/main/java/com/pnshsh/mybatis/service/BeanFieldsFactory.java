package com.pnshsh.mybatis.service;

import com.pnshsh.mybatis.bean.Column;
import com.pnshsh.mybatis.common.TypeEnum;
import com.pnshsh.mybatis.common.util.FieldTransUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class BeanFieldsFactory extends ProductFactory {

    private static final String modifier = "private";
    private static final String space = " ";

    @Override
    public String create(String dbName, String table) {
        List<Column> columns = this.getColumns(dbName, table);
        StringBuilder stringBuilder = new StringBuilder();
        for (Column column : columns) {
            String field = column.getName();
            String dbType = column.getType();
            String jType = TypeEnum.getJType(dbType);

            stringBuilder.append("\n").append(modifier).append(space).append(jType).append(space)
                    .append(FieldTransUtil.trans(field,true)).append(";");
        }

        return stringBuilder.toString();
    }
}
