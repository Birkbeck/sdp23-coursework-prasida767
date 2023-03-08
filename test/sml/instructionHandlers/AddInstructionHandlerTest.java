package sml.instructionHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.instruction.AddInstruction;
import sml.insturctionHandlers.AddInstructionHandler;
import sml.insturctionHandlers.InstructionHandler;
import sml.register.Registers;

public class AddInstructionHandlerTest {
    InstructionHandler addInstructionHandler = new AddInstructionHandler();
    @Test
    void executeValid() {
        String label = null;
        String parameter1 = "EAX";
        String parameter2 = "EBX";

        Instruction actualIns = addInstructionHandler.createInstance(label, parameter1, parameter2);
        AddInstruction expectedResult = new AddInstruction(label, Registers.Register.EAX, Registers.Register.EBX);

        Assertions.assertEquals(expectedResult, actualIns);
    }
}
