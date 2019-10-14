package com.example.application;

public class Model {

	public static int[] EXPANDABLE_LISTVIEW_IMG = new int[] {
			R.drawable.ic_sequence_image01, R.drawable.ic_sequence_image02,
			R.drawable.ic_sequence_image03, R.drawable.ic_sequence_image04,
			R.drawable.ic_sequence_image04 };

	public static String[] EXPANDABLE_LISTVIEW_TXT = new String[] { "初级",
			"中级", "高级", "技师", "高级技师" };
	public static String[][] EXPANDABLE_MORELIST_TXT = {
			{ "初级单选", "初级判断" },
			{ "中级单选", "中级判断" },
			{ "高级单选", "高级多选", "高级判断", "高级问答题" },
			{ "技师单选", "技师多选", "技师判断", "技师问答题" },
			{ "高级技师单选", "高级技师多选", "高级技师判断", "高级技师问答题" }};
}
