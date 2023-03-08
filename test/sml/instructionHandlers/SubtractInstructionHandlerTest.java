package sml.instructionHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.instruction.AddInstruction;
import sml.instruction.SubtractInstruction;
import sml.insturctionHandlers.AddInstructionHandler;
import sml.insturctionHandlers.InstructionHandler;
import sml.insturctionHandlers.SubtractInstructionHandler;
import sml.register.Registers;

public class SubtractInstructionHandlerTest {
    InstructionHandler addInstructionHandler = new SubtractInstructionHandler();
    @Test
    void executeValid() {
        String label = null;
        String parameter1 = "EAX";
        String parameter2 = "EBX";

        Instruction actualIns = addInstructionHandler.createInstance(label, parameter1, parameter2);
        SubtractInstruction expectedResult = new SubtractInstruction(label, Registers.Register.EAX, Registers.Register.EBX);

        Assertions.assertEquals(expectedResult, actualIns);
    }
}
