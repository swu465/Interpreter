package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    int offset;
    String variable;
    @Override
    public void execute(VirtualMachine vm) {
        vm.storeCall(offset);
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
