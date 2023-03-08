package sml.insturctionHandlers;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.register.Registers;
import sml.instruction.AddInstruction;

/* This class is responsible for creating instance of AddInstruction. */
@Component(AddInstruction.OP_CODE)
public class AddInstructionHandler implements InstructionHandler {
    @Override
    public Instruction createInstance(String label, String parameter1, String parameter2) {
        return new AddInstruction(label, Registers.Register.valueOf(parameter1), Registers.Register.valueOf(parameter2));
    }
}
