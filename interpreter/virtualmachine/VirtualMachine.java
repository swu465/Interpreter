package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.CallCode;
import interpreter.bytecode.FalseBranchCode;
import interpreter.bytecode.GotoCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    //used to store return addresses for each called fucntion
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean        isDumping;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram() {
        isDumping = false;
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<Integer>();
        isRunning = true;
        while(isRunning){
            ByteCode code = program.getCode(programCounter);
            code.execute(this);
            System.out.println("frame: "+runTimeStack.printFrameStack());
            System.out.println("runtime: "+runTimeStack.printRunTime());

            programCounter++;
            //?????
            if(isDumping){
                if(code instanceof CallCode || code instanceof GotoCode || code instanceof FalseBranchCode){
                    System.out.println(code);
                    runTimeStack.dump();
                }
            }
        }
    }

    public void haltCall() {
        isRunning = false;
    }

    public int popCall() {
        return runTimeStack.pop();
    }

    public int storeCall(int offset) {
        return runTimeStack.store(offset);
    }

    public int loadCall(int offset) {
        return runTimeStack.load(offset);
    }

    public int peekFrame() {
        return runTimeStack.peekFramePointer();
    }

    public int pushCall(int value) {
        return runTimeStack.push(value);
    }

    public void pushFramePointer(int numberOfValues) {
        //double check this
        runTimeStack.newFrameAt(numberOfValues);
    }

    public void pushReturnAddress() {
        System.out.println(programCounter+" pushed onto return address stack");
        returnAddress.push(programCounter);
    }

    public void popFrameCall() {
        runTimeStack.popFrame();
    }

    public void setPC(int value) {
        programCounter = value;
    }

    public void dump(boolean b) {
        isDumping = b;
    }
    public int peekRunTime(){
        return runTimeStack.peek();
    }

    public String getCurrentFrame() {
        return runTimeStack.printFrame();
    }

    public int popReturnAddress() {
        return returnAddress.pop();
    }
}
