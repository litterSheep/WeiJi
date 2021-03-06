package com.ly.weiji.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ly.weiji.R;
import com.ly.weiji.db.Account;
import com.ly.weiji.utils.TimeUtil;

import java.util.List;

/**
 * Created by ly on 2017/3/6 15:04.
 */

public class HistoryAdapter extends BaseAdapter {

    private List<Account> mlist;
    private Context context;
    private LayoutInflater inflater;

    public HistoryAdapter(List<Account> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void add(Account account) {
        mlist.add(0, account);
        notifyDataSetChanged();
    }

    public void setList(List<Account> list) {
        mlist = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_history, null);
            viewHolder.tv_time = convertView.findViewById(R.id.tv_item_time);
            viewHolder.tv_item_type = convertView.findViewById(R.id.tv_item_type);
            viewHolder.tv_money = convertView.findViewById(R.id.tv_item_money);
            viewHolder.tv_remark = convertView.findViewById(R.id.tv_item_remark);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Account account = mlist.get(position);

        viewHolder.tv_time.setText(TimeUtil.formatTimestamp(account.getWriteTime()));
        int color;
        if (account.getType() < 0) {//支出
            color = context.getResources().getColor(R.color.mainColor1);
        } else {//收入
            color = context.getResources().getColor(R.color.green);
        }

        viewHolder.tv_item_type.setTextColor(color);
        viewHolder.tv_money.setTextColor(color);
        viewHolder.tv_remark.setTextColor(color);
        viewHolder.tv_time.setTextColor(color);

        viewHolder.tv_item_type.setText(account.getDescription());
        viewHolder.tv_money.setText(account.getMoney() + "");
        if (TextUtils.isEmpty(account.getRemark())) {
            viewHolder.tv_remark.setVisibility(View.GONE);
        } else {
            viewHolder.tv_remark.setVisibility(View.VISIBLE);
            viewHolder.tv_remark.setText(account.getRemark());
        }

        return convertView;
    }

    class ViewHolder {

        TextView tv_time, tv_money, tv_remark, tv_item_type;
    }
}
