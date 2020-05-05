package com.urise.webapp.storage;

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
    public void doSave(Resume resume, Object indexResume) {
        if (lastIndex == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        saveResume(resume, indexResume);
        lastIndex++;
    }

    @Override
    public void doUpdate(Resume resume, Object indexResume) {
        storage[(Integer) indexResume] = resume;
    }

    @Override
    protected Resume doGet(Object indexResume) {
        return storage[(Integer) indexResume];
    }

    @Override
    protected void doDelete(Object indexResume) {
        deleteResume((Integer) indexResume);
        storage[lastIndex - 1] = null;
        lastIndex--;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }

    @Override
    public Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex);
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract Object getSearchKey(String uuid);

    protected abstract void saveResume(Resume resume, Object indexResume);

    protected abstract void deleteResume(Integer indexResume);

}
