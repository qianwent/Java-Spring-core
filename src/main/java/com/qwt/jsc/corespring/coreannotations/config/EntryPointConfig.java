package com.qwt.jsc.corespring.coreannotations.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Wentao Qian on 1/2/2018.
 */
@Configuration//������class����û���κ�@Bean����������Բ���@Configuration
//����ͨ������£�֮�����������config class������Ҫ��һ��ʼ��IOC Container�ܹ�������һϵ��bean�Ա����ʹ��
//����DataSource��NamedParameterJdbcTemplate�ȵ�
@ComponentScan(basePackages = "com.qwt.jsc.corespring.coreannotations")
public class EntryPointConfig {
}
