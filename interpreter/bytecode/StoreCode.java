package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class StoreCode extends ByteCode{
    int offset;
    String variable;
    int runTimeTop;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("StoreCode");
        runTimeTop = vm.storeCall(offset);
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
        //???? double check this
        return "STORE" +offset+" "+variable+"  "+variable+"="+runTimeTop;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {
    }
}
