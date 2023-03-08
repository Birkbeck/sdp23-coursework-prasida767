package sml.instructionHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.instruction.DivideInstruction;
import sml.instruction.MultiplyInstruction;
import sml.insturctionHandlers.MultiplyInstructionHandler;
import sml.insturctionHandlers.InstructionHandler;
import sml.register.Registers;

public class MultiplyInstructionHandlerTest {
    InstructionHandler addInstructionHandler = new MultiplyInstructionHandler();
    @Test
    void executeValid() {
        String label = null;
        String parameter1 = "EAX";
        String parameter2 = "EBX";

        Instruction actualIns = addInstructionHandler.createInstance(label, parameter1, parameter2);
        MultiplyInstruction expectedResult = new MultiplyInstruction(label, Registers.Register.EAX, Registers.Register.EBX);

        Assertions.assertEquals(expectedResult, actualIns);
    }
}
