package hash_tables;

public class HashObject {
    private Object key;
    int frequency,probe;

    /**
     * @param key the element we want to store
     */
     HashObject(Object key){
        this.key   = key;
        this.frequency=0;
        this.probe=0;
    }

    public Object getKey(){
        return this.key;
    }
    public int getFrequency(){return this.frequency;}
    public int getProbe(){return this.probe;}
    public void incrementProbe(){
        this.probe++;
    }
    public void incrementFrequency(){
        this.frequency++;
    }
}
