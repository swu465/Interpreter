package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class HaltCode extends ByteCode{

    @Override
    public void execute(VirtualMachine vm) {
        vm.haltCall();
    }

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public String toString() {
        return null;
    }
}
