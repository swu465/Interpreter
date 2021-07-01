package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    int runTimeTop;
    String label;
    int poppedValue;

    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("ReturnCode");
        //store top of runtime stack
        runTimeTop = vm.peekRunTime();
        vm.popFrameCall(); //??
        //pop the current frame then pop the top of the framePointer stack
        poppedValue = vm.popReturnAddress();
        vm.setPC(poppedValue);
        vm.pushCall(runTimeTop);
        //now its inf looping. find out why. yay.
        System.out.println("Going back to "+poppedValue);
    }

    @Override
    public void init(ArrayList<String> args) {
        if(args.size() == 1){
            label = args.get(0);
        }
    }

    @Override
    public String toString() {
        String returnString;
        //not sure if top of frame pointer or the top of runtimestack
        String[] data;
        if(label.contains(">>") && label.contains("<<")){
            data = label.split("<<");
            returnString = "RETURN "+label+"  EXIT "+data[0]+" : "+runTimeTop;
        }else{
            returnString = "RETURN "+label+"  EXIT "+label+" : "+runTimeTop;
        }
        return returnString;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setAddress(int value) {

    }
}
