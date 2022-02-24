<h1 allign="center"> SFSU - The Interpreter</h1>
<h2 allign="center">What is this?</h2>
<p allign="center">
A program that will imitate a interpreter by executing bytecodes.  
</p>
<h2 allign ="center">How does this program work?</h2>
<p allign="center">
    This program is comprised of six classes that manage its exeuction: ByteCodeLoader, CodeTable, Interpreter, Program, RunTimeStack, and VirtualMachine.
  
    The ByteCodeLoader class will read a .x.cod file to look for ByteCodes.
    The CodeTable class stores a HashMap that maps out ByteCodes to their respective Bytecode classes.
    The Program class stores all the ByteCodes that was read from the source file. 
    The RunTimeStack class records and processes the stack of frames.
    The VirtaulMachine class executes the ByteCodes. 
    The Interpreter class initalizes the CodeTable, creates a Program object that has the loaded ByteCodes that will be given to the VirtalMachine for execution. 
</p>
 
  
```
program {
  int factorial(int n) {
      if (n < 2) then 
         { return 1 }
      else 
         {return n*factorial(n-1) }
  }
  write(factorial(read()))
}
```
 <p allign="center"> The following code block in ByteCodes that will be used for the program's execution:</p>
 
```
GOTO start<<1>>
LABEL Read
READ
RETURN
LABEL Write
LOAD 0 dummyFormal
WRITE
RETURN
LABEL start<<1>>
GOTO continue<<3>>
LABEL factorial<<2>>
LOAD 0 n
LIT 2
BOP <
FALSEBRANCH else<<4>>
LIT 1
RETURN factorial<<2>>
POP 0
GOTO continue<<5>>
LABEL else<<4>>
LOAD 0 n
LOAD 0 n
LIT 1
BOP -
ARGS 1
CALL factorial<<2>>
BOP *
RETURN factorial<<2>>
POP 0
LABEL continue<<5>>
POP 0
LIT 0    GRATIS-RETURN-VALUE
RETURN factorial<<2>>
LABEL continue<<3>>
ARGS 0
CALL Read
ARGS 1
CALL factorial<<2>>
ARGS 1
CALL Write
POP 3
HALT
```
