package com.razawiyah.nytimesarticles.apis;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseDefault {

    @SerializedName("results")
    private List<Article> results;

    public List<Article> getResults() {
        return results;
    }

    public void setResults(List<Article> results) {
        this.results = results;
    }

    public static class Article {

        @SerializedName("title")
        private String title;

        @SerializedName("abstract")
        private String abstractText;
        @SerializedName("url")
        private String url;
        @SerializedName("byline")
        private String byline;
        @SerializedName("published_date")
        private String published_date;

        @SerializedName("multimedia")
        private List<Media> media;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAbstractText() {
            return abstractText;
        }

        public void setAbstractText(String abstractText) {
            this.abstractText = abstractText;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getByline() {
            return byline;
        }

        public void setByline(String byline) {
            this.byline = byline;
        }

        public String getPublished_date() {
            return published_date;
        }

        public void setPublished_date(String published_date) {
            this.published_date = published_date;
        }

        public List<Media> getMedia() {
            return media;
        }

        public void setMedia(List<Media> media) {
            this.media = media;
        }

        public static class Media {

            @SerializedName("url")
            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
