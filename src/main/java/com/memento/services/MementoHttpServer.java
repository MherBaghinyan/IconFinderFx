package com.memento.services;

import java.io.IOException;

/**
 * Created by Gebruiker on 2/15/2018.
 */
public interface MementoHttpServer {

        String call(String url) throws IOException;
}
