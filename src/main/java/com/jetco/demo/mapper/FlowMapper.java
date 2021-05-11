package com.jetco.demo.mapper;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jetco.demo.bean.FlowTree;
import com.jetco.demo.entity.Flow;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

@Mapper
public interface FlowMapper extends BaseMapper<Flow> {

    @Select(" SELECT distinct flowid as id ,flowcode, flowpath , flowicon , flowname as name , parentid   FROM WF_FLOW START WITH PARENTID is null  CONNECT BY PRIOR FLOWID = PARENTID ")
    List<FlowTree> queryFlowTree();

    @Select("select t.flowid,t.flowname,t.flowcode,t.flowpath,t.maintable,t.displayname,t.flowicon from WF_FLOW t")
    List<Map<String,Object>> queryAllFlow();

    @SelectProvider(type = QueryWorkItem.class, method = "queryBusiType")
    List<Map<String, String>> queryBusiType(@Param("flowid") String flowid);

    /**
     * 分页查询业务表
     * @param page
     * @param flow
     * @return
     */
    @SelectProvider(type = QueryWorkItem.class, method = "queryByPage")
    IPage<Flow> queryByPage(IPage<Flow> page, @Param("flow") Flow flow);

    @Select("select t.flowname as label,t.flowid as value from wf_flow t where t.parentid is  null")
    List<Map<String, String>> queryBusiParent();


    class QueryWorkItem {

        public String queryByPage(Map map){
            String sql = "select t.flowid,t.flowname,t.flowcode,t.flowpath,t.maintable,t.displayname,t.flowicon from WF_FLOW t where 1=1 ";
            Flow flow = (Flow) map.get("flow");
            if(!StringUtils.isEmpty(flow.getFlowname())){
                sql += " and t.flowname like CONCAT(CONCAT('%',#{flow.flowname}),'%')";
            }
            return sql;
        }

        public String queryBusiType(Map map){
            StringBuilder sql = new StringBuilder(" select t.flowname as label,t.flowid as value from wf_flow t where t.parentid is not null");
            if(ObjectUtil.isNotNull(map.get("flowid"))){
                sql.append(" and flowid =#{flowid}");
            }
            return sql.toString();
        }

    }
}