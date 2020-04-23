
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
        boolean resumeIsNew = true;

        //Проверяем, если резюме с таким uuid уже имеется в хранилище, то обновляем его
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                storage[i] = r;
                resumeIsNew = false;
                System.out.println("resume already exist");
                break;
            }
        }
        //Если резюме не было найдено, добавляем в хранилище
        if (resumeIsNew) {
            storage[lastIndex] = r;
            lastIndex++;
        }
    }

    Resume get(String uuid) {
        Resume resume = null;

        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                resume = storage[i];
                break;
            }
        }
        return resume;
    }

    void delete(String uuid) {
        for (int i = 0; i < lastIndex; i++) {
            if (storage[i].uuid.equals(uuid)) {
                //Заменяем удаляемый элемент последним элементом, чтобы избежать "дырки" в середине
                storage[i] = storage[lastIndex - 1];
                storage[lastIndex - 1] = null;
                //Уменьшаем количество заполненных элементов (size) массива
                lastIndex--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[lastIndex];

        for (int i = 0; i < lastIndex; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return lastIndex;
    }
}
