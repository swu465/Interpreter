package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadCode extends ByteCode{
    @Override
    public void execute(VirtualMachine vm) {
        System.out.println("ReadCode");
        Scanner input = new Scanner(System.in);
        int number;
        boolean numberFound = false;
        System.out.print("Please enter an Integer: ");
        do {
            String userInput = input.nextLine();
            //maybe redo this part
            try{
                number = Integer.parseInt(userInput);
                vm.pushCall(number);
                System.out.println("You entered "+number+" in ReadCode");
                numberFound = true;
            }catch(Exception e){
                input.nextLine();
                System.out.println(userInput+" "+"You did not enter a valid integer. Please try again.");
            }

        }while(!numberFound);
    }

    @Override
    public void init(ArrayList<String> args) {

    }

    @Override
    public String toString() {
        return "READ";
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void setAddress(int value) {

    }
}
