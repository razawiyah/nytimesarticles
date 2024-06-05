package com.razawiyah.nytimesarticles.apis;

import java.util.List;

public class ApiResponse {

    public String status;
    public List<Article> results;

    public static class Article {
        public String title;
        public String abstracts;
        public String url;
        public String byline;
        public String published_date;
    }
}
