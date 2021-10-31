package cn.kuaishang.mybatiesplus.codeGenerator;

import cn.kuaishang.mybatiesplus.MybatiesPlusDemoApplication;
import cn.kuaishang.mybatiesplus.service.UserService;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.builder.Mapper;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.fill.Column;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CodeGenerator {
    //数据库配置
    public static String url="jdbc:mysql://127.0.0.1:3306/mybaties-plus-demo?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&allowPublicKeyRetrieval=true";
    public static String username="root";
    public static String password="Passw0rd";

    //项目名
    public static String projectName="MybatiesPlusDemo";
    public static void main(String[] args) {
        String path =getOutPath(projectName);
        System.out.println("输出路径："+path);
        FastAutoGenerator.create(
                url,
                username,
                password)
                // 全局配置
                .globalConfig((scanner, builder) ->
                        builder.author(scanner.apply("请输入作者名称？"))
                                .fileOverride()
                        .outputDir(path)
                )
                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("请输入包名？")))

                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("请输入表名，多个英文逗号分隔？所有输入 all")))
                        .controllerBuilder()
                        .enableRestStyle()//开启生成@RestController 控制器
                        .enableHyphenStyle()//开启驼峰转连字符
                        .entityBuilder()
                        .enableLombok()//启用lombok注解
                        //.addTableFills(new Column("create_time", FieldFill.INSERT))
                        .enableActiveRecord()
                        .mapperBuilder()//结果集配置
                        .enableBaseColumnList()//生成Base_Column_List
                        .enableBaseResultMap()//生成BaseResultMap
                        .build())
                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   */
                .templateEngine(new FreemarkerTemplateEngine())

                .execute();



    }
    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }

    public static String getOutPath(String projectName) {
        String path = Objects.requireNonNull(CodeGenerator.class.getClassLoader().getResource("")).getPath();
        int index = path.indexOf(projectName);
        return "/" + path.substring(1, index) + projectName + "/src/main/java/";
    }
}
