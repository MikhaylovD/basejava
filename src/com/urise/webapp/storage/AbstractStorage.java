package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOGGER = Logger.getLogger(AbstractStorage.class.getName());

    @Override
    public void save(Resume resume) {
        LOGGER.info("Save " + resume);
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        doSave(resume, searchKey);
    }

    @Override
    public void update(Resume resume) {
        LOGGER.info("Update " + resume);
        SK searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(resume, searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOGGER.info("Get " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        doDelete(searchKey);
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOGGER.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOGGER.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOGGER.info("getAllSorted");
        List<Resume> resumes = getAllList();
        Collections.sort(resumes);
        return resumes;
    }

    protected abstract void doSave(Resume resume, SK searchKey);

    protected abstract void doUpdate(Resume resume, SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract void doDelete(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract List<Resume> getAllList();
}
