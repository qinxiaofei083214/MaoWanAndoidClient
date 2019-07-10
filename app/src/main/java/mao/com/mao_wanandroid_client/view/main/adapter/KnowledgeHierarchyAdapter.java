package mao.com.mao_wanandroid_client.view.main.adapter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import mao.com.mao_wanandroid_client.R;
import mao.com.mao_wanandroid_client.model.knowlegetree.KnowledgeHierarchyData;
import mao.com.mao_wanandroid_client.view.main.hloder.KnowledgeHolderView;
import mao.com.mao_wanandroid_client.widget.flowlayout.FlowLayout;

/**
 * @author maoqitian
 * @Description 知识体系 fragment 适配器
 * @Time 2019/5/23 0023 23:01
 */
public class KnowledgeHierarchyAdapter extends BaseQuickAdapter<KnowledgeHierarchyData, KnowledgeHolderView> {


    public KnowledgeHierarchyAdapter(int layoutResId, @Nullable List<KnowledgeHierarchyData> data) {
        super(layoutResId, data);
    }

    public KnowledgeHierarchyAdapter(@Nullable List<KnowledgeHierarchyData> data) {
        super(data);
    }

    public KnowledgeHierarchyAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(KnowledgeHolderView helper, KnowledgeHierarchyData item) {
        helper.setText(R.id.tv_knowledge_title,item.getName());
        FlowLayout flowLayout = helper.getView(R.id.flow_layout);
        List<KnowledgeHierarchyData> childrens = item.getChildren();
        if(childrens.size()>0){
            flowLayout.removeAllViews();
            for (KnowledgeHierarchyData knowledgeHierarchyData:childrens) {
                TextView viewTag = (TextView) LayoutInflater.from(mContext).inflate(R.layout.flow_text_tag_layout, flowLayout, false);
                viewTag.setText(knowledgeHierarchyData.getName());
                flowLayout.addView(viewTag);
            }
        }
    }
}
