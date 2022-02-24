package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends ByteCode{
    int resolvedAddress;
    String label;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("FalseBranchCode "+label);
       int runTimePop = vm.popCall();
       if(runTimePop == 0){
           //System.out.println("I found a 0");
            vm.setPC(resolvedAddress);
       }
    }

    @Override
    public void init(ArrayList<String> args) {
       //location = Integer.parseInt(args.get(1));
        label = args.get(0);
    }

    @Override
    public String toString() {
        return "FALSEBRANCH "+resolvedAddress;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public void setAddress(int value) {
        resolvedAddress = value;
    }
}
