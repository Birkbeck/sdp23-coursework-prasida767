package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.RegisterName;

import java.util.Objects;

/**
 * It outputs the values of mentioned register in the console.
 * The result register is the register, that contains the contents of output.
 * The instruction takes three parameters: a label and a destination register.
 * This class inherits from the abstract Instruction class and implements the execute method
 * to perform the output operation on the given registers in the Machine instance.
 * @author prasida767
 */


public class OutputInstruction extends Instruction {
    private final RegisterName result;

    public static final String OP_CODE = "out";

    public OutputInstruction(String label, RegisterName result) {
        super(label, OP_CODE);
        this.result = result;
    }

    @Override
    public int execute(Machine m) {
        int value1 = m.getRegisters().get(result);
        System.out.println("The content of register " + result + " is " + value1);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, result);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        OutputInstruction other = (OutputInstruction) obj;
        return Objects.equals(this.label, other.label)
                && Objects.equals(result, other.result);
    }
}
