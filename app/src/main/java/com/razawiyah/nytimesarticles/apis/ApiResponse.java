package com.razawiyah.nytimesarticles.apis;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {

    @SerializedName("status")
    private String status;

    @SerializedName("results")
    private List<Article> results;

    @SerializedName("num_results")
    private int num_results;

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

        @SerializedName("media")
        private List<Media> media;

        public List<Media> getMedia() {
            return media;
        }

        public void setMedia(List<Media> media) {
            this.media = media;
        }

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

        public static class Media {

            @SerializedName("type")
            private String type;

            @SerializedName("subtype")
            private String subtype;

            @SerializedName("caption")
            private String caption;

            @SerializedName("media-metadata")
            private List<MediaMetadata> mediaMetadata;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public String getCaption() {
                return caption;
            }

            public void setCaption(String caption) {
                this.caption = caption;
            }

            public List<MediaMetadata> getMediaMetadata() {
                return mediaMetadata;
            }

            public void setMediaMetadata(List<MediaMetadata> mediaMetadata) {
                this.mediaMetadata = mediaMetadata;
            }

            public static class MediaMetadata {

                @SerializedName("url")
                private String url;

                @SerializedName("format")
                private String format;

                @SerializedName("height")
                private int height;

                @SerializedName("width")
                private int width;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getFormat() {
                    return format;
                }

                public void setFormat(String format) {
                    this.format = format;
                }

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
                }

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }
            }
        }
    }
}
