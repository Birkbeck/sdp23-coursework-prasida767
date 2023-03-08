package sml.instructionHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.instruction.DivideInstruction;
import sml.instruction.JumpInstruction;
import sml.insturctionHandlers.DivideInstructionHandler;
import sml.insturctionHandlers.InstructionHandler;
import sml.insturctionHandlers.JumpInstructionHandler;
import sml.register.Registers;

public class JumpInstructionHandlerTest {
    InstructionHandler addInstructionHandler = new JumpInstructionHandler();
    @Test
    void executeValid() {
        String label = "f1";
        String parameter1 = "EAX";
        String parameter2 = "f1";

        Instruction actualIns = addInstructionHandler.createInstance(label, parameter1, parameter2);
        JumpInstruction expectedResult = new JumpInstruction(label, Registers.Register.EAX, label);

        Assertions.assertEquals(expectedResult, actualIns);
    }

}
