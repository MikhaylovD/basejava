package com.urise.webapp.storage;

import com.urise.webapp.exception.NonExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage{
    @Override
    public abstract void save(Resume r);

    @Override
    public void update(Resume resume){
        int indexResume = getIndex(resume.getUuid());
        if (indexResume < 0) {
            throw new NonExistStorageException(resume.getUuid());
        } else {
            updateResume(resume, indexResume);
        }
    }

    @Override
    public Resume get(String uuid){
        int indexResume = getIndex(uuid);
        if (indexResume < 0) {
            throw new NonExistStorageException(uuid);
        }
        return getResume(indexResume);
    }

    @Override
    public void delete(String uuid){
        int indexResume = getIndex(uuid);
        if (indexResume < 0) {
            throw new NonExistStorageException(uuid);
        } else {
            doDeleteResume(indexResume);
        }
    }

    @Override
    public abstract int size();

    @Override
    public abstract Resume[] getAll();

    @Override
    public abstract void clear();

    protected abstract void updateResume(Resume resume, int indexResume);

    protected abstract Resume getResume(int indexResume);

    protected abstract int getIndex(String uuid);

    protected abstract void saveResume(Resume resume);

    protected abstract void doDeleteResume(int indexResume);
}
