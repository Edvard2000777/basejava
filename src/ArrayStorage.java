import java.util.Arrays;
import java.util.UUID;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private static int counter = 0;

    void clear() {
        for (int i = 0; i < counter; i++) {
            storage = new Resume[0];
        }
        counter = 0;
    }

    void save(Resume r) {
        if (r == null) throw new
                IllegalArgumentException("resume is null");
        if (counter == 0) storage[0] = r;
        else storage[counter] = r;
        counter++;

    }

    String get(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                return this.storage[i].toString();
            }
        }
        return null;
    }

    void delete(String uuid) {

        for (int i = 0; i < counter; i++) {
            if (this.storage[i].uuid.equals(uuid)) {
                storage[i] = storage[i - 1];
                storage[i - 1] = null;
                counter--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[counter];
        for (int i = 0; i < counter; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {

        return counter;
    }

    @Override
    public String toString() {
        return Arrays.toString(storage);
    }
}