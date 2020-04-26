package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    public void update(Resume resume) {
        int indexResume = getIndex(resume.getUuid());
        if (indexResume == -1) {
            System.out.println("ERROR: Resume uuid: " + resume.getUuid() + " is not found");
        } else {
            storage[indexResume] = resume;
        }
    }

    public void clear() {
        Arrays.fill(storage, 0, lastIndex, null);
        lastIndex = 0;
    }

    public void save(Resume resume) {
        if (lastIndex == STORAGE_LIMIT) {
            System.out.println("ERROR: Storage is full");
            return;
        }
        if (getIndex(resume.getUuid()) != -1) {
            System.out.println("ERROR: Resume uuid: " + resume.getUuid() + " already exist");
        } else {
            storage[lastIndex] = resume;
            lastIndex++;
        }
    }

    public void delete(String uuid) {
        int indexResume = getIndex(uuid);
        if (indexResume == -1) {
            System.out.println("ERROR: Resume uuid: " + uuid + " is not exist");
        } else {
            storage[indexResume] = storage[lastIndex - 1];
            storage[lastIndex - 1] = null;
            lastIndex--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, lastIndex);
    }

    //Если резюме есть в хранилище возвращаем его индекс
    protected int getIndex(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
