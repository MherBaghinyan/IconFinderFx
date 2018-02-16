package com.memento.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Icon {
    private final StringProperty name;
    private final StringProperty url;


    public Icon(String name, String url) {
        this.name = new SimpleStringProperty(name);
        this.url = new SimpleStringProperty(url);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getUrl() {
        return url.get();
    }

    public StringProperty urlProperty() {
        return url;
    }

    public void setUrl(String url) {
        this.url.set(url);
    }
}
