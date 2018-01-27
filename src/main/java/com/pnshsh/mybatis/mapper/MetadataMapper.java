package com.pnshsh.mybatis.mapper;

import com.pnshsh.mybatis.bean.Column;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;
import java.util.Map;

public interface MetadataMapper {
    @Select("show databases")
    List<String> queryDatabases();

    @Select("show tables from ${dbName}")
    List<String> queryTables(@Param("dbName") String dbName);

    @Select("select COLUMN_NAME as name, DATA_TYPE as type from information_schema.columns where table_schema = #{dbName} and table_name = #{table}")
    @ResultType(Column.class)
    List<Column> queryColumns(@Param("dbName") String dbName, @Param("table") String table);
}
