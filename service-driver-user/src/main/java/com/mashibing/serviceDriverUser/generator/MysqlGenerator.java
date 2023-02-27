package com.mashibing.serviceDriverUser.generator;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码自动类
 */
public class MysqlGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-driver-user?characterEncoding=utf-8&serverTimezone=GMT%2B8",
                "root","root")
                .globalConfig(builder -> {
                    builder.author("晁鹏飞").fileOverride().outputDir("D:\\lhy_file\\Study_Java\\workSpace\\online-taxi-public\\service-driver-user\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.mashibing.serviceDriverUser").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "D:\\lhy_file\\Study_Java\\workSpace\\online-taxi-public\\service-driver-user\\src\\main\\java\\com\\mashibing\\serviceDriverUser\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("driver_user_work_status");

                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
