package sml.insturctionHandlers;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.register.Registers;
import sml.instruction.JumpInstruction;

/* This class is responsible for creating instance of Jump instruction. */
@Component(JumpInstruction.OP_CODE)
public class JumpInstructionHandler implements InstructionHandler{
    @Override
    public Instruction createInstance(String label, String parameter1, String parameter2) {
        return new JumpInstruction(label, Registers.Register.valueOf(parameter1), String.valueOf(parameter2));
    }
}
