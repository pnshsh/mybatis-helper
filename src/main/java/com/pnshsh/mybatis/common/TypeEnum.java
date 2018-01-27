package com.pnshsh.mybatis.common;

import org.springframework.util.StringUtils;

/**
 * 字段类型枚举
 */
public enum  TypeEnum {

    TINYINT("TINYINT", "Integer"),
    SMALLINT("SMALLINT", "Integer"),
    MEDIUMINT("MEDIUMINT", "Integer"),
    INT("INT", "Integer"),
    BIGINT("BIGINT", "Long"),

    DECIMAL("DECIMAL", "BigDecimal"),
    NUMERIC("NUMERIC", "BigDecimal"),
    FLOAT("FLOAT", "Double"),
    DOUBLE("DOUBLE", "Double"),

    DATE("DATE", "Date"),
    DATETIME("DATETIME", "Date"),
    TIMESTAMP("TIMESTAMP", "Date"),

    CHAR("CHAR", "String"),
    VARCHAR("VARCHAR", "String"),
    ;

    private String dbType;
    private String jType;

    TypeEnum(String dbType, String jType) {
        this.dbType = dbType;
        this.jType = jType;
    }

    public String getDbType() {
        return dbType;
    }

    public String getjType() {
        return jType;
    }

    /**
     * 获取数据库类型对应的Java类型
     * @param dbType 数据库类型
     * @return Java类型
     */
    public static String getJType(String dbType) {
        TypeEnum[] typeEnums = TypeEnum.values();
        for (TypeEnum typeEnum : typeEnums) {
            if (typeEnum.getDbType().equalsIgnoreCase(dbType)){
                return typeEnum.getjType();
            }
        }
        return null;
    }

}
