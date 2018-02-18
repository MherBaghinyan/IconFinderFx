package com.memento.services;

import com.memento.model.Icon;
import com.memento.model.MementoResponseModel;

import java.util.List;
import java.util.Optional;

public interface MementoSearchService {

    Optional<MementoResponseModel> search(String query);
}
