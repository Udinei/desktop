package conta.tela;

import conta.dsv.Build2;
import conta.hml.Build3;
import conta.prd.Build4;
import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// linka o javaFX (formulario) e instancia os serviços do spring
public class AdaptadorJavaFX extends Application {

    private ApplicationContext spring; // contexto ode execução do spring


    // start o processo de acessa as dependencias
    @Override
    public void init() throws Exception {
        System.out.println("Iniciando spring");
        spring = new AnnotationConfigApplicationContext(Build2.class); // start as projetos dependentes via Classe build2
        // spring = new AnnotationConfigApplicationContext(Build3.class); // start as projetos dependentes via Classe build3
       //spring = new AnnotationConfigApplicationContext(Build4.class);
    }


    // Stage - controle visual do javaFx
    @Override
    public void start(Stage stage) throws Exception {
            var form = spring.getBean(TransferenciaFrm.class); // passa para o spring o controle do formulario
            form.mostrar(stage); // exibe o formulario
    }

    public static void main(String[] args){
        launch(args); //start o processo da adaptadora de front-end
    }
}
