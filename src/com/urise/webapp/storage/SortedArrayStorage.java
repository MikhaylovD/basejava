package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "dummy");
        return Arrays.binarySearch(storage, 0, size(), searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void saveResume(Resume resume, int indexResume) {
        int pastedIndex = -indexResume - 1;
        System.arraycopy(storage, pastedIndex, storage, pastedIndex + 1, lastIndex - pastedIndex);
        storage[pastedIndex] = resume;
    }

    @Override
    protected void deleteResume(Integer indexResume) {
        System.arraycopy(storage, indexResume + 1, storage, indexResume, lastIndex - indexResume - 1);
    }
}
