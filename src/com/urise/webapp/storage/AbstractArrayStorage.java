package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 1000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int lastIndex = 0;

    public int size() {
        return lastIndex;
    }

    public Resume get(String uuid) {
        int indexResume = getIndex(uuid);
        if (indexResume == -1) {
            System.out.println("ERROR: Resume uuid: " + uuid + " is not found");
            return null;
        }
        return storage[indexResume];
    }

    protected abstract int getIndex(String uuid);
}
