package com.jetco.demo.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lhw
 * @version V1.0
 * @date: 2019-10-28
 * @description: 代码生成器
 */
@Slf4j
public class CodeGenerator {

    private CodeGenerator() {
        super();
    }

    public static Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

    public static void main(String[] args) {
        // 根据要求输入相关信息，然后执行main方法，自动生成相关代码
        boolean flag = generateCode("com.jetco.demo","WF_TASK", "", "WF_");
        if (!flag) {
            log.error("=====================生成代码失败！=====================");
        }
    }

    /**
     * 连接数据库自动生成对应entity,mapper,service,serviceimpl,controller的代码
     *
     * @param parentPackage 父路径+包名 示例：com.gisinfo.sand.test
     * @param tableName 数据库表名 示例：t_test
     * @param logicDeleteFieldName 逻辑删除字段 示例：is_delete
     * @param tablePrefix 需要去除表前缀 示例：t_
     * @return 生成成功与失败的布尔值
     */
    public static boolean generateCode(String parentPackage, String tableName, String logicDeleteFieldName, String tablePrefix) {
        try {
            // 代码生成器
            AutoGenerator mpg = new AutoGenerator();
            // 规则的配置
            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            // 获取当前项目路径
            String projectPath = System.getProperty("user.dir");
            // 输出路径
            gc.setOutputDir(projectPath + "/src/main/java");
            // 全局自动添加作者
            gc.setAuthor("lhw");
            // 配置是否开启文件夹弹出
            gc.setOpen(false);
            // 配置是否覆盖之前生成的文件夹
            gc.setFileOverride(false);
            // 开启swagger注解自动生成
            gc.setSwagger2(true);
            // 配置主键策略
//            gc.setIdType(IdType.ID_WORKER_STR);
            // 配置日期相关的 ,日期类型
            gc.setDateType(DateType.ONLY_DATE);
            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            gc.setMapperName("%sMapper");
            gc.setXmlName("%sMapper");
            // 配置去掉service接口命名的“I” ，例：IUserService 变成UserService
            gc.setServiceName("%sService");
            gc.setServiceImplName("%sServiceImpl");
            gc.setControllerName("%sController");
            mpg.setGlobalConfig(gc);
            // MYSQL数据源配置
//            DataSourceConfig dsc = new DataSourceConfig();
//            dsc.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&useSSL=false&characterEncoding=utf8");
//            dsc.setDriverName("com.mysql.jdbc.Driver");
//            dsc.setUsername("lhw1994");
//            dsc.setPassword("lhw1994");
//            mpg.setDataSource(dsc);

            // ORACLE数据源配置
//            DataSourceConfig dsc = new DataSourceConfig();
//            dsc.setUrl("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = 17.16.30.9)(PORT = 1521)))(CONNECT_DATA=(SERVICE_NAME = pdb_ncgty)))");
//            dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
//            dsc.setUsername("jsxmydys");
//            dsc.setPassword("jsxmydys");
//            mpg.setDataSource(dsc);

            // 达梦数据源配置
            DataSourceConfig dsc = new MyDataSourceConfig();
            dsc.setDbType(DbType.DM);
            dsc.setSchemaName("oa");
            dsc.setUrl("jdbc:dm://17.16.28.226:5236/oa?useUnicode=true&characterEncoding=utf-8");
            dsc.setDriverName("dm.jdbc.driver.DmDriver");
            dsc.setUsername("sysdba");
            dsc.setPassword("dmserver1");
            mpg.setDataSource(dsc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            // 父路径+模块名
            pc.setParent(parentPackage);
            pc.setEntity("entity");
            pc.setMapper("mapper");
            pc.setService("service");
            pc.setServiceImpl("service.impl");
            pc.setController("controller");
            mpg.setPackageInfo(pc);

            // 自定义配置
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
//            // 如果模板引擎是 freemarker
            String templatePath = "/templates/mapper.xml.ftl";
            // 如果模板引擎是 velocity
            // String templatePath = "/templates/mapper.xml.vm";
            // 自定义输出配置
            List<FileOutConfig> focList = new ArrayList<>();
            // 自定义配置会被优先输出
            focList.add(new FileOutConfig(templatePath) {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                    return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
//             配置模板
            TemplateConfig templateConfig = new TemplateConfig();
            templateConfig.setXml(null);
            mpg.setTemplate(templateConfig);
            // 策略配置(驼峰命名与数据库下划线转换,RestController)
            StrategyConfig strategy = new StrategyConfig();
            // 数据库表生成到实体类 下划线转驼峰
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);
            // 自动生成lombok注解
            strategy.setEntityLombokModel(true);
            // 乐观锁
            strategy.setVersionFieldName("version");
            // restful api
            strategy.setRestControllerStyle(true);
            strategy.setSuperEntityColumns("id");
            strategy.setInclude(tableName.split(","));
            strategy.setEntityLombokModel(true);
            // 请求示例：/user/hello_name 而不是/user/helloName
            strategy.setControllerMappingHyphenStyle(true);
            // 配置逻辑删除字段
            strategy.setLogicDeleteFieldName(logicDeleteFieldName);
            strategy.setEntityBooleanColumnRemoveIsPrefix(true);
            // 去除表前缀，根据表名修改
            strategy.setTablePrefix(tablePrefix);
            mpg.setStrategy(strategy);
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
            // 执行生成器
            mpg.execute();
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
            return false;
        }
    }

}
