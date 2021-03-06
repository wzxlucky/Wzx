package com.one.wsy.wzxlib.treeview.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.one.wsy.wzxlib.treeview.adapter.ExpandableItemAdapter;

/**
 * 日期: 2018/8/29 9:29
 *
 * @author wsy
 */
public class LevelItemChild implements MultiItemEntity {

    public String parentId;

    public String title;

    public int imageUrl;

    public boolean isCheck;

    public LevelItemChild(String parentId, String title, int imageUrl, boolean isCheck) {
        this.parentId = parentId;
        this.title = title;
        this.imageUrl = imageUrl;
        this.isCheck = isCheck;
    }

    @Override
    public int getItemType() {
        return ExpandableItemAdapter.TYPE_LEVEL_1;
    }
}
