package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NonExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public void doSave(Resume resume) {
        list.add(resume);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    protected void updateResume(Resume resume, int indexResume) {
        list.add(indexResume, resume);
    }

    @Override
    protected Resume getResume(int indexResume) {
        return list.get(indexResume);
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume) {
        list.add(resume);
    }

    @Override
    protected void doDeleteResume(int indexResume) {
        list.remove(indexResume);
    }
}
