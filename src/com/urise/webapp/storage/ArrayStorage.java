package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    //Если резюме есть в хранилище возвращаем его индекс

    protected int getIndex(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume) {
        storage[lastIndex] = resume;
    }

    @Override
    protected void deleteResume(int indexResume) {
        storage[indexResume] = storage[lastIndex - 1];
    }
}
