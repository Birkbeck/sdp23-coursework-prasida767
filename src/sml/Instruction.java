package sml;

// TODO: write a JavaDoc for the class -> Completed.
/**
 * Represents an abstract instruction.
 * This class serves as the base class for all instructions in a Simple Machine Language (SML) program.
 * It defines the basic and common properties of an instruction needed for the SML such as label and opcode,
 * and provides a method to execute an instruction.
 * Subclasses of Instruction must implement the abstract methods of this class
 * to provide their own functionality. These include toString(), hashCode(), and equals(Object obj).
 * @author [prasida767]
 */

public abstract class Instruction {
	protected final String label;
	protected final String opcode;

	/**
	 * Constructor: an instruction with a label and an opcode
	 * (opcode must be an operation of the language)
	 *
	 * @param label optional label (can be null)
	 * @param opcode operation name
	 */
	public Instruction(String label, String opcode) {
		this.label = label;
		this.opcode = opcode;
	}

	public String getLabel() {
		return label;
	}

	public String getOpcode() {
		return opcode;
	}

	public static int NORMAL_PROGRAM_COUNTER_UPDATE = -1;

	/**
	 * Executes the instruction in the given machine.
	 *
	 * @param machine the machine the instruction runs on
	 * @return the new program counter (for jump instructions)
	 *          or NORMAL_PROGRAM_COUNTER_UPDATE to indicate that
	 *          the instruction with the next address is to be executed
	 */

	public abstract int execute(Machine machine);

	protected String getLabelString() {
		return (getLabel() == null) ? "" : getLabel() + ": ";
	}

	// TODO: What does abstract in the declaration below mean?
	//       (Write a short explanation.) -> Completed.
	/*
	The "abstract" keyword in the declarations of these methods means that the implementation of these methods
	is given to the subclasses of the Instruction class.
	These methods are declared abstract because they must be implemented by
	each individual subclass in a way that is specific to that subclass.
	This allows each subclass to provide its own implementation of these methods to achieve a desired functionality.
	 */

	@Override
	public abstract String toString();

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(Object obj);

	// TODO: Make sure that subclasses also implement equals and hashCode (needed in class Machine). -> Completed
}
