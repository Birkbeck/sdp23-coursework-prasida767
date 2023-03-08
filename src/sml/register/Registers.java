package sml.register;

import java.util.*;
import java.util.stream.Collectors;

// TODO: write a JavaDoc for the class

/** This class represents the sets of Registers during a program execution.
 * In total there are 8 registers that are responsible to carry out the program execution.
 * It contains methods for setting and getting register values, clearing all register values, and checking equality between two Registers objects.
 * Note: The Registers class is immutable, meaning that once created, its contents cannot be changed.
 *
 * @author prasida767
 */
public final class Registers {
    private final Map<Register, Integer> registers = new HashMap<>();

    public enum Register implements RegisterName {
        EAX, EBX, ECX, EDX, ESP, EBP, ESI, EDI
    }

    private static final Registers registerInstance = new Registers();

    public static Registers getRegisterInstance(){
        return registerInstance;
    }

    private Registers() {
        clear(); // the class is final
    }

    public void clear() {
        for (Register register : Register.values())
            registers.put(register, 0);
    }

    /**
     * Sets the given register to the value.
     *
     * @param register register name
     * @param value new value
     */
    public void set(RegisterName register, int value) {
        registers.put((Register)register, value);
    }

    /**
     * Returns the value stored in the register.
     *
     * @param register register name
     * @return value
     */
    public int get(RegisterName register) {
        return registers.get((Register)register);
    }

    // TODO: use pattern matching for instanceof -> Completed
    // https://docs.oracle.com/en/java/javase/14/language/pattern-matching-instanceof-operator.html
    @Override
    public boolean equals(Object o) {
        if (o instanceof Registers other)
            return registers.equals(other.registers);
        return false;
    }

    @Override
    public int hashCode() {
        return registers.hashCode();
    }

    @Override
    public String toString() {
        return registers.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getKey() + " = " + e.getValue())
                .collect(Collectors.joining(", ", "[", "]")) ;
    }
}
