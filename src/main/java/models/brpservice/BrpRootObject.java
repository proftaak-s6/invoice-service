package models.brpservice;

public class BrpRootObject {
    private Data data;

    public BrpRootObject() {
    }

    public BrpRootObject(Data data) {
        this.data = data;
    }

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" + " data='" + getData() + "'" + "}";
    }

}