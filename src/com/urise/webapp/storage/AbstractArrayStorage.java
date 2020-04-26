package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NonExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 1000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int lastIndex = 0;

    public void save(Resume resume) {
        if (lastIndex == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        }
        if (getIndex(resume.getUuid())  >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            saveResume(resume);
            lastIndex++;
        }
    }

    public void update(Resume resume) {
        int indexResume = getIndex(resume.getUuid());
        if (indexResume < 0) {
            throw new NonExistStorageException(resume.getUuid());
        } else {
            storage[indexResume] = resume;
        }
    }

    public void delete(String uuid) {
        int indexResume = getIndex(uuid);
        if (indexResume < 0) {
            throw new NonExistStorageException(uuid);
        } else {
            deleteResume(indexResume);
            storage[lastIndex - 1] = null;
            lastIndex--;
        }
    }

    public int size() {
        return lastIndex;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex);
    }

    public void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }

    public Resume get(String uuid) {
        int indexResume = getIndex(uuid);
        if (indexResume < 0) {
            throw new NonExistStorageException(uuid);
        }
        return storage[indexResume];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(int indexResume);
}
