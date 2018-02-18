package com.memento.model;

import java.util.List;

public class ResponseIcon {

    private List<RasterSize> raster_sizes;
    private int icon_id;

    public int getIcon_id() {
        return icon_id;
    }

    public void setIcon_id(int icon_id) {
        this.icon_id = icon_id;
    }

    public List<RasterSize> getRaster_sizes() {
        return raster_sizes;
    }

    public void setRaster_sizes(List<RasterSize> raster_sizes) {
        this.raster_sizes = raster_sizes;
    }

    /*

    raster_sizes
    styles
    tags
    icon_id
    vector_sizes
    is_premium
    published_at
    containers
    type
    categories
     */
}
