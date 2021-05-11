package com.jetco.demo.utils;

import com.baomidou.mybatisplus.generator.config.querys.DMQuery;

public class MyDMQuery extends DMQuery {
    private int flag = 1;
    @Override
    public String tableName() {
        if (flag == 1) {
            flag++;
            // 有歧义的列名[TABLE_NAME] 解决方案
            return "T1.TABLE_NAME";
        } else {
            // 列无效 解决方案
            return "TABLE_NAME";
        }
    }
}
