package com.dons.expandablelistviewdemo;

import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyAdapterForExpandableListView extends BaseExpandableListAdapter{

	Context callingActivity;
	List<String> headerList;
	HashMap<String,List<String>> childList;
	
	
	public MyAdapterForExpandableListView(Context callingActivity,List<String> headerList,HashMap<String,List<String>> childList) {
		
		this.callingActivity=callingActivity;
		this.headerList=headerList;
		this.childList=childList;
		
	}
	
	@Override
	public Object getChild(int groupPosition, int childPosititon) {
		// TODO Auto-generated method stub
		return this.childList.get(this.headerList.get(groupPosition)).get(childPosititon);
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLstChild, View singleItemInChild,ViewGroup parentView) {
		// TODO Auto-generated method stub
		final String childText = (String) getChild(groupPosition, childPosition);
		if(singleItemInChild==null)
		{
			LayoutInflater inflater=(LayoutInflater) callingActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			singleItemInChild=inflater.inflate(R.layout.item, null);
			TextView text=(TextView)singleItemInChild.findViewById(R.id.textView1);
			text.setText(childText);
		}
		
		return singleItemInChild;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return this.childList.get(this.headerList.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return this.headerList.get(groupPosition);
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return this.headerList.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View eachItemInHeader, ViewGroup parentView) {
		// TODO Auto-generated method stub
		String headerTitle = (String) getGroup(groupPosition);
		LayoutInflater inflater=(LayoutInflater) callingActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(eachItemInHeader==null)
		{
			eachItemInHeader=inflater.inflate(R.layout.header, null);
			TextView text=(TextView)eachItemInHeader.findViewById(R.id.textView1);
			text.setTypeface(null, Typeface.BOLD);
			text.setText(headerTitle);
		}
		return eachItemInHeader;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
