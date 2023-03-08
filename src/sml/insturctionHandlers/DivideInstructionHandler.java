package sml.insturctionHandlers;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.register.Registers;
import sml.instruction.DivideInstruction;

/* This class is responsible for creating instance of Divide instruction. */
@Component(DivideInstruction.OP_CODE)
public class DivideInstructionHandler implements InstructionHandler{
    @Override
    public Instruction createInstance(String label, String parameter1, String parameter2) {
        return new DivideInstruction(label, Registers.Register.valueOf(parameter1), Registers.Register.valueOf(parameter2));
    }
}
