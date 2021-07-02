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
        String dumping="[] [";
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
        //System.out.println("Peek: "+runTimeStack.size());
        int x = 0;
        if(runTimeStack.size() > 0) {
           x = runTimeStack.size() - 1;
        }
        return runTimeStack.get(x);
    }
    public int push(int value){
        runTimeStack.add(value);
        //System.out.println("You entered "+this.peek()+" in RunTimeStack push");
        //System.out.println("Push: "+runTimeStack.size());
        return this.peek();
    }
    public int pop(){
        int x = runTimeStack.size()-1;
        //System.out.println("Pop before: "+runTimeStack.size());
        int y = runTimeStack.get(x);
        runTimeStack.remove(x);
        //System.out.println("Pop after: "+runTimeStack.size());
        return y;
    }
    public int store(int offset){
        //System.out.println("Store runtime size: "+runTimeStack.size()+" Offset: "+offset);
        //System.out.println("Framepointer peek "+framePointer.peek());
        int x = framePointer.peek()+offset;
        int value = this.pop();
        runTimeStack.set(x,value);
        return value;
    }
    public int load(int offset){
        int value = 0;
        int newOffset = framePointer.peek()+offset;
        if(newOffset > runTimeStack.size()-1){
            value = this.peek();
        }else if(newOffset< runTimeStack.size()-1){
            value = runTimeStack.get(newOffset);
        }
        runTimeStack.add(value);
        return value;
    }
    /**
      * create a new frame pointer at the index offset slots down
      * from the top of the runtime stack .
      * @param offset slots down from the top of the runtime stack
      */
    public void newFrameAt(int offset){
        //iif the offset is 0, return the number of elements?
        int newFrame = runTimeStack.size()-1;
        if(runTimeStack.size() > 0 && runTimeStack.size() > offset){
            newFrame= runTimeStack.size()-offset-1;//-1?
        }else if(runTimeStack.size() < offset || offset == 0){
        //if the offset is bigger than the runtimestack, assume its everything in the stack
            newFrame = 0;
        }
        System.out.println("newFrameAt: "+newFrame+" Offset: "+offset);
        framePointer.add(newFrame);
    }
    public void popFrame(){
        int peekFrame = framePointer.peek();
        System.out.println("PopFrame "+runTimeStack.size()+" frame peek: "+peekFrame);
        //runTimeStack.removeRange(peekFrame,runTimeStack.size()-1);
        if(peekFrame > 1){
            System.out.println("AAAAA");
            for(int x = peekFrame; x < runTimeStack.size();x++){
                runTimeStack.remove(x);
            }
            framePointer.pop();
        }else if(peekFrame == 0 && runTimeStack.size() >= 1){
            System.out.println("EEEEE");
            framePointer.pop();
            this.pop();
        }
    }

    public int peekFramePointer() {
        return framePointer.peek();
    }
    public String printFrame(){
        StringBuilder frame = new StringBuilder();
        //System.out.println("PrintFrame peek: "+framePointer.peek()+" RunTime Size: "+runTimeStack.size());
        //System.out.println(printFrameStack());
        for(int x = framePointer.peek(); x < runTimeStack.size(); x++){
            frame.append(runTimeStack.get(x));
            if(x+1 < runTimeStack.size()){
                frame.append(",");
            }
        }
        return frame.toString();
    }

    public String printRunTime() {
        String runTime="[";
        for(int x = 0; x < runTimeStack.size();x++){
            runTime+=runTimeStack.get(x)+" ";
        }
        runTime+="]";
        return runTime;
    }
}
