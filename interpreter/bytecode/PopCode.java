package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{
    int numberOfPops;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("PopCode");
        int frameIndex = vm.peekFrame();
        if(numberOfPops<=frameIndex){
            for(int x = 0 ; x < numberOfPops; x++){
                vm.popCall();
            }
        }else {
            for(int y = 0; y < frameIndex; y++){
                vm.popCall();
                //maybe popframe()?
                //vm.popFrameCall();
            }
        }
    }

    @Override
    public void init(ArrayList<String> args) {
        numberOfPops = Integer.parseInt(args.get(0));
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
