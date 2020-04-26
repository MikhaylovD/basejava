package com.urise.webapp.exception;

public class NonExistStorageException extends StorageException{
    public NonExistStorageException(String uuid) {
        super("Resume " + uuid + " is not exist", uuid);
    }
}
