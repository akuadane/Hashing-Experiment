import data_generators.DataGenerator;
import data_generators.FileDataGenerator;
import data_generators.RandomDataGenerator;
import data_generators.SystemTimeDataGenerator;
import debuggers.Debugger;
import debuggers.DebuggerLevelOne;
import debuggers.DebuggerLevelTwo;
import debuggers.DebuggerLevelZero;
import hash_tables.DoubleHashing;
import hash_tables.HashTable;
import hash_tables.LinearProbing;
import helper_classes.TwinPrimeGenerator;

public class HashtableTest {
    public static void main(String[] args) {

        if(args.length>3 || args.length<2){
            System.out.println("Usage: java HashtableTest <input type> <load factor> [<debug level>]\n" +
                    "input type = 1 for random numbers, 2 for system time, 3 for word list\n" +
                    "debug = 0 ==> print summary of experiment\n" +
                    "debug = 1 ==> save the two hash tables to a file at the end\n" +
                    "debug = 2 ==> print debugging output for each insert");
            return ;
        }
        int debugLevel=0;
        if(args.length==3)
            debugLevel=Integer.parseInt(args[2]);
        int inputType = Integer.parseInt(args[0]);
        double loadFactor = Double.parseDouble(args[1]);

        //Generate table size, m
        int m = TwinPrimeGenerator.smallestTwinPrimes(95500,96000)[1];

        //Create two Hashtables , one for linear hashing and another for double hashing
        HashTable linearHashing = new LinearProbing(m,loadFactor);
        HashTable doubleHashing = new DoubleHashing(m,loadFactor);

        //Populate the tables with the chosen type of data source
        DataGenerator dataGenerator;

        switch (inputType){
            case 2: dataGenerator = new SystemTimeDataGenerator();break;
            case 3: dataGenerator = new FileDataGenerator();break;
            case 1:
            default: dataGenerator = new RandomDataGenerator();
        }

        dataGenerator.generateData(linearHashing);
        dataGenerator.generateData(doubleHashing);
        //Show debug based on the type of debugging level
        Debugger debugger;

        switch (debugLevel){
            case 1: debugger = new DebuggerLevelOne();break;
            case 2: debugger = new DebuggerLevelTwo(); break;
            case 0:
            default: debugger = new DebuggerLevelZero();
        }
        debugger.debug(inputType,linearHashing,doubleHashing);
    }
}
