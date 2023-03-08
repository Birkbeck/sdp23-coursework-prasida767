package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.register.RegisterName;

import java.util.Objects;

/**
 * This class helps the program to jump to a specific label or to a specific program counter point.
 * The instruction takes three parameters: a label, a destination register, and a parameter.
 * The result register is the destination register that takes the contents and transfer the program flow to the parameter.
 * This class inherits from the abstract Instruction class and implements the execute method
 * to perform the jump operation on the given program counter in the Machine instance.
 * @author prasida767
 */

public class JumpInstruction extends Instruction {

    private final RegisterName result;
    private final String parameter;
    public static final String OP_CODE = "jnz";

    public JumpInstruction(String label, RegisterName result, String value) {
        super(label, OP_CODE);
        this.result = result;
        this.parameter = value;
    }

    @Override
    public int execute(Machine m) {
        if(m.getRegisters().get(result) > 0)
            return m.getLabels().getAddress(parameter);
        else return NORMAL_PROGRAM_COUNTER_UPDATE;
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
        JumpInstruction other = (JumpInstruction) obj;
        return Objects.equals(this.label, other.label)
                && Objects.equals(result, other.result)
                && Objects.equals(parameter, other.parameter);
    }
}
