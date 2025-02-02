import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.junit.Test;

import java.util.Collections;

/**
 * @ClassName GeneratorTest
 * @Description
 * @Author qsx
 * @Date 2021/11/3 22:23
 * @Version V1.0
 **/
public class GeneratorTest {

    private final String OUTPUT_DIR = "E://xmloutput";

    @Test
    public void createXml(){
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/ssmdemo?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
                "root",
                "rootAdminpwd")
                .globalConfig(builder -> {
                    builder.fileOverride().outputDir(OUTPUT_DIR);
                })
                .packageConfig(builder -> {
                    builder.parent("com.learn")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,OUTPUT_DIR));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("user_info");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
