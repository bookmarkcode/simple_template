package com.mylesoft.crm.configuration;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/***
 *
 */
@Configuration
@MapperScan(basePackages = "com.mylesoft.crm.mapper", sqlSessionTemplateRef = "mylecrmdbSqlSessionTemplate")
public class MylecrmdbDataSourceConfig {

	@Autowired
	private MylecrmdbDataSourceSetting mylecrmdbDataSourceSetting;

	@Bean(name = "mylecrmdbDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.mylecrmdb")
	public DataSource dataSource() throws Exception {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(mylecrmdbDataSourceSetting.getDriverClassName());
		dataSource.setUrl(mylecrmdbDataSourceSetting.getUrl());
		dataSource.setUsername(mylecrmdbDataSourceSetting.getUsername());
		dataSource.setPassword(mylecrmdbDataSourceSetting.getPassword());
		dataSource.setInitialSize(mylecrmdbDataSourceSetting.getInitialSize());
		dataSource.setMinIdle(mylecrmdbDataSourceSetting.getMinIdle());
		dataSource.setMaxActive(mylecrmdbDataSourceSetting.getMaxActive());
		dataSource.setMaxWait(mylecrmdbDataSourceSetting.getMaxWait());
		dataSource.setTimeBetweenEvictionRunsMillis(mylecrmdbDataSourceSetting.getTimeBetweenEvictionRunsMillis());
		dataSource.setMinEvictableIdleTimeMillis(mylecrmdbDataSourceSetting.getMinEvictableIdleTimeMillis());
		String validationQuery = mylecrmdbDataSourceSetting.getValidationQuery();
		if (validationQuery != null && !"".equals(validationQuery)) {
			dataSource.setValidationQuery(validationQuery);
		}
		dataSource.setTestWhileIdle(mylecrmdbDataSourceSetting.isTestWhileIdle());
		dataSource.setTestOnBorrow(mylecrmdbDataSourceSetting.isTestOnBorrow());
		dataSource.setTestOnReturn(mylecrmdbDataSourceSetting.isTestOnReturn());

		return dataSource;
	}

	@Bean(name = "mylecrmdbSqlSessionFactory")
	@Primary
	public SqlSessionFactory testSqlSessionFactory(@Qualifier("mylecrmdbDataSource") DataSource dataSource)
			throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/*.xml"));
		return bean.getObject();
	}

	/*
	@Bean(name = "mylecrmdbTransactionManager")
	@Primary
	public DataSourceTransactionManager testTransactionManager(@Qualifier("fftdbDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
	*/

	@Bean(name = "mylecrmdbSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate testSqlSessionTemplate(
			@Qualifier("mylecrmdbSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
