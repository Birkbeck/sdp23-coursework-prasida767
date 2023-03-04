package sml;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static sml.Registers.Register;

/**
 * This class ....
 * <p>
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 *
 * @author ...
 */
public final class Translator {

    private final String fileName; // source file of SML code

    // line contains the characters in the current line that's not been processed yet
    private String line = "";

    public Translator(String fileName) {
        this.fileName =  fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"

    public void readAndTranslate(Labels labels, List<Instruction> program) throws IOException {
        try (var sc = new Scanner(new File(fileName), StandardCharsets.UTF_8)) {
            labels.reset();
            program.clear();

            // Each iteration processes line and reads the next input line into "line"
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String label = getLabel();

                Instruction instruction = getInstruction(label);
                if (instruction != null) {
                    if (label != null)
                        labels.addLabel(label, program.size());
                    program.add(instruction);
                }
            }
        }
    }

    /**
     * Translates the current line into an instruction with the given label
     *
     * @param label the instruction label
     * @return the new instruction
     * <p>
     * The input line should consist of a single SML instruction,
     * with its label already removed.
     */
//    private Instruction getInstruction(String label) {
//        if (line.isEmpty())
//            return null;
//
//        String opcode = scan();
//        switch (opcode) {
//            case AddInstruction.OP_CODE -> {
//                String r = scan();
//                String s = scan();
//                return new AddInstruction(label, Register.valueOf(r), Register.valueOf(s));
//            }
//            case SubtractInstruction.OP_CODE -> {
//                String r = scan();
//                String s = scan();
//                return new SubtractInstruction(label, Register.valueOf(r), Register.valueOf(s));
//            }
//            case MultiplyInstruction.OP_CODE -> {
//                String r = scan();
//                String s = scan();
//                return new MultiplyInstruction(label, Register.valueOf(r), Register.valueOf(s));
//            }
//            case DivideInstruction.OP_CODE -> {
//                String r = scan();
//                String s = scan();
//                return new DivideInstruction(label, Register.valueOf(r), Register.valueOf(s));
//            }
//            case MoveInstruction.OP_CODE -> {
//                String r = scan();
//                String s = scan();
//                return new MoveInstruction(label, Register.valueOf(r), Integer.valueOf(s));
//            }
//            case JumpInstruction.OP_CODE -> {
//                String r = scan();
//                String s = scan();
//                return new JumpInstruction(label, Register.valueOf(r), s);
//            }
//            case OutputInstruction.OP_CODE -> {
//                String r = scan();
//                return new OutputInstruction(label, Register.valueOf(r));
//            }
//
//            // TODO: add code for all other types of instructions
//
//            // TODO: Then, replace the switch by using the Reflection API
//
//            // TODO: Next, use dependency injection to allow this machine class
//            //       to work with different sets of opcodes (different CPUs)
//
//            default -> System.out.println("Unknown instruction: " + opcode);
//        }
//        return null;
//    }

    private Instruction getInstruction(String label) {
        if (line.isEmpty())
            return null;

        String opcode = scan();
        String registerDetail = scan();
        String parameter = scan();

        Properties properties = new Properties();
        try{
            try(var instructionKeyValue = Translator.class.getResourceAsStream("/beans.properties")){
                properties.load(instructionKeyValue);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            String instructionClass = properties.getProperty(opcode + ".class");
            return newInstanceOf(instructionClass, label, registerDetail, parameter);
        }catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                IllegalAccessException e){
            e.printStackTrace();
        }
        return null;
    }

    private Instruction newInstanceOf(String classToInstantiate, String label, String registerDetail, String parameter) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, ExceptionInInitializerError {
        Class<?> instructionClass = Class.forName(classToInstantiate);

        Constructor<?> instructionClassCons = instructionClass.getConstructors()[0];

        Parameter[] paramType = instructionClassCons.getParameters();
        List<Object> paramList = new LinkedList<>();
        paramList.add(label);
        if(paramType[1].getType().getName().equals("sml.RegisterName") ){
            paramList.add(Register.valueOf(registerDetail));
            if(paramType.length>2) {
                if (paramType[2].getType().getName().equals("sml.RegisterName"))
                    paramList.add(Register.valueOf(parameter));
                else if (paramType[2].getType().getName().equals("java.lang.Integer"))
                    paramList.add(Integer.parseInt(parameter));
                else if (paramType[2].getType().getName().equals("java.lang.String"))
                    paramList.add(String.valueOf(parameter));
            }
        }
        return (Instruction) instructionClassCons.newInstance(paramList.toArray());
    }


    private String getLabel() {
        String word = scan();
        if (word.endsWith(":"))
            return word.substring(0, word.length() - 1);

        // undo scanning the word
        line = word + " " + line;
        return null;
    }

    /*
     * Return the first word of line and remove it from line.
     * If there is no word, return "".
     */
    private String scan() {
        line = line.trim();

        for (int i = 0; i < line.length(); i++)
            if (Character.isWhitespace(line.charAt(i))) {
                String word = line.substring(0, i);
                line = line.substring(i);
                return word;
            }

        return line;
    }
}