//package com.web1.configuartion;
//
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
//import org.mybatis.spring.SqlSessionTemplate;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@MapperScan(basePackages = "com.web1.mvc.repository")
//@EnableTransactionManagement
//public class MybatisConfiguration {
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
//
//        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource);
//
//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//        sessionFactory.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));
//
//        // 마이바티스 프로퍼티 설정
//        Properties mybatisProperties = new Properties();
//        mybatisProperties.setProperty("mapUnderscoreToCamelCase", "true"); // CamelCase 자동맵핑
//        sessionFactory.setConfigurationProperties(mybatisProperties);
//
//        return sessionFactory.getObject();
//    }
//
//    @Bean
//    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
//
//        sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
//        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
//
//        return sessionTemplate;
//    }
//}
