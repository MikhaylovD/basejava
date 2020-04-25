package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[3];
    private int lastIndex = 0;

    public void update(Resume resume) {
        int indexResume = checkResume(resume.getUuid());
        if (indexResume == -1) {
            System.out.println("ERROR: Resume uuid: " + resume.getUuid() + " is not found");
        } else {
            storage[indexResume] = resume;
        }
    }

    public void clear() {
        Arrays.fill(storage, null);
        lastIndex = 0;
    }

    public void save(Resume resume) {
        if (lastIndex == storage.length) {
            System.out.println("ERROR: Storage is full");
            return;
        }
        if (checkResume(resume.getUuid()) != -1) {
            System.out.println("ERROR: Resume uuid: " + resume.getUuid() + " already exist");
        } else {
            storage[lastIndex] = resume;
            lastIndex++;
        }
    }

    public Resume get(String uuid) {
        int indexResume = checkResume(uuid);
        if (indexResume == -1) {
            System.out.println("ERROR: Resume uuid: " + uuid + " is not found");
            return null;
        }
        return storage[indexResume];
    }

    public void delete(String uuid) {
        int indexResume = checkResume(uuid);
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
        return Arrays.copyOf(storage, size());
    }

    //Если резюме есть в хранилище возвращаем его индекс
    private int checkResume(String uuid) {
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
