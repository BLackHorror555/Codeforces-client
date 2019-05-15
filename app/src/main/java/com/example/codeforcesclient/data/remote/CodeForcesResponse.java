package com.example.codeforcesclient.data.remote;

public class CodeForcesResponse<T> {
    private String status;
    private String comment;
    private T result;

    public CodeForcesResponse(String aStatus, String aComment, T aResult) {
        status = aStatus;
        comment = aComment;
        result = aResult;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String aStatus) {
        status = aStatus;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String aComment) {
        comment = aComment;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T aResult) {
        result = aResult;
    }
}
