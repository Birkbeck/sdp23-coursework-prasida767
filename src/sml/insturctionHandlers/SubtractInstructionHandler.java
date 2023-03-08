package sml.insturctionHandlers;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.register.Registers;
import sml.instruction.SubtractInstruction;

/* This class is responsible for creating instance of Subtract instruction. */
@Component(SubtractInstruction.OP_CODE)
public class SubtractInstructionHandler implements InstructionHandler{
    @Override
    public Instruction createInstance(String label, String parameter1, String parameter2) {
        return new SubtractInstruction(label, Registers.Register.valueOf(parameter1), Registers.Register.valueOf(parameter2));
    }
}
