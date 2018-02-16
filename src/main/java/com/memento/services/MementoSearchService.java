package com.memento.services;

import com.memento.model.Icon;

import java.util.List;

public interface MementoSearchService {

    List<Icon> search(String query);
}
