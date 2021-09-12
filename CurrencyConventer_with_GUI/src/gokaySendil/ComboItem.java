package gokaySendil;

public class ComboItem {
    private String key;
    private String value;
    public ComboItem(String value,String key){
        this.value=value;
        this.key=key;
    }
    public String toString(){
        return key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
