package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

abstract class AbstractMapStorage extends AbstractStorage {
    protected Map<String, Resume> map = new HashMap<>();

    @Override
    public void doSave(Resume resume, Object searchKey) {
        map.put(getMapKey(resume.getUuid()), resume);
    }

    protected abstract String getMapKey(String uuid);

    @Override
    protected void doUpdate(Resume resume, Object uuid) {
        map.put((String) uuid, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove((String) searchKey);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllList() {
        List<Resume> resumes = new ArrayList<>(map.values());
        return resumes;
    }

    @Override
    public int size() {
        return map.size();
    }
}
