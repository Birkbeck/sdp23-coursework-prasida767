package sml.instructionHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.instruction.AddInstruction;
import sml.instruction.DivideInstruction;
import sml.insturctionHandlers.AddInstructionHandler;
import sml.insturctionHandlers.DivideInstructionHandler;
import sml.insturctionHandlers.InstructionHandler;
import sml.register.Registers;

public class DivideInstructionHandlerTest {

    InstructionHandler addInstructionHandler = new DivideInstructionHandler();
    @Test
    void executeValid() {
        String label = null;
        String parameter1 = "EAX";
        String parameter2 = "EBX";

        Instruction actualIns = addInstructionHandler.createInstance(label, parameter1, parameter2);
        DivideInstruction expectedResult = new DivideInstruction(label, Registers.Register.EAX, Registers.Register.EBX);

        Assertions.assertEquals(expectedResult, actualIns);
    }
}
