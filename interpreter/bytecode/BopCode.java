package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.HashMap;

public class BopCode extends ByteCode{
    String operator;
    private static int result;
    boolean stuff;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("BopCode");
        int operandTwo = vm.popCall();
        int operandOne = vm.popCall();
        switch(operator){
            case "+":
                result = vm.pushCall(operandOne + operandTwo);
                break;
            case "-":
                result = vm.pushCall(operandOne - operandTwo);
                break;
            case "/":
                result = vm.pushCall(operandOne / operandTwo);
                break;
            case "*":
                result = vm.pushCall(operandOne * operandTwo);
                break;
            case "==":
                if(operandOne == operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                break;
            case "!=":
                if(operandOne != operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                break;
            case "<=":
                if(operandOne <= operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                break;
            case ">=":
                if(operandOne >= operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                break;
            case "<":
                if(operandOne < operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                break;
            case ">":
                if(operandOne > operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                break;
            case "|":
                result = vm.pushCall(operandOne | operandTwo);
                break;
            case "&":
                result = vm.pushCall(operandOne & operandTwo);
                break;
        }
        //vm.pushCall(result);
    }

    @Override
    public void init(ArrayList<String> args) {
        operator = args.get(0);
    }

    @Override
    public String toString() {
        return "BOP "+operator;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {
    }
}
