package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.LabelCode;

import java.util.ArrayList;

public class Program {

    private ArrayList<ByteCode> program;

    protected Program() {
        program = new ArrayList<ByteCode>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }
    //might not be necessary. add the codes in the resolveaddress maybe
    protected void addCode(ByteCode input){
        program.add(input);
    }
    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter
     * HINT: make note what type of data-structure ByteCodes are stored in.
     */
    //ask prof if we can pass a arraylist into resolve that is strings only, then we resolve everything here
    //and add them to the program arraylist of bytecodes
    public void resolveAddress() {
        String label;
        ByteCode labelName;
        int location;
        String[] data;
        for(int x = 0; x < this.program.size(); x++){
            if(program.get(x) instanceof LabelCode){
                location = x;
                label = program.get(x).getLabel();

                for(int y = 0; y < this.program.size(); y ++){
                    if(program.get(y) instanceof )
                }

            }
        }
    }




}
