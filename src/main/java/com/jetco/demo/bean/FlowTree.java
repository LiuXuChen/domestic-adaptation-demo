package com.jetco.demo.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FlowTree extends AbstractTreeNode {

    private String flowcode;

    private String flowicon;

    private String flowpath;

    private Boolean canCreate = Boolean.TRUE;

}