package com.ezen.market.config;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class DBCon {
	
	//C3P0를 쓰기 위한 환경 파일??
		@Bean
		public ComboPooledDataSource dataSource() {
			ComboPooledDataSource dataSource = new ComboPooledDataSource();
			try {
				dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
			dataSource.setUser("scott1");
			dataSource.setPassword("tiger");
			dataSource.setMaxPoolSize(200);
			dataSource.setCheckoutTimeout(60000);
			dataSource.setMaxIdleTime(1800);
			dataSource.setIdleConnectionTestPeriod(600);
			return dataSource;
		}

}
