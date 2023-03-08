package sml.instruction;

import sml.Instruction;
import sml.Machine;
import sml.register.RegisterName;

import java.util.Objects;

/**
 * It multiplies the values of two registers and stores the result in a specified register.
 * The result register is the destination register, and the source register contains the second operand.
 * The instruction takes three parameters: a label, a destination register, and a source register.
 * This class inherits from the abstract Instruction class and implements the execute method
 * to perform the multiplication operation on the given registers in the Machine instance.
 * @author prasida767
 */

public class MultiplyInstruction extends Instruction {
    private final RegisterName result;
    private final RegisterName source;

    public static final String OP_CODE = "mul";

    public MultiplyInstruction(String label, RegisterName result, RegisterName source) {
        super(label, OP_CODE);
        this.result = result;
        this.source = source;
    }

    @Override
    public int execute(Machine m) {
        int value1 = m.getRegisters().get(result);
        int value2 = m.getRegisters().get(source);
        m.getRegisters().set(result, value1 * value2);
        return NORMAL_PROGRAM_COUNTER_UPDATE;
    }

    @Override
    public String toString() {
        return getLabelString() + getOpcode() + " " + result + " " + source;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, result, source);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MultiplyInstruction other = (MultiplyInstruction) obj;
        return Objects.equals(this.label, other.label)
                && Objects.equals(result, other.result)
                && Objects.equals(source, other.source);
    }
}
