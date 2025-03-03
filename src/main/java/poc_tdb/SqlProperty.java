package poc_tdb;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ConfigurationProperties(prefix="storage.db")

public class SqlProperty {
	
	private String jdbcUrl;
	private String user;
	private String password;
	private String driverClass;
	
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String dbUser) {
		this.user = dbUser;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String dbPassword) {
		this.password = dbPassword;
	}
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(getDriverClass());
		dataSource.setUrl(getJdbcUrl());
		dataSource.setUsername(getUser());
		dataSource.setPassword(getPassword());
		
		return dataSource;
		
	}

}
