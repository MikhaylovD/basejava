package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {
    private static  final Comparator<Resume> RESUME_COMPARATOR = new Comparator<Resume>(){
        @Override
        public int compare(Resume o1, Resume o2) {
            return o1.getUuid().compareTo(o2.getUuid());
        }
    };

    @Override
    protected Object getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid);
        return Arrays.binarySearch(storage, 0, size(), searchKey, RESUME_COMPARATOR);
    }

    @Override
    protected void saveResume(Resume resume, Object indexResume) {
        int pastedIndex = -(Integer) indexResume - 1;
        System.arraycopy(storage, pastedIndex, storage, pastedIndex + 1, lastIndex - pastedIndex);
        storage[pastedIndex] = resume;
    }

    @Override
    protected void deleteResume(Integer indexResume) {
        System.arraycopy(storage, indexResume + 1, storage, indexResume, lastIndex - indexResume - 1);
    }
}
