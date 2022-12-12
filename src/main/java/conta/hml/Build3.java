package conta.hml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
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
        "conta.hml",
        "conta.tela",
        // core do sistema
        "conta.sistema",
        // adptadores real
        "conta.servicos.repositorio"})
public class Build3 {
    // Build 3 - Adaptador JavaFX -> Sistema <- Adaptadores Real em homologacao

    // em homologação sera utilizado ainda o bd embutido
    @Bean
    public DataSource dataSource() {
        var builder = new EmbeddedDatabaseBuilder();
        var db = builder.setType(EmbeddedDatabaseType.HSQL.HSQL)
                .addScript("create-db.sql") // cria as tabelas
                .addScript("insert-hml.sql") // faz insert no tabela com dados de homologacao
                .build();
        return db;
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


