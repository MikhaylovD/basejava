package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> list = new ArrayList<>();

    @Override
    public void doSave(Resume resume, Integer indexResume) {
        list.add(resume);
    }

    @Override
    protected void doUpdate(Resume resume, Integer indexResume) {
        list.add(indexResume, resume);
    }

    @Override
    protected Resume doGet(Integer indexResume) {
        return list.get(indexResume);
    }

    @Override
    protected void doDelete(Integer indexResume) {
        list.remove(indexResume.intValue());
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public List<Resume> getAllList() {
        return list;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }
}
