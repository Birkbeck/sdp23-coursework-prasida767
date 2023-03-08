package sml.translator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sml.Instruction;
import sml.Labels;
import sml.Machine;
import sml.instruction.*;
import sml.register.Registers;
import sml.translator.Translator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static sml.register.Registers.Register.EAX;
import static sml.register.Registers.Register.EBX;

class TranslatorTest {

    private Machine machine;
    private Labels label;
    String fileName = "resources/test2.sml";

    @BeforeEach
    void setUp() {
        machine = new Machine(Registers.getRegisterInstance());
        label = new Labels();
        //...
    }
    @AfterEach
    void tearDown() {
        machine = null;
        label = null;
    }

    @Test
    void executeValid() throws IOException {
        Translator t = new Translator(fileName);
        t.readAndTranslate(this.machine.getLabels(), this.machine.getProgram());

        label.addLabel("L1", 0);

        List<Instruction> program = new ArrayList<>();
        program.add(new MoveInstruction("L1", EAX,66));
        program.add(new MoveInstruction(null, EBX, 10));
        program.add(new AddInstruction(null, EAX, EAX));
        program.add(new MultiplyInstruction(null, EAX, EBX));
        program.add(new OutputInstruction(null, EAX));
        program.add(new JumpInstruction(null, EAX, "L1"));

        Assertions.assertAll(() -> Assertions.assertEquals(machine.getLabels(), label),
                () -> Assertions.assertEquals(machine.getProgram(), program));
    }
}
