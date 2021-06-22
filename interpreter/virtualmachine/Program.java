package interpreter.virtualmachine;

import interpreter.bytecode.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    //private ArrayList <String> codeLines;

    public Program() {
        program = new ArrayList<ByteCode>();
        codeLines = new ArrayList<String>();
    }

    protected ByteCode getCode(int programCounter) {
        return this.program.get(programCounter);
    }
    //might not be necessary. add the codes in the resolveaddress maybe
    protected void addCodeLine(String input){
        codeLines.add(input);
    }
    public void addByte(ByteCode input){
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
        int location;
        String[] data;
        HashMap<String,Integer> addresses = new HashMap<>();
        //ArrayList<String> arguments;
        for(int x = 0; x < this.program.size(); x++) {
            if (this.program.get(x) instanceof LabelCode) {
                location = x;
                //data = codeLines.get(x).split("\\s+");
                addresses.put(program.get(x).getLabel(), location);
            }
            for (int y = 0; y < this.program.size(); y++) {
                //arguments = new ArrayList<>();
                //data = codeLines.get(y).split("\\s+");
                if (this.program.get(y) instanceof GotoCode || this.program.get(y) instanceof FalseBranchCode
                || this.program.get(y) instanceof CallCode) {
                    //label = data[1];
                    label = this.program.get(y).getLabel();
                    //location = addresses.get(label);
                    //if(addresses.containsKey(label){
                    //this.getCode(y).setAddress(location);
                    //}
                    if(addresses.containsKey(label)) {
                        //arguments.add(String.valueOf(addresses.get(label)));
                        this.program.get(y).setAddress(addresses.get(label));
                    }
                }
            }
        }
    }
}
