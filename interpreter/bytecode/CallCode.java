package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends ByteCode{
    int resolvedAddress;
    String label;
    String printCurrentFrame;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("CallCode");

        vm.pushReturnAddress();
        //printCurrentFrame = vm.getCurrentFrame();
        //System.out.println("stack "+printCurrentFrame);
        vm.setPC(resolvedAddress);
    }

    @Override
    public void init(ArrayList<String> args) {
        label = args.get(0);
    }

    @Override
    public String toString() {
        String[] splitLabel = label.split("<<");
        return "CALL "+label+"  "+splitLabel[0]+"["+printCurrentFrame+"]";
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
