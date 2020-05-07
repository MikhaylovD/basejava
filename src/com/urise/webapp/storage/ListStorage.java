package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    public void doSave(Resume resume, Object indexResume) {
        list.add(resume);
    }

    @Override
    protected void doUpdate(Resume resume, Object indexResume) {
        list.add((Integer) indexResume, resume);
    }

    @Override
    protected Resume doGet(Object indexResume) {
        return list.get((Integer) indexResume);
    }

    @Override
    protected void doDelete(Object indexResume) {
        list.remove((int) indexResume);
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
    protected Object getSearchKey(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }
}
