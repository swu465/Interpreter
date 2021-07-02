package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;
import java.util.HashMap;

public class BopCode extends ByteCode{
    String operator;
    int result;
    boolean stuff;
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("BopCode "+operator);
        int operandTwo = vm.popCall();
        int operandOne = vm.popCall();
        System.out.println(operandOne +" "+ operator+" "+operandTwo+" = "+result);
        switch(operator){
            case "+":
                result = vm.pushCall(operandOne + operandTwo);
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "-":
                result = vm.pushCall(operandOne - operandTwo);
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "/":
                result = vm.pushCall(operandOne / operandTwo);
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "*":
                result = vm.pushCall(operandOne * operandTwo);
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "==":
                if(operandOne == operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "!=":
                if(operandOne != operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "<=":
                if(operandOne <= operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case ">=":
                if(operandOne >= operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "<":
                if(operandOne < operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case ">":
                if(operandOne > operandTwo){
                    result = vm.pushCall(0);
                }else{
                    result = vm.pushCall(1);
                }
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "|":
                result = vm.pushCall((operandOne | operandTwo));
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
                break;
            case "&":
                result = vm.pushCall((operandOne & operandTwo));
                System.out.println(operandTwo +" "+ operator+" "+operandOne+" = "+result);
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
