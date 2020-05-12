package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {
    protected Map<String, Resume> map = new HashMap<>();

    @Override
    public void doSave(Resume resume, String searchKey) {
        map.put(searchKey, resume);
    }

    @Override
    protected void doUpdate(Resume resume, String uuid) {
        map.put(uuid, resume);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(String searchKey) {
        map.remove(searchKey);
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey(searchKey);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllList() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
