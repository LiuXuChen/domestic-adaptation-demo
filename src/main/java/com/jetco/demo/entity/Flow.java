package com.jetco.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("WF_FLOW")
@ApiModel(value="Flow对象", description="业务流程表")
public class Flow implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "流程ID")
    @TableId("FLOWID")
    private String flowid;

    @ApiModelProperty(value = "流程名称")
    @TableField("FLOWNAME")
    private String flowname;

    @ApiModelProperty(value = "流程编码")
    @TableField("FLOWCODE")
    private String flowcode;

    @ApiModelProperty(value = "流程路径")
    @TableField("FLOWPATH")
    private String flowpath;

    @ApiModelProperty(value = "主表")
    @TableField("MAINTABLE")
    private String maintable;

    @ApiModelProperty(value = "显示名称")
    @TableField("DISPLAYNAME")
    private String displayname;

    @ApiModelProperty(value = "流程图标")
    @TableField("FLOWICON")
    private String flowicon;

    @ApiModelProperty(value = "业务类别")
    @TableField("YWLB")
    private String ywlb;

    @ApiModelProperty(value = "父节点")
    @TableField("PARENTID")
    private String parentid;

    @ApiModelProperty(value = "版本号")
    @TableField("VERSION")
    private String version;

}
