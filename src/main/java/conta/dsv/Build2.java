package conta.dsv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

    // Responsável por configurar os serviços do spring
    // permite o spring encontrar e carregar via IOC todos os pacotes e classes que serão necessarias na
    // implementacao e execução do projeto
@Configuration
@ComponentScan({
            // utiliza adptadores Front-end Javafx
            "conta.dsv",
            "conta.tela",
            // acessa projeto sistema (core)
            "conta.sistema",
            // adptadores backservice falsos
            "conta.adaptador"})
    public class Build2 {
        // Build 2 - Adaptador JavaFX -> Sistema <- Adaptadores Mocks
    }


