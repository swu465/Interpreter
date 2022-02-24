package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class WriteCode extends ByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("WriteCode");
        int value = vm.peekRunTime();
        //System.out.println(value);
    }

    @Override
    public void init(ArrayList<String> args) {
    }

    @Override
    public String toString() {
        return "WRITE";
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {
    }
}
