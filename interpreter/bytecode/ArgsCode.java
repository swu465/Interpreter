package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    int numberOfValues;
    @Override
    public void execute(VirtualMachine vm) {
        //double check
        System.out.println("ArgsCode "+numberOfValues);
        vm.pushFramePointer(numberOfValues);
    }

    @Override
    public void init(ArrayList<String> args) {
        numberOfValues = Integer.parseInt(args.get(0));
    }

    @Override
    public String toString() {
        return "ARGS "+numberOfValues;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {

    }
}
