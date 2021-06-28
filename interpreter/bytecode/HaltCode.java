package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode{

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("HaltCode");
        vm.haltCall();
    }

    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public String toString() {
        return "HALT";
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {
    }
}
