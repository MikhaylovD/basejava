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

    public void save(Resume resume) {
        if (lastIndex == STORAGE_LIMIT) {
            System.out.println("ERROR: Storage is full");
            return;
        }
        if (getIndex(resume.getUuid())  >= 0) {
            System.out.println("ERROR: Resume uuid: " + resume.getUuid() + " already exist");
        } else {
            saveResume(resume);
            lastIndex++;
        }
    }

    public void update(Resume resume) {
        int indexResume = getIndex(resume.getUuid());
        if (indexResume == -1) {
            System.out.println("ERROR: Resume uuid: " + resume.getUuid() + " is not found");
        } else {
            storage[indexResume] = resume;
        }
    }

    public void delete(String uuid) {
        int indexResume = getIndex(uuid);
        if (indexResume < 0) {
            System.out.println("ERROR: Resume uuid: " + uuid + " is not exist");
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
        if (indexResume == -1) {
            System.out.println("ERROR: Resume uuid: " + uuid + " is not found");
            return null;
        }
        return storage[indexResume];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void saveResume(Resume resume);

    protected abstract void deleteResume(int indexResume);
}
