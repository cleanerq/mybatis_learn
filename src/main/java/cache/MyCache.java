package cache;

import org.apache.ibatis.cache.Cache;

import java.util.concurrent.locks.ReadWriteLock;

/**
 * @author qby
 * @date 2020/7/19 11:06
 */
public class MyCache implements Cache {

    @Override
    public String getId() {
        return null;
    }

    @Override
    public void putObject(Object key, Object value) {
        // 放在专业的缓存里面
    }

    @Override
    public Object getObject(Object key) {
        return null;
    }

    @Override
    public Object removeObject(Object key) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return null;
    }
}
