package com.jetco.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jetco.demo.entity.Flow;
import com.jetco.demo.service.FlowService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flow")
@Api(tags = "业务流程服务接口API", value = "业务流程服务接口API")
public class FlowController {

    @Resource
    private FlowService flowService;

    @RequestMapping(value = "/queryAllFlow", method = RequestMethod.POST)
    @ApiOperation(value = "查询所有业务作为下拉框的数据")
    public List<Map<String,Object>> queryAllFlow(){
        return  flowService.queryAllFlow();
    }

    @RequestMapping(value = "/queryFlowByPage", method = RequestMethod.POST)
    @ApiOperation(value = "分页查询业务流程列表信息")
    public IPage<Flow> queryFlowByPage(Flow flow, int page, int limit){
        return flowService.queryFlowByTj(flow,page,limit);
    }

    @ApiOperation(value = "分页查询业务流程列表信息")
    @RequestMapping(value = "/queryFlowList", method = RequestMethod.POST)
    public IPage<Flow> queryFlowList(Flow flow, int page , int limit){
        return flowService.queryFlow(flow,page,limit);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiOperation("新增或修改业务流程信息")
    public boolean addFlow(Flow flow){
        return flowService.addFlow(flow);
    }

    @ApiOperation(value = "删除业务流程信息")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean deleteFlow(@RequestBody List<String> ids){
        return flowService.deleteFlow(ids);
    }

}
