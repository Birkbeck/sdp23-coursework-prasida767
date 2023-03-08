package sml.instructionUtilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sml.instruction.*;
import sml.instructionUtilities.InstructionBeanConfiguration;

public class InstructionBeanConfigurationTest {

    static ApplicationContext applicationContext;

    @BeforeAll
    static void setUp(){
         applicationContext = new AnnotationConfigApplicationContext(InstructionBeanConfiguration.class);
    }

    @AfterAll
    static void tearDown(){
        applicationContext = null;
    }

    @Test
    void additionInstructionBeanExists(){
        Assertions.assertNotNull(applicationContext.getBean(AddInstruction.OP_CODE));
    }

    @Test
    void subtractionInstructionBeanExists(){
        Assertions.assertNotNull(applicationContext.getBean(SubtractInstruction.OP_CODE));
    }

    @Test
    void multiplicationInstructionBeanExists(){
        Assertions.assertNotNull(applicationContext.getBean(MultiplyInstruction.OP_CODE));
    }
    @Test
    void divisonInstructionBeanExists(){
        Assertions.assertNotNull(applicationContext.getBean(DivideInstruction.OP_CODE));
    }

    @Test
    void jumpInstructionBeanExists(){
        Assertions.assertNotNull(applicationContext.getBean(JumpInstruction.OP_CODE));
    }

    @Test
    void moveInstructionBeanExists(){
        Assertions.assertNotNull(applicationContext.getBean(MoveInstruction.OP_CODE));
    }
}
