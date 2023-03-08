package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;
import sml.register.Registers;

import static sml.register.Registers.Register.EAX;
import static sml.register.Registers.Register.EBX;

public class DivideInstructionTest {
    private Machine machine;
    private Registers registers;

    @BeforeEach
    void setUp() {
        machine = new Machine(Registers.getRegisterInstance());
        registers = machine.getRegisters();
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
        registers = null;
    }

    @Test
    void executeValid() {
        registers.set(EAX, 20);
        registers.set(EBX, 5);
        Instruction instruction = new DivideInstruction(null, EAX, EBX);
        instruction.execute(machine);
        Assertions.assertEquals(4, machine.getRegisters().get(EAX));
    }

    @Test
    void executeValidTwo() {
        registers.set(EAX, 0);
        registers.set(EBX, 6);
        Instruction instruction = new DivideInstruction(null, EAX, EBX);
        instruction.execute(machine);
        Assertions.assertEquals(0, machine.getRegisters().get(EAX));
    }
}
