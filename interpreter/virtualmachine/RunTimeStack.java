package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.Stack;

class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    public void dump(){

    }
    public int peek(){
        int x = runTimeStack.size()-1;
        return runTimeStack.get(x);
    }
    public int push(int value){
        this.runTimeStack.add(value);
        return this.peek();
    }
    public int pop(){
        int x = runTimeStack.size()-1;
        int y = runTimeStack.get(x);
        runTimeStack.remove(x);
        return y;
    }
    public int store(int offset){
        int x = framePointer.peek()+offset;
        int value = runTimeStack.get(runTimeStack.size()-1);
        runTimeStack.remove(runTimeStack.size()-1); //not sure if we're removing anything here
        runTimeStack.set(x,value);
        return value;
    }
    public int load(int offset){
        int value = runTimeStack.get(framePointer.peek()+offset);
        runTimeStack.add(value);
        return runTimeStack.size()-1;
    }
    public void newFrameAt(int offset){
        int newFrame = runTimeStack.size()-1+offset;
        framePointer.add(newFrame);
    }
    public void popFrame(){
        int peekFrame = framePointer.peek();
        runTimeStack.removeRange(peekFrame,runTimeStack.size()-1);
        /*
            for(int x = peekFrame; x<runTimeStack.size()-1;x++){
                    runTmeStack.remove(x);
                }
        */
        framePointer.pop();
    }

    public int peekFramePointer() {
        return framePointer.peek();
    }
}
