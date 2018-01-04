package com.qwt.jsc.corespring.coreannotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Wentao Qian on 1/2/2018.
 */
@Configuration//如果这个class里面没有任何@Bean，则这里可以不用@Configuration
//但是通常情况下，之所以设置这个config class，就是要在一开始让IOC Container能够创建出一系列bean以便后续使用
//比如DataSource，NamedParameterJdbcTemplate等等
@ComponentScan(basePackages = "com.qwt.jsc.corespring.coreannotations")
public class EntryPointConfig {
}
