package dao;

import bean.Lock;

/**
 * @author qby
 * @date 2020/7/18 13:35
 */
public interface LockDao {
    // 查询锁的时候将所有钥匙查询出来
    public Lock getLockById(Integer id);
}
