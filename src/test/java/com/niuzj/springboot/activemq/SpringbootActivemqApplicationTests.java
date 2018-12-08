package com.niuzj.springboot.activemq;

import com.niuzj.activemq.BeanConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BeanConfig.class})
public class SpringbootActivemqApplicationTests {

    @Test
    public void contextLoads() {
    }

}
