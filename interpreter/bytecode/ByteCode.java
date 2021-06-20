package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public abstract class ByteCode {
    public abstract void execute(VirtualMachine vm);
    public abstract void init(ArrayList<String> args);
    public abstract String toString();
}
