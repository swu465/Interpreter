package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{
    int resolvedAddress;
    String label;
    @Override
    public void execute(VirtualMachine vm) {
        vm.gotoCall(resolvedAddress);
        vm.pushReturnAddress();
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
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
        resolvedAddress = value;
    }
}
