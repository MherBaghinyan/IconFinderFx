package com.memento.model;

import java.util.List;

/**
 * Created by Gebruiker on 2/18/2018.
 */
public class RasterSize {

    private short size_width;
    private short size_height;
    private short size;
    private List<Formats> formats;

    public short getSize_width() {
        return size_width;
    }

    public void setSize_width(short size_width) {
        this.size_width = size_width;
    }

    public short getSize_height() {
        return size_height;
    }

    public void setSize_height(short size_height) {
        this.size_height = size_height;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
    }

    public List<Formats> getFormats() {
        return formats;
    }

    public void setFormats(List<Formats> formats) {
        this.formats = formats;
    }
}
