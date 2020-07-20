package dao;

import bean.Key;

import java.util.List;

public interface KeyDao {

    /**
     * 查询时 将钥匙和锁子一起查询
     * @param id
     * @return
     */
    public Key getKeyById(Integer id);

    public Key getKeyByIdSimple(Integer id);

    public List<Key> getKeysByLockId(Integer id);
}
