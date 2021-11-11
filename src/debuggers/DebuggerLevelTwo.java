package debuggers;

import hash_tables.HashObject;
import hash_tables.HashTable;

public class DebuggerLevelTwo implements Debugger {

    @Override
    public void debug(int _, HashTable linearHashing, HashTable doubleHashing) {
        System.out.println("=========Linear Probing=========");
        this.printElementWise(linearHashing);
        System.out.println("=========Double Hashing=========");
        this.printElementWise(doubleHashing);
    }

    private void printElementWise(HashTable hashTable){
        for (int i = 0; i < hashTable.getSize(); i++) {
            HashObject obj = hashTable.getItem(i);
            if(obj!=null){
                System.out.println(String.format("table[%d]: %s %d %d\n", i, obj.getKey(), obj.getFrequency(), obj.getProbe()));

            }


        }
    }
}
