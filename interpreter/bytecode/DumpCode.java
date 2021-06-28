package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode{
    String flag;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("DumpCode");
        if(flag.equals("ON")){
            vm.dump(true);
        }else if(flag.equals("OFF")){
            vm.dump(false);
        }
    }

    @Override
    public void init(ArrayList<String> args) {
        flag = args.get(0);
    }

    @Override
    public String toString() {
        return "DUMP "+flag;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {

    }
}
