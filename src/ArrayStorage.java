
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int lastIndex = 0;

    void clear() {
        //Вроде как в замечаниях к заданию так делать нельзя,
        //storage = new Resume[10000];
        //Пришлось переделать
        for (int i = 0; i < lastIndex; i++) {
            storage[i] = null;
        }
        lastIndex = 0;
    }

    void save(Resume r) {

        Resume currentResume;
        boolean resumeIsNew = true;

        //Проверяем, если резюме с таким uuid уже имеется в хранилище, то обновляем его
        for (int i = 0; i < lastIndex; i++) {
            currentResume= storage[i];
            if (currentResume.uuid.equals(r.uuid)){
                storage[i] = r;
                resumeIsNew = false;
                System.out.println("resume already exist");
                break;
            }
        }

        //Если резюме не было найдено, добавляем в хранилище
        if(resumeIsNew){
            storage[lastIndex] = r;
            lastIndex++;
        }

    }

    Resume get(String uuid) {

        Resume resume = null;
        Resume currentResume;

        for (int i = 0; i < lastIndex; i++) {
            currentResume= storage[i];
            if (currentResume.uuid.equals(uuid)){
                resume = currentResume;
                break;
            }
        }

        return resume;
    }

    void delete(String uuid) {


        Resume[] tempStorage = new Resume[10000];
        Resume currentResume;
        boolean deletedResumeIsFounded = false;
        int addedIndex = 0;

        for (int i = 0; i < lastIndex; i++) {
            currentResume= storage[i];
            if (currentResume.uuid.equals(uuid)){
                deletedResumeIsFounded = true;
                continue;
            }
            tempStorage[addedIndex] = currentResume;
            addedIndex ++;
        }

        if (deletedResumeIsFounded){
            this.storage = tempStorage;
            lastIndex--;
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] currentStorage = new Resume[lastIndex];

        for (int i = 0; i < lastIndex; i++) {
            currentStorage[i] = storage[i];
        }

        return currentStorage;
    }

    int size() {
        return lastIndex;
    }
}
