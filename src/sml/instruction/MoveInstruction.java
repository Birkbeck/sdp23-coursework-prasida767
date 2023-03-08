package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.register.RegisterName;

import java.util.Objects;

/**
 * This class helps the program to store a parameter value provided from the program file in a specified register.
 * The instruction takes three parameters: a label, a destination register, and an integer parameter.
 * The result register is the destination register that stores the integer parameter.
 * This class inherits from the abstract Instruction class and implements the execute method
 * to perform the move operation on the given program counter in the Machine instance.
 * @author prasida767
 */

public class MoveInstruction extends Instruction {

    private final RegisterName result;
    //    private final RegisterName source;
    private final Integer parameter;

    public static final String OP_CODE = "mov";

    public MoveInstruction(String label, RegisterName result, Integer value) {
        super(label, OP_CODE);
        this.result = result;
        this.parameter = value;
    }

    @Override
    public int execute(Machine m) {
        m.getRegisters().set(result, parameter);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result + " " + parameter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, result, parameter);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MoveInstruction other = (MoveInstruction) obj;
        return Objects.equals(this.label, other.label)
                && Objects.equals(result, other.result)
                && Objects.equals(parameter, other.parameter);
    }
}
