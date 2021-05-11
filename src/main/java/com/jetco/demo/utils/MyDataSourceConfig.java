package com.jetco.demo.utils;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.IDbQuery;
import com.baomidou.mybatisplus.generator.config.querys.*;

public class MyDataSourceConfig extends DataSourceConfig {

    @Override
    public IDbQuery getDbQuery() {
        switch(this.getDbType()) {
            case ORACLE:
                setDbQuery(new OracleQuery());
                break;
            case SQL_SERVER:
                setDbQuery(new SqlServerQuery());
                break;
            case POSTGRE_SQL:
                setDbQuery(new PostgreSqlQuery());
                break;
            case DB2:
                setDbQuery(new DB2Query());
                break;
            case MARIADB:
                setDbQuery(new MariadbQuery());
                break;
            case H2:
                setDbQuery(new H2Query());
                break;
            case SQLITE:
                setDbQuery(new SqliteQuery());
                break;
            case DM:
                // 重新指定自定义的DMQuery
                setDbQuery(new MyDMQuery());
                break;
            case KINGBASE_ES:
                setDbQuery(new KingbaseESQuery());
                break;
            default:
                setDbQuery(new MySqlQuery());
        }
        return super.getDbQuery();
    }
}
