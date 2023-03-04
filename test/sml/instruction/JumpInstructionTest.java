package sml.instruction;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Labels;
import sml.Machine;
import sml.Registers;

import static sml.Registers.Register.EAX;

public class JumpInstructionTest {
    private Machine machine;
    private Labels labels;

    @BeforeEach
    void setUp() {
        machine = new Machine(new Registers());
        labels = machine.getLabels();
        //...
    }

    @AfterEach
    void tearDown() {
        machine = null;
    }

    @Test
    void executeValid() {
        String label = "f3";
        int address = 5;
        labels.addLabel(label, address);
        Instruction instruction = new JumpInstruction(null, EAX, label);
        instruction.execute(machine);
        Assertions.assertEquals(5, machine.getLabels().getAddress(label));
    }

    @Test
    void executeValidTwo() {
        String label = "f5";
        int address = 15;
        labels.addLabel(label, address);
        Instruction instruction = new JumpInstruction(null, EAX, label);
        instruction.execute(machine);
        Assertions.assertEquals(15, machine.getLabels().getAddress(label));
    }
}
