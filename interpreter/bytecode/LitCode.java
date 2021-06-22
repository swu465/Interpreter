package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode{
    int value;
    String variable;
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushCall(value);
    }

    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
        variable = args.get(1);
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {

    }
}
