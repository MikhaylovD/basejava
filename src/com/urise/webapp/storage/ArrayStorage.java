package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    //Если резюме есть в хранилище возвращаем его индекс
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume, Object indexResume) {
        storage[lastIndex] = resume;
    }

    @Override
    protected void deleteResume(Integer indexResume) {
        storage[indexResume] = storage[lastIndex - 1];
    }
}
