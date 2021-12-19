package com.zdh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.zdh.dao1",
        entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanOne",
        transactionManagerRef = "platformTransactionManagerOne")
public class JpaConfig {

    @Autowired
    @Qualifier(value = "dsOne")
    DataSource dsOne;

    @Autowired
    JpaProperties jr;

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanOne(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dsOne)
                .properties(jr.getProperties())
                .packages("com.zdh.entity")
                .persistenceUnit("pu1")
                .build();
    }

    @Bean
    @Primary
    PlatformTransactionManager platformTransactionManagerOne(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = localContainerEntityManagerFactoryBeanOne(builder);
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
