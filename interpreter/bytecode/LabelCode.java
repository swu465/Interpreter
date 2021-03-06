package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    String label;
    int resolvedAddress;
    @Override
    public void execute(VirtualMachine vm) {
    }

    @Override
    public void init(ArrayList<String> args) {
        label = (args.get(0));
    }

    @Override
    public String toString() {
        return "LABEL "+resolvedAddress;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setAddress(int value) {
        resolvedAddress = value;
    }
}
