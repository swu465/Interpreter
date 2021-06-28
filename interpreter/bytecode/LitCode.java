package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode{
    int value;
    String variable;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("LitCode");
        vm.pushCall(value);
    }

    @Override
    public void init(ArrayList<String> args) {
        if(args.size() == 1){
            value = Integer.parseInt(args.get(0));
        }else if(args.size() == 2){
            value = Integer.parseInt(args.get(0));
            variable = args.get(1);
        }
    }

    @Override
    public String toString() {
        String returnString;
        if(variable != null){
            returnString = "LIT "+value+"  int "+variable;
        }else{
            returnString = "LIT "+value;
        }
        return returnString;
    }

    @Override
    public String getLabel() {
        return variable;
    }

    @Override
    public void setAddress(int value) {

    }
}
