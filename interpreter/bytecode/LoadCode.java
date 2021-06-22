package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{
    int offset;
    String variable;
    @Override
    public void execute(VirtualMachine vm) {
        //takes value at the offset from the frame pointer and pushes it to top
        vm.loadCall(offset);
    }

    @Override
    public void init(ArrayList<String> args) {
        offset = Integer.parseInt(args.get(0));
        variable = (args.get(1));
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
