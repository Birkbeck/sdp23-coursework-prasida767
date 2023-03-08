package sml.instructionUtilities;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sml.insturctionHandlers.InstructionHandler;

/* Represents a singleton class.
* Class is responsible for extracting all the beans that were registered in the InstructionBeanConfiguration class.
* If beans of instructions that are not available or not registered are requested, then exception is thrown by getInstruction method.
* Only bean extraction is done, independent of bean creation.
* */
public final class InstructionBeanUtils {

    private static final InstructionBeanUtils instance = new InstructionBeanUtils();

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(InstructionBeanConfiguration.class);

    public InstructionHandler getInstruction(String opcode) {
        try {
            return (InstructionHandler) applicationContext.getBean(opcode);
        } catch (BeansException e) {
            throw new RuntimeException("Instruction " + opcode + " is not available");
        }
    }

    public static InstructionBeanUtils getInstance(){
           return instance;
    }

}
