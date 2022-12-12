package conta.prd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

// Responsável por configurar os serviços do spring
// permite o spring encontrar e carregar via IOC todos os pacotes e classes que serão necessarias na
// implementacao e execução do projeto
@Configuration
@EnableTransactionManagement // sobe o controle transacional do spring
@ComponentScan({
        // adptadores front-end javafx
        "conta.prd",
        "conta.tela",
        // core do sistema
        "conta.sistema",
        // adptadores real
        "conta.servicos.repositorio"})
public class Build4 {
    // Build 4 - Adaptador JavaFX -> Sistema <- Adaptadores Base de dados Real em producao
    // em producao sera utilizado bd em arquivo no disco local
    @Bean
    public DataSource dataSource() {
        var ds = new SimpleDriverDataSource();
        ds.setDriverClass(org.hsqldb.jdbcDriver.class);
        ds.setUrl("jdbc:hsqldb:file:E:/workspace-dev/hexagonal/base/");
        ds.setUsername("SA");
        ds.setPassword("1234");
        return ds;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    // spring controla toda transação de bd
    @Bean
    public DataSourceTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }
}


