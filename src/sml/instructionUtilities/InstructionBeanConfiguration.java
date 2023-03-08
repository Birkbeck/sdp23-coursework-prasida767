package sml.instructionUtilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sml.insturctionHandlers.*;

/* Class represents and registers all the beans that are to be instantiated for the SML program.
* Beans for Handler methods are registered in the Spring application context.
* This class can be migrated to the external XML file source to run the program without the need of compiling.
* Currently, 7 instructions are registered. Each beans method is specific to one instruction handler.
* Handlers are responsible for instantiating the insturction classes.
* NOTE: Need to add the dependency if new instruction is added in the program.
* */
@Configuration
public class InstructionBeanConfiguration {
    @Bean
    AddInstructionHandler add(){
        return new AddInstructionHandler();
    }

    @Bean
    MultiplyInstructionHandler mul(){
        return new MultiplyInstructionHandler();
    }

    @Bean
    DivideInstructionHandler div(){
        return new DivideInstructionHandler();
    }

    @Bean
    SubtractInstructionHandler sub(){
        return new SubtractInstructionHandler();
    }

    @Bean
    MoveInstructionHandler mov(){
        return new MoveInstructionHandler();
    }

    @Bean
    JumpInstructionHandler jnz(){
        return new JumpInstructionHandler();
    }

    @Bean
    OutputInstructionHandler out(){
        return new OutputInstructionHandler();
    }

}
