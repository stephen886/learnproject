package com.learn.system;

import com.learn.system.bean.Person;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringCloudApplication
@ComponentScan(basePackages = {"com.learn"})
@MapperScan("com.learn.mapper")
public class ApplicationRunner {
    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(ApplicationRunner.class, args);

        String[] names = applicationContext.getBeanNamesForType(Person.class);

        System.out.println(Arrays.toString(names));

        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n"+
                "88     888888    db    88\"\"Yb 88b 88          88\"\"Yb 88\"\"Yb  dP\"Yb   88888 888888  dP\"\"b8 888888 \n" +
                "88     88__     dPYb   88__dP 88Yb88 ________ 88__dP 88__dP dP   Yb     88 88__   dP   `\"   88   \n" +
                "88  .o 88\"\"    dP__Yb  88\"Yb  88 Y88 \"\"\"\"\"\"\"\" 88\"\"\"  88\"Yb  Yb   dP o.  88 88\"\"   Yb        88   \n" +
                "88ood8 888888 dP\"\"\"\"Yb 88  Yb 88  Y8          88     88  Yb  YbodP  \"bodP' 888888  YboodP   88   \n");
    }
}
