package com.learn.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * <p>Description: </p>
 *
 * @author xiangqing
 * @version 1.0
 * @date 2018年8月7日
 */
@Configuration
//@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class ConfigData {

	@Value("${system.file.save.encrypt.flag:null}")
	public String fileEncryptFlag;

	@Value("${system.customerinfo.table.size:0}")
	public int systemCustomerInfoSize;

	@Value("${system.transdata.savedays:0}")
	public int systemTransdataSaveDays;

	@Value("#{'${system.file.encrypt.type}'.split(',')}")
	public Set<String> encryptTypes;

	@Value("${system.file.encrypt.size}")
	public Long encryptSize;

	@Value("${system.file.encrypt.mode:normal}")
	public String encryptMode;
}
