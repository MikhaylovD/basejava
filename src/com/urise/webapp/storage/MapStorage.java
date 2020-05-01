package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage{
    private Map<Integer, Resume> map = new HashMap();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Resume[] getAll() {
        return map.values().toArray(new Resume[map.size()]);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    protected void updateResume(Resume resume, int indexResume) {
        map.put(indexResume, resume);
    }

    @Override
    protected Resume getResume(int indexResume) {
        return map.get(indexResume);
    }

    @Override
    protected int getIndex(String uuid) {
        for(Map.Entry<Integer, Resume> pair: map.entrySet()){
            if (pair.getValue().getUuid().equals(uuid)){
                 return pair.getKey();
            }
        }
        return -1;
    }

    @Override
    protected void saveResume(Resume resume) {
        doSave(resume);
    }

    @Override
    protected void doDeleteResume(int indexResume) {
        map.remove(indexResume);
    }

    @Override
    public void doSave(Resume resume) {
        map.put(map.size()+1, resume);
    }
}
