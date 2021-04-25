package com.tutorial.graphql.graphqltutorial.constant;

public final class DataLoaderName {

    public static final String BOOKS_BY_AUTHOR_IDS = "BOOKS_BY_AUTHOR_IDS";
    public static final String AUTHORS_BY_BOOK_IDS = "AUTHORS_BY_BOOK_IDS";
    public static final String REVIEWS_BY_BOOK_IDS = "REVIEWS_BY_BOOK_IDS";
    public static final String REVIEWS_BY_USER_IDS = "REVIEW_BY_USER_IDS";
    public static final String BOOKS_BY_REVIEW_IDS = "BOOKS_BY_REVIEW_IDS";
    public static final String USERS_BY_REVIEW_IDS = "USER_BY_REVIEW_IDS";

    private DataLoaderName() {
        throw new UnsupportedOperationException();
    }
}
