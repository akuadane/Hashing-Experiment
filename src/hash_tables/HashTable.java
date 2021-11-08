package hash_tables;

abstract public class HashTable {
     HashObject[] hashTable;
     int size;
     double loadFactor;

     protected int numItems=0,numProbes=0,duplicates=0;

    HashTable(int size,double loadFactor){
        this.size=size;
        this.loadFactor= loadFactor;
        this.hashTable = new HashObject[size];
    }
    protected int positiveMod(int dividend, int divisor){
       int value = dividend % divisor;

       if(value<0)
           value += divisor;

       return value;
    }

    abstract public int insert(Object key);
    abstract void delete(Object key);
    abstract int search(Object key);

    public int getSize(){return this.size;}
    public int getNumItems(){return this.numItems;}
    public double getLoadFactor(){return this.loadFactor;}
    public int getDuplicates(){return  this.duplicates;}
    public HashObject getItem(int index){return (index<this.size)? this.hashTable[index]: null;}
}
