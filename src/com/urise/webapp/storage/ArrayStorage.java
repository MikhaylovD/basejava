package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[3];
    private int lastIndex = 0;

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }

    public void update(Resume r) {
        int indexResume = checkResume(r.getUuid());
        if (indexResume == -1) {
            System.out.println("ERROR: Resume in not found");
        } else {
            storage[indexResume] = r;
        }
    }

    public void clear() {
        for (int i = 0; i < lastIndex; i++) {
            storage[i] = null;
        }
        lastIndex = 0;
    }

    public void save(Resume r) {
        if (size() == storage.length){
            System.out.println("ERROR: Storage is full");
            return;
        }
        if (checkResume(r.getUuid()) != -1) {
            System.out.println("ERROR: Resume already exist");
        } else {
            storage[lastIndex] = r;
            lastIndex++;
        }
    }

    public Resume get(String uuid) {
        int indexResume = checkResume(uuid);
        if (indexResume == -1) {
            System.out.println("ERROR: Resume in not found");
            return null;
        } else {
            return storage[indexResume];
        }
    }

    public void delete(String uuid) {
        int indexResume = checkResume(uuid);
        if (indexResume == -1) {
            System.out.println("ERROR: Resume in not exist");
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
        return Arrays.copyOf(storage,size());
    }

    //Если резюме есть в хранилище возвращаем его индекс
    public int checkResume(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return lastIndex;
    }
}
