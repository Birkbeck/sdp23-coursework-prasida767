package sml.translator;

import sml.Instruction;
import sml.Labels;

import java.io.IOException;
import java.util.List;

public interface TranslatorBehavior {
   void readAndTranslate(Labels labels, List<Instruction> program) throws IOException, RuntimeException;
}
