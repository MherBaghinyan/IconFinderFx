package com.memento.model;

import java.util.List;
import java.util.Optional;

public class MementoResponseModel {

    private int total_count;

    private List<ResponseIcon> icons;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public Optional<List<ResponseIcon>> getIcons() {
        return Optional.of(icons);
    }

    public void setIcons(List<ResponseIcon> icons) {
        this.icons = icons;
    }
}
