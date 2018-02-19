package com.memento.services;

import com.memento.model.MementoResponseModel;
import com.memento.model.MementoResponseParser;
import com.memento.rest.IconFinderUtils;

import java.io.IOException;
import java.util.Optional;

public class MementoSearchServiceImpl implements MementoSearchService {

    private MementoHttpServer mementoHttpServer;

    public MementoSearchServiceImpl() {

        if (mementoHttpServer == null) {
            mementoHttpServer = new MementoHttpServiceImpl();
        }
    }

    @Override
    public Optional<MementoResponseModel> search(String query, int pageNumber) {

        try {
            String url = "https://api.iconfinder.com/v3/iconsets?client_id=" +
                    IconFinderUtils.CLIENT_ID +
                    "&client_secret=" +
                    IconFinderUtils.CLIENT_SECRET;

            //String authenticate = mementoHttpServer.authenticate();

            //String response = mementoHttpServer.call(url);

            MementoResponseModel model = new MementoResponseParser().jsonToModel();

            return Optional.of(model);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
