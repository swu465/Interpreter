package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{
    int numberOfPops;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("PopCode "+numberOfPops);
        int frameIndex = vm.peekFrame();
        if(numberOfPops<frameIndex){
            System.out.println("number <= frameIndex");
            for(int x = 0 ; x < numberOfPops; x++){
                vm.popCall();
            }
        }else if(numberOfPops>=frameIndex){
            System.out.println(("number > pops"));
            for (int x  = 0; x < frameIndex; x++){
                vm.popCall();
            }
        }
    }

    @Override
    public void init(ArrayList<String> args) {
        numberOfPops = Integer.parseInt(args.get(0));
    }

    @Override
    public String toString() {
        return "POP "+numberOfPops;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {

    }
}
