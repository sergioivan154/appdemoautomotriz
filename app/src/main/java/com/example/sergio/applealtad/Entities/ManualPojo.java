package com.example.sergio.applealtad.Entities;

public class ManualPojo {
    private String urlVideo;
    private String tituloVideo;

    public String getUrlVideo() {
        return urlVideo;
    }

    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    public String getTituloVideo() {
        return tituloVideo;
    }

    public void setTituloVideo(String tituloVideo) {
        this.tituloVideo = tituloVideo;
    }

    public ManualPojo(String urlVideo, String tituloVideo) {
        this.urlVideo = urlVideo;
        this.tituloVideo = tituloVideo;
    }
}
