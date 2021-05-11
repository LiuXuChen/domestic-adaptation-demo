package com.jetco.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务表
 * </p>
 *
 * @author lhw
 * @since 2021-05-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("WF_TASK")
@ApiModel(value="Task对象", description="任务表")
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务ID")
    @TableId("TASKID")
    private String taskid;

    @ApiModelProperty(value = "创建人")
    @TableField("CREATOR")
    private String creator;

    @ApiModelProperty(value = "创建名称")
    @TableField("CREATORNAME")
    private String creatorname;

    @ApiModelProperty(value = "创建时间")
    @TableField("CREATEDATE")
    private Date createdate;

    @ApiModelProperty(value = "业务ID")
    @TableField("FLOWID")
    private String flowid;

    @ApiModelProperty(value = "业务名称")
    @TableField("FLOWNAME")
    private String flowname;

    @ApiModelProperty(value = "过程状态")
    @TableField("PROCESSSTATE")
    private String processstate;

    @ApiModelProperty(value = "流程节点ID")
    @TableField("ACTIVITYDEFIDS")
    private String activitydefids;

    @ApiModelProperty(value = "过程实例ID")
    @TableField("PROCESSINSTID")
    private String processinstid;

    @ApiModelProperty(value = "显示名称")
    @TableField("DISPLAYNAME")
    private String displayname;

    @ApiModelProperty(value = "发送人")
    @TableField("SENDER")
    private String sender;

    @ApiModelProperty(value = "完成时间")
    @TableField("FINISHEDDATE")
    private Date finisheddate;

    @ApiModelProperty(value = "挂起用户")
    @TableField("SUSPENDNAME")
    private String suspendname;

    @ApiModelProperty(value = "挂起时间")
    @TableField("SUSPENDTIME")
    private Date suspendtime;

    @ApiModelProperty(value = "业务代码")
    @TableField("FLOWCODE")
    private String flowcode;

    @ApiModelProperty(value = "是否删除")
    @TableField("ISDELETE")
    private String isdelete;

    @ApiModelProperty(value = "分管领导用户")
    @TableField("FGLD_USER_IDS")
    private String fgldUserIds;

    @ApiModelProperty(value = "承办处室负责人用户")
    @TableField("CBCSFZR_USER_IDS")
    private String cbcsfzrUserIds;

    @ApiModelProperty(value = "承办处室经办人用户")
    @TableField("CBCSJBR_USER_IDS")
    private String cbcsjbrUserIds;

    @ApiModelProperty(value = "父任务ID")
    @TableField("PARENT_TASKID")
    private String parentTaskid;

    @ApiModelProperty(value = "退回状态（0：未退回，1：退回）")
    @TableField("RETURN_STATE")
    private String returnState;

    @ApiModelProperty(value = "所有子流程的taskid")
    @TableField("CHILD_TASKID")
    private String childTaskid;

    @ApiModelProperty(value = "单位ID")
    @TableField("CORP_ID")
    private String corpId;

    @ApiModelProperty(value = "单位结构内码")
    @TableField("CORP_STRU_ID")
    private String corpStruId;

    @ApiModelProperty(value = "分局县局中心用户")
    @TableField("FJXJZX_USER_IDS")
    private String fjxjzxUserIds;

    @ApiModelProperty(value = "已读人员id")
    @TableField("READ_USER_ID")
    private String readUserId;

    @ApiModelProperty(value = "排列顺序")
    @TableField("STRU_ORDER")
    private String struOrder;

    @ApiModelProperty(value = "判断是批量归档还是单独办理（1：批量，2：单独）")
    @TableField("ISBATCHHANDLE")
    private String isbatchhandle;

    @ApiModelProperty(value = "判断这个发文是否转收文（1：转收文）")
    @TableField("ISRECEIVEDOC")
    private String isreceivedoc;

    @ApiModelProperty(value = "是否定位")
    @TableField("ISMAP")
    private String ismap;

    @ApiModelProperty(value = "所属机构")
    @TableField("CROP_NAME")
    private String cropName;

    @ApiModelProperty(value = "部门id")
    @TableField("DEPT_ID")
    private String deptId;


}
