package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

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
        saveResume(resume, (Integer) indexResume);
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
    public List<Resume> getAllList() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, lastIndex));
    }

    @Override
    public int size() {
        return lastIndex;
    }

    @Override
    protected boolean isExist(Object index) {
        return (Integer) index >= 0;
    }

    protected abstract void saveResume(Resume resume, int indexResume);

    protected abstract void deleteResume(Integer indexResume);
}
