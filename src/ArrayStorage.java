import java.util.UUID;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        storage = new Resume[10000];
    }

    void save(Resume r) {
        r.uuid = UUID.randomUUID().toString();
    }

    String get(String uuid) {

        return uuid;
    }

    void delete(String uuid) {

        uuid = uuid == null ? "" : uuid;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        return new Resume[0];
    }

    int size() {

        return storage.length;
    }
}