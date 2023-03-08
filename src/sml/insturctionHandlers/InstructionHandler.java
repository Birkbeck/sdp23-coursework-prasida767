package sml.insturctionHandlers;

import sml.Instruction;

/*A common behavioral interface that is responsible for instantiating the Instruction's constructor.
* This is implemented by all the instructions registered with the bean.*/
public interface InstructionHandler {
    Instruction createInstance(String label, String parameter1, String parameter2);
}
