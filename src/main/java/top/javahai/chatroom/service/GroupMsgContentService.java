package top.javahai.chatroom.service;

import top.javahai.chatroom.entity.GroupMsgContent;
import top.javahai.chatroom.entity.RespPageBean;

import java.util.Date;
import java.util.List;

/**
 * (GroupMsgContent)表服务接口
 *
 * @author makejava
 * @since 2020-06-17 10:51:13
 */
public interface GroupMsgContentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    GroupMsgContent queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<GroupMsgContent> queryAllByLimit(Integer offset, Integer limit);

    /**
     * 新增数据
     *
     * @param groupMsgContent 实例对象
     * @return 实例对象
     */
    GroupMsgContent insert(GroupMsgContent groupMsgContent);

    /**
     * 修改数据
     *
     * @param groupMsgContent 实例对象
     * @return 实例对象
     */
    GroupMsgContent update(GroupMsgContent groupMsgContent);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    RespPageBean getAllGroupMsgContentByPage(Integer page, Integer size, String nickname, Integer type, Date[] dateScope);

    Integer deleteGroupMsgContentByIds(Integer[] ids);
}
