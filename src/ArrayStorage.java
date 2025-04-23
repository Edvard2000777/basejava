import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int maxNum = 0;

    void clear() {
        storage = new Resume[0];
    }

    void save(Resume r) {
        if (r == null) throw new
                IllegalArgumentException("resume is null");
        maxNum = maxNum + 1;
        if (maxNum == 0) storage[0] = r;
        else storage[maxNum] = r;
    }

    String get(String uuid) {
        for (int i = 0; i < maxNum; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i].toString();
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < maxNum; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[maxNum - 1];
                storage[maxNum - 1] = null;
                maxNum--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[maxNum];
        for (int i = 0; i < maxNum; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return maxNum;
    }

    @Override
    public String toString() {
        return Arrays.toString(storage);
    }
}