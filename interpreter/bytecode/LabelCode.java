package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    int location;
    @Override
    public void execute(VirtualMachine vm) {

    }

    @Override
    public void init(ArrayList<String> args) {
        location = Integer.parseInt(args.get(0));
    }

    @Override
    public String toString() {
        return null;
    }
}
