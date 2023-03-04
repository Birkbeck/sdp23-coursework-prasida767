package sml;


import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public final class InstructionSupportFactory {

    private static String label;
    private static String parameter;
    private static String opcode;
    public static InstructionSupportFactory instance = new InstructionSupportFactory();

    public static InstructionSupportFactory getInstance(String label, String opcode, String parameter){
        InstructionSupportFactory.label = label;
        InstructionSupportFactory.opcode = opcode;
        InstructionSupportFactory.parameter = parameter;
        return instance;
    }

    public static Instruction instruction;
    public Instruction getInstruction(){return instruction;}



    private InstructionSupportFactory(){
        System.out.println("label = " + label);
        Properties properties = new Properties();
        try{
            try(var instructionKeyValue = InstructionSupportFactory.class.getResourceAsStream("/beans.properties")){
                properties.load(instructionKeyValue);
            } catch (IOException e) {
                System.out.println("e =====>>> " + e);
                throw new RuntimeException(e);
            }

            String cc = opcode + ".class";
            System.out.println("cc = " + cc);
            String instructionClass = properties.getProperty(cc);
            System.out.println("instructionClass = " + instructionClass);
            instruction = (Instruction) newInstanceOf(instructionClass, label, opcode, parameter);
        }catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                IllegalAccessException e){
            System.out.println("e = " + e);
        }
    }

    private Object newInstanceOf(String classToInstantiate, String label, String opcode, String parameter) throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, ExceptionInInitializerError
    {
        System.out.println("classToInstantiate = " + classToInstantiate);
        Class<?> instructionClass = Class.forName(classToInstantiate);
        Constructor<?> constructor = instructionClass.getDeclaredConstructor(String.class, Registers.Register.class, Object.class);
        return constructor.newInstance(label, Registers.Register.valueOf(opcode), parameter);
    }
}
