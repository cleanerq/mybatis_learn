package bean;

/**
 * 钥匙
 */
public class Key {
    private Integer id;
    private String keyName;
    private Integer lockid;

    private Lock lock;

    public Integer getLockid() {
        return lockid;
    }

    public void setLockid(Integer lockid) {
        this.lockid = lockid;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", keyName='" + keyName + '\'' +
                ", lockid=" + lockid +
                ", lock=" + lock +
                '}';
    }
}
