package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Machine;
import sml.register.Registers;

import static sml.register.Registers.Register.EAX;

public class MoveInstructionTest {
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
        registers.set(EAX, 5);
        Instruction instruction = new MoveInstruction(null, EAX, 10);
        instruction.execute(machine);
        Assertions.assertEquals(10, machine.getRegisters().get(EAX));
    }

    @Test
    void executeValidTwo() {
        registers.set(EAX, -5);
        Instruction instruction = new MoveInstruction(null, EAX, 100);
        instruction.execute(machine);
        Assertions.assertEquals(100, machine.getRegisters().get(EAX));
    }
}
