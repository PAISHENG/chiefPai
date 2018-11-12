package tw.com.pai.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
/** reference:http://www.voidcn.com/article/p-fqcaxqpq-bam.html
 * 原文網址：https://kknews.cc/other/avnlnbv.html
 **/
@Configuration
@PropertySource("classpath:properties/jdbc.properties")
@MapperScan(basePackages="tw.com.pai.dao.mybatis", sqlSessionFactoryRef = "myBatisSqlSessionFactory")

public class MyBatisConfig {

	static final String MAPPER_LOCATION = "classpath:mappers/*.xml";

	
	@Autowired
	private Environment env;

	@Bean
	public DataSource getMyBatisDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		return dataSource;
	}
	
	@Bean
    public DataSourceTransactionManager myBatisTransactionManager() {
        return new DataSourceTransactionManager(getMyBatisDataSource());
    }
	
    @Bean
    public SqlSessionFactory myBatisSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setDataSource(getMyBatisDataSource());
//        sessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml"));
        sessionFactory.setTypeAliasesPackage("tw.com.pai.model.mybatis");//VO 放置位置

        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MyBatisConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
	
	
}
