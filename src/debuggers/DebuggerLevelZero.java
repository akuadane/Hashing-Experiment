package debuggers;

import hash_tables.HashTable;

public class DebuggerLevelZero implements Debugger{
    @Override
    public void debug( int inputType, HashTable linearHashing, HashTable doubleHashing) {
        String hashtableTest="HashtableTest: ";

        System.out.println(String.format(hashtableTest+"Twin prime table size found in the range [%d..%d]: %d\n",95500,96000,95791));


        String inputTypeStr= "";
        if(inputType==1)
            inputTypeStr+="Random numbers";
        else if(inputType==2)
            inputTypeStr+="System time";
        else
            inputTypeStr+="word-list";
        System.out.println(hashtableTest+"Data source type --> "+inputTypeStr+"\n");


        //Linear Probing
        System.out.println(linearHashing);
        //Double Hashing
       System.out.println(doubleHashing);

    }
}
