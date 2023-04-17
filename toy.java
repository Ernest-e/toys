package toys;

public class toy {
    protected int id;
    protected String name;
    protected int count;
    
    protected int frequency;


    public toy(int id, String name, int count, int frequency) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.frequency = frequency;
    }
    
    public int getCount() {
        return count;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    
    public void takeWin() {
        this.count -= 1;
    }

    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
}