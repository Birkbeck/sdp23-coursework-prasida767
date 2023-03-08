package sml.insturctionHandlers;

import org.springframework.stereotype.Component;
import sml.Instruction;
import sml.register.Registers;
import sml.instruction.OutputInstruction;

/* This class is responsible for creating instance of Output instruction. */
@Component(OutputInstruction.OP_CODE)
public class OutputInstructionHandler implements InstructionHandler{
    @Override
    public Instruction createInstance(String label, String parameter1, String parameter2) {
        return new OutputInstruction(label, Registers.Register.valueOf(parameter1));
    }
}
