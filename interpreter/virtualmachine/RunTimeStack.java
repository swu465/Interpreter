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
    public String printFrameStack(){
        String frame="[";
        for(int x = 0; x < framePointer.size();x++){
            frame+=framePointer.get(x)+" ";
        }
        frame+="]";
        return frame;
    }
    public void dump(){
        String dumping="[";
        boolean notEven = false;
        if(framePointer.size() % 2 != 0){
            framePointer.add(runTimeStack.size());
            notEven = true;
        }
        //x++ or x+2?
        for(int x = 0; x < framePointer.size(); x=x+2){
            for (int y = framePointer.get(x); y < framePointer.get(x+1); y++){
                dumping = dumping + runTimeStack.get(y);
                if(y+1 < framePointer.get(x+1) ){
                    dumping = dumping + ", ";
                }
            }
        }
        if(notEven){
            framePointer.pop();
        }
        dumping = dumping + "]";
        System.out.println(dumping);
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
        int x = runTimeStack.size();
        System.out.println("Pop: "+runTimeStack.size());
        int y = runTimeStack.get(x);
        runTimeStack.remove(x);
        return y;
    }
    public int store(int offset){
        int x = framePointer.peek()+offset;
        int value = this.pop();
        runTimeStack.set(x,value);
        return value;
    }
    public int load(int offset){
        int value;
        if(runTimeStack.size() > 0 && framePointer.peek()+offset > runTimeStack.size()-1){
            value = runTimeStack.get(runTimeStack.size()-1);
        }else{
            value = runTimeStack.get(framePointer.peek()+offset);
        }
        runTimeStack.add(value);
        return value;
    }
    public void newFrameAt(int offset){
        //????
        int newFrame = runTimeStack.size()+offset;
        System.out.println("newFrameAt: "+newFrame+" Offset: "+offset);
        framePointer.add(newFrame);
    }
    public void popFrame(){
        int peekFrame = framePointer.peek();
        //runTimeStack.removeRange(peekFrame,runTimeStack.size()-1);
        for(int x = peekFrame; x<runTimeStack.size();x++){
            runTimeStack.remove(x);
        }
        framePointer.pop();
    }

    public int peekFramePointer() {
        return framePointer.peek();
    }
    public String printFrame(){
        StringBuilder frame = new StringBuilder();
        System.out.println("PrintFrame peek: "+framePointer.peek()+" RunTime Size: "+runTimeStack.size());
        System.out.println(printFrameStack());
        for(int x = framePointer.peek(); x < runTimeStack.size(); x++){
            frame.append(runTimeStack.get(x));
            if(x+1 < runTimeStack.size()){
                frame.append(",");
            }
        }
        return frame.toString();
    }
}
