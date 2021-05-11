package com.jetco.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jetco.demo.entity.Task;
import com.jetco.demo.exception.NotFoundException;
import com.jetco.demo.mapper.TaskMapper;
import com.jetco.demo.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 任务表 服务实现类
 * </p>
 *
 * @author lhw
 * @since 2021-05-10
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

    @Resource
    private TaskMapper taskMapper;

    /**
     * 根据任务ID查询任务
     * @param taskId 任务ID
     * @return {@link Task}
     */
    @Override
    public Task queryTaskByTaskId(String taskId) {
        return Optional.of(taskMapper.selectById(taskId)).orElseThrow(()-> new NotFoundException(String.format("%s没找到对应的任务", taskId)));
    }


    /**
     * 根据任务ID批量查询任务
     * @param taskIds 任务ID
     * @return {@link Task}
     */
    @Override
    public List<Task> queryTaskByTaskIds(List<String> taskIds) {
        return taskMapper.selectBatchIds(taskIds);
    }

    /**
     * 更新一条记录
     * @param task {@link Task}
     * @return 修改总数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int updateTask(Task task) {
        return taskMapper.updateById(task);
    }

    /**
     * 根据任务ID删除任务
     * @param taskId 任务ID
     * @return 删除总数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int deleteByTaskId(String taskId) {
        return taskMapper.deleteById(taskId);
    }

    /**
     * 新增任务记录
     * @param task {@link Task}
     * @return 保存总数
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int saveTask(Task task) {
        return taskMapper.insert(task);
    }


}
