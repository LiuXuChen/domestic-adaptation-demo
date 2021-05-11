package com.jetco.demo.service;

import com.jetco.demo.entity.Task;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 任务表 服务类
 * </p>
 *
 * @author lhw
 * @since 2021-05-10
 */
public interface TaskService extends IService<Task> {

    /**
     * 根据任务ID查询任务
     * @param taskId 任务ID
     * @return {@link Task}
     */
    Task queryTaskByTaskId(String taskId);

    /**
     * 根据任务ID批量查询任务
     * @param taskIds 任务ID
     * @return {@link Task}
     */
    List<Task> queryTaskByTaskIds(List<String> taskIds);

    /**
     * 更新一条记录
     * @param task {@link Task}
     * @return 修改总数
     */
    int updateTask(Task task);

    /**
     * 根据任务ID删除任务
     * @param taskId 任务ID
     * @return 删除总数
     */
    int deleteByTaskId(String taskId);

    /**
     * 新增任务记录
     * @param task {@link Task}
     * @return 保存总数
     */
    int saveTask(Task task);

}
