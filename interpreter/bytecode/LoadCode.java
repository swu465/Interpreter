package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LoadCode extends ByteCode{
    int offset,pushedValue;
    String variable;
    @Override
    public void execute(VirtualMachine vm) {
        //takes value at the offset from the frame pointer and pushes it to top
        //System.out.println("LoadCode");
        System.out.println(this.toString());
        pushedValue = vm.loadCall(offset);
    }

    @Override
    public void init(ArrayList<String> args) {
        if(args.size() == 1){
            offset = Integer.parseInt(args.get(0));
        }else if(args.size() == 2){
            offset = Integer.parseInt(args.get(0));
            variable = (args.get(1));
        }
    }

    @Override
    public String toString() {
        String returnString;
        if(variable!=null){
            returnString = "LOAD "+offset+" "+variable+"<load "+variable+">";
        }else{
            returnString = "LOAD "+offset;
        }
        return returnString;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {

    }
}
