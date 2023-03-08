package sml.insturctionHandlers;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.register.Registers;
import sml.instruction.MultiplyInstruction;

/* This class is responsible for creating instance of Multiply instruction. */
@Component(MultiplyInstruction.OP_CODE)
public class MultiplyInstructionHandler implements InstructionHandler {
    @Override
    public Instruction createInstance(String label, String parameter1, String parameter2) {
        return new MultiplyInstruction(label, Registers.Register.valueOf(parameter1), Registers.Register.valueOf(parameter2));
    }
}
