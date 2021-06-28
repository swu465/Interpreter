package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends ByteCode{
    int resolvedAddress;
    String label;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("GoToCode");
        vm.setPC(resolvedAddress);
    }

    @Override
    public void init(ArrayList<String> args) {
        //location = Integer.parseInt(args.get(0));
        label = args.get(0);
    }

    @Override
    public String toString() {
        return "GOTO "+resolvedAddress;
    }
    public String getLabel(){
        return label;
    }

    @Override
    public void setAddress(int value) {
        resolvedAddress = value;
    }
}
