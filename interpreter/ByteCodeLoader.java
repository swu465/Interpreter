
package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.virtualmachine.Program;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN loadCodes.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts. Can also use the split function in the String class.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        Program loadedByteCodes = new Program();
        ByteCode randomByte;
        String codeLine,codeClass,byteCodeName;
        String []data;
        ArrayList<String> byteArgs;

        //while((codeLine = byteSource.readLine()) != null){
        try{
            while(this.byteSource.ready()){
                byteArgs = new ArrayList<>();
                codeLine = this.byteSource.readLine();
                //loadedByteCodes.addCodeLine(codeLine);
                data = codeLine.split("\\s+");
                codeClass = CodeTable.getClassName(data[0]);
                //randomByte = (ByteCode)((Class.forName("interpreter.bytecode"+codeClass)).getDeclaredConstructor().newInstance());
                Class classBlueprint = Class.forName("interpreter.bytecode."+codeClass);
                randomByte = (ByteCode) classBlueprint.getDeclaredConstructor().newInstance();
                for( int x = 1; x < data.length; x++){
                    byteArgs.add(data[x]);
                }
                randomByte.init(byteArgs);
                loadedByteCodes.addByte(randomByte);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(255);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        //loadedByteCodes.resolveAddress(sourceLines);
        loadedByteCodes.resolveAddress();
        //System.out.println("resolved addresses");
       return loadedByteCodes;
    }
}
