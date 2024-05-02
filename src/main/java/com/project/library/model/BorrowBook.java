package com.project.library.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowBook {
    long bookId;
    long userId;

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
