package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class obligation {
    private final SimpleStringProperty ob;
    private final SimpleIntegerProperty nal;

    public obligation(String ob, Integer nal) {
        this.ob = new SimpleStringProperty(ob);
        this.nal = new SimpleIntegerProperty(nal);
    }

    public String getOb() {
        return this.ob.get();
    }

    public void setOb(String ob) {
        this.setOb(ob);
    }

    public void setNal(String nal) {
        this.setNal(nal);
    }

    public Integer getNal() {
        return this.nal.get();
    }
}
