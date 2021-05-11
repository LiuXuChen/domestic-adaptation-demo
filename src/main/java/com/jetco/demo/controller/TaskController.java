package com.jetco.demo.controller;


import com.jetco.demo.entity.Task;
import com.jetco.demo.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 任务表 前端控制器
 * </p>
 *
 * @author lhw
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/task")
@Api(tags = "任务服务接口API", value = "任务服务接口API")
public class TaskController {

    @Resource
    private TaskService taskService;

    @PostMapping(value = "/save")
    @ApiOperation(value = "保存任务")
    public String save(Task task){
        int count = taskService.saveTask(task);
        if(count > 0) {
            return "保存成功！";
        } else {
            return "保存失败！";
        }
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "删除任务")
    public String delete(String taskId){
        int count = taskService.deleteByTaskId(taskId);
        if(count > 0) {
            return "删除成功！";
        } else {
            return "删除失败！";
        }
    }

    @GetMapping(value = "/queryTaskByTaskId")
    @ApiOperation(value = "根据任务id查询任务")
    public Task queryTaskByTaskId(String taskId){
        return taskService.queryTaskByTaskId(taskId);
    }

}
