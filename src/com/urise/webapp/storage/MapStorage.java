package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage{
    private Map<String, Resume> map = new HashMap<>();

    @Override
    public void doSave(Resume resume, Object searchKey) {
        map.put((String)searchKey, resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object uuid) {
        map.put((String)uuid, resume);
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return map.get(searchKey);
    }

    @Override
    protected void doDelete(Object searchKey) {
        map.remove((String)searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        for(Map.Entry<String, Resume> pair: map.entrySet()){
            if (pair.getValue().getUuid().equals(uuid)){
                 return pair.getKey();
            }
        }
        return "notExist";
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey.equals("notExist");
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public int size() {
        return map.size();
    }
}
