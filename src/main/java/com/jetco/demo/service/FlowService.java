package com.jetco.demo.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jetco.demo.entity.Flow;
import com.jetco.demo.mapper.FlowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class FlowService extends ServiceImpl<FlowMapper, Flow> {

    @Resource
    private FlowMapper flowMapper;

    public IPage<Flow> queryFlowByTj(Flow flow, int page, int limit){
        IPage<Flow> result = new Page(page,limit);
        return flowMapper.queryByPage(result,flow);
    }

    public List<Map<String,Object>> queryAllFlow(){
        return flowMapper.queryAllFlow();
    }

    public IPage<Flow> queryFlow(Flow flow, int page, int limit) {
        IPage<Flow> result = new Page(page,limit);
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(flow);
        result = page(result,queryWrapper);
        return result;
    }

    @Transactional(rollbackFor=Exception.class)
    public boolean addFlow(Flow flow){
        if("".equals(flow.getFlowid()) || flow.getFlowid() == null){
            flow.setFlowid(IdUtil.simpleUUID());
        }
        return saveOrUpdate(flow);
    }

    @Transactional(rollbackFor=Exception.class)
    public boolean deleteFlow(List<String> ids){
        return removeByIds(ids);
    }
}
