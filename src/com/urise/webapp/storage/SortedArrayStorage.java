package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size(), searchKey);
    }

    @Override
    protected void saveResume(Resume resume) {
        int pastedIndex = -getIndex(resume.getUuid())-1;
        System.arraycopy(storage, pastedIndex, storage, pastedIndex + 1, lastIndex - pastedIndex);
        storage[pastedIndex] = resume;
    }

    @Override
    protected void deleteResume(int indexResume) {
        System.arraycopy(storage, indexResume+1, storage, indexResume, lastIndex - indexResume-1);

    }
}
