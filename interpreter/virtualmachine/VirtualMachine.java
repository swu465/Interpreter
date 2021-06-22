package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    //used to store return addresses for each called fucntion
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            //returnAddress.push(programCounter);
            programCounter++;
        }
    }

    public void haltCall() {
        isRunning = false;
    }

    public int popCall() {
        return runTimeStack.pop();
    }

    public void gotoCall(int address) {
        programCounter = address;
    }

    public void storeCall(int offset) {
        int storeValue = runTimeStack.store(offset);
    }

    public void loadCall(int offset) {
        runTimeStack.load(offset);
    }

    public int peekFrame() {
        return runTimeStack.peekFramePointer();
    }

    public void pushCall(int value) {
        runTimeStack.push(value);
    }

    public void pushFramePointer(int numberOfValues) {
        //double check this
        runTimeStack.newFrameAt(numberOfValues);
    }

    public void pushReturnAddress() {
        returnAddress.push(programCounter);
    }
}
