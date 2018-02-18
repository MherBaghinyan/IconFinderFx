package com.memento.model;

/**
 * Created by Gebruiker on 2/18/2018.
 */
public class Formats {

    private String preview_url;
    private String download_url;
    private String format;

    public String getPreview_url() {
        return preview_url;
    }

    public void setPreview_url(String preview_url) {
        this.preview_url = preview_url;
    }

    public String getDownload_url() {
        return download_url;
    }

    public void setDownload_url(String download_url) {
        this.download_url = download_url;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "Formats{" +
                "preview_url='" + preview_url + '\'' +
                ", download_url='" + download_url + '\'' +
                ", format='" + format + '\'' +
                '}';
    }
}
