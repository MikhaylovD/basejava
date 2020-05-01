package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NonExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 1000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int lastIndex = 0;

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex);
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }

    @Override
    public void updateResume(Resume resume, int indexResume) {
        storage[indexResume] = resume;
    }

    @Override
    protected Resume getResume(int indexResume) {
        return storage[indexResume];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(int indexResume);

    @Override
    public void doDeleteResume(int indexResume) {
        deleteResume(indexResume);
        storage[lastIndex - 1] = null;
        lastIndex--;
    }

    @Override
    public void doSave(Resume resume) {
        if (lastIndex == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        saveResume(resume);
        lastIndex++;
    }
}
