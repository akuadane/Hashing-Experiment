package debuggers;


import hash_tables.HashObject;
import hash_tables.HashTable;

import java.io.File;
import java.io.FileWriter;


public class DebuggerLevelOne implements Debugger{
    private String linearHashingFileName="linear-dump.txt", doubleHashingFileName="double-dump.txt" ;

    /**
     * @param inputType
     * @param linearHashing
     * @param doubleHashing
     */

    @Override
    public void debug( int inputType, HashTable linearHashing, HashTable doubleHashing) {
        Debugger levelZero= new DebuggerLevelZero();
        levelZero.debug(inputType,linearHashing,doubleHashing);

        this.dumpToFile(linearHashing,doubleHashing);

    }

    /**
     * @param linearHashing
     * @param doubleHashing
     */
    private void dumpToFile(HashTable linearHashing, HashTable doubleHashing){
       try {

           new  File(this.linearHashingFileName);
           new File(this.doubleHashingFileName);

           FileWriter linearWriter = new FileWriter(this.linearHashingFileName);
           FileWriter doubleWriter = new FileWriter(this.doubleHashingFileName);

            for (int i = 0; i < linearHashing.getSize(); i++) {
                HashObject linearObj = linearHashing.getItem(i);
                HashObject doubleObj = doubleHashing.getItem(i);

                if (linearObj != null) {
                    String str = String.format("table[%d]: %s %d %d\n", i, linearObj.getKey(), linearObj.getFrequency(), linearObj.getProbe());
                    linearWriter.write(str);
                }

                if(doubleObj!=null){
                    String str = String.format("table[%d]: %s %d %d\n", i, doubleObj.getKey(), doubleObj.getFrequency(), doubleObj.getProbe());
                    doubleWriter.write(str);
                }
            }
            linearWriter.close();
            doubleWriter.close();
        }catch (Exception e){

       }
    }
}
