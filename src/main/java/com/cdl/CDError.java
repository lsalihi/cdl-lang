package com.cdl;

public class CDError {
    public enum Code {
        DUPLICATE_ID("E001", "Duplicate ID"),
        INVALID_TYPE("E002", "Invalid type"),
        MISSING_EVIDENCE("E003", "Missing evidence");

        private final String code;
        private final String message;

        Code(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() { return code; }
        public String getMessage() { return message; }
    }

    private final Code code;
    private final String message;
    private final int line;
    private final int column;

    public CDError(Code code, String details, int line, int column) {
        this.code = code;
        this.message = code.getMessage() + ": " + details;
        this.line = line;
        this.column = column;
    }

    public String toString() {
        return String.format("[%s] %s at %d:%d", code.getCode(), message, line, column);
    }
}
