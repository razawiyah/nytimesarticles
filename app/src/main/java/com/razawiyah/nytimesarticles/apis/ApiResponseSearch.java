package com.razawiyah.nytimesarticles.apis;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseSearch {

    @SerializedName("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public static class Response {
        @SerializedName("docs")
        private List<Article> docs;

        public List<Article> getDocs() {
            return docs;
        }

        public void setDocs(List<Article> docs) {
            this.docs = docs;
        }
    }

    public static class Article {

        @SerializedName("abstract")
        private String abstractText;

        @SerializedName("web_url")
        private String url;

        @SerializedName("snippet")
        private String snippet;

        @SerializedName("lead_paragraph")
        private String leadParagraph;

        @SerializedName("source")
        private String source;

        @SerializedName("pub_date")
        private String pub_date;

        @SerializedName("multimedia")
        private List<Media> multimedia;

        public String getPub_date() {
            return pub_date;
        }

        public void setPub_date(String pub_date) {
            this.pub_date = pub_date;
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

        public String getSnippet() {
            return snippet;
        }

        public void setSnippet(String snippet) {
            this.snippet = snippet;
        }

        public String getLeadParagraph() {
            return leadParagraph;
        }

        public void setLeadParagraph(String leadParagraph) {
            this.leadParagraph = leadParagraph;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public List<Media> getMultimedia() {
            return multimedia;
        }

        public void setMultimedia(List<Media> multimedia) {
            this.multimedia = multimedia;
        }

        public static class Media {

            @SerializedName("url")
            private String url;

            @SerializedName("subtype")
            private String subtype;

            @SerializedName("type")
            private String type;

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

            public String getSubtype() {
                return subtype;
            }

            public void setSubtype(String subtype) {
                this.subtype = subtype;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
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

