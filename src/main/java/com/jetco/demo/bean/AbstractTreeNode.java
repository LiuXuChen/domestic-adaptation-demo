package com.jetco.demo.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class AbstractTreeNode {

    private String id ;

    private String name ;

    private String type;

    private String parentid;

    private boolean checked = Boolean.FALSE;

    private List<? extends AbstractTreeNode> children = new ArrayList<>();

}