package sml.insturctionHandlers;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.register.Registers;
import sml.instruction.MoveInstruction;

/* This class is responsible for creating instance of Move instruction. */
@Component(MoveInstruction.OP_CODE)
public class MoveInstructionHandler implements InstructionHandler {

    @Override
    public Instruction createInstance(String label, String parameter1, String parameter2) {
        return new MoveInstruction(label, Registers.Register.valueOf(parameter1), Integer.valueOf(parameter2));
    }
}
