package sml.instructionHandlers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.instruction.DivideInstruction;
import sml.instruction.MoveInstruction;
import sml.insturctionHandlers.DivideInstructionHandler;
import sml.insturctionHandlers.InstructionHandler;
import sml.insturctionHandlers.MoveInstructionHandler;
import sml.register.Registers;

public class MoveInstructionHandlerTest {
    InstructionHandler addInstructionHandler = new MoveInstructionHandler();
    @Test
    void executeValid() {
        String label = null;
        String parameter1 = "EAX";
        String parameter2 = "10";

        Instruction actualIns = addInstructionHandler.createInstance(label, parameter1, parameter2);
        MoveInstruction expectedResult = new MoveInstruction(label, Registers.Register.EAX, Integer.valueOf(parameter2));

        Assertions.assertEquals(expectedResult, actualIns);
    }

}
