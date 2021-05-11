package com.jetco.demo.mapper;

import com.jetco.demo.entity.Task;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 任务表 Mapper 接口
 * </p>
 *
 * @author lhw
 * @since 2021-05-10
 */
@Mapper
public interface TaskMapper extends BaseMapper<Task> {



}
