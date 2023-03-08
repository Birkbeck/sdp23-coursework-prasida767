package sml.instructionHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.instruction.DivideInstruction;
import sml.instruction.OutputInstruction;
import sml.insturctionHandlers.DivideInstructionHandler;
import sml.insturctionHandlers.InstructionHandler;
import sml.insturctionHandlers.OutputInstructionHandler;
import sml.register.Registers;

public class OutputInstructionHandlerTest {

    InstructionHandler addInstructionHandler = new OutputInstructionHandler();
    @Test
    void executeValid() {
        String label = null;
        String parameter1 = "EAX";
        String parameter2 = "EBX";

        Instruction actualIns = addInstructionHandler.createInstance(label, parameter1, parameter2);
        OutputInstruction expectedResult = new OutputInstruction(label, Registers.Register.EAX);

        Assertions.assertEquals(expectedResult, actualIns);
    }
}
