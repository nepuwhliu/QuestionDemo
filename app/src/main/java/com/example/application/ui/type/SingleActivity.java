package com.example.application.ui.type;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.application.R;
import com.example.application.mvp.main.bean.QuestionBean;
import com.example.application.mvp.main.presenter.impl.QuestionPresenter;
import com.example.application.mvp.main.view.QuestionView;
import com.example.application.ui.base.MvpActivity;

import java.util.List;


public class SingleActivity extends MvpActivity<QuestionPresenter> implements QuestionView {

    private String levelName;
    private String typeName;
    private TextView single_question_type;
    private TextView single_question_title;
    private TextView single_select_one;
    private TextView single_select_two;
    private TextView single_select_three;
    private TextView single_select_four;
    private TextView single_number;
    private ImageView single_collect;
    private TextView single_rightAnswer;
    private TextView single_answer;
    private TextView single_help;
    private String answer;
    private TextView single_submit;
    private List<QuestionBean> mQuestionBeans;
    private int mCount = 0;
    private int mPoint = 0;
    private int mSubmit = 1;
    private int mQuestion = 0;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            single_question_title.setText("        " + mQuestionBeans.get(mCount).getQuestionContent());
            single_select_one.setText("A:  " + mQuestionBeans.get(mCount).getQuestionOne());
            single_select_two.setText("B:  " + mQuestionBeans.get(mCount).getQuestionTwo());
            single_select_three.setText("C:  " + mQuestionBeans.get(mCount).getQuestionThree());
            single_select_four.setText("D:  " + mQuestionBeans.get(mCount).getQuestionFour());
            single_select_one.setBackgroundColor(Color.WHITE);
            single_select_two.setBackgroundColor(Color.WHITE);
            single_select_three.setBackgroundColor(Color.WHITE);
            single_select_four.setBackgroundColor(Color.WHITE);
            single_collect.setImageResource(R.drawable.ic_single_unstar);
            single_number.setText((mCount + 1)+ "/" + mQuestionBeans.size());
        }
    };

    private Handler mHandlerSubmit = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if(mSubmit == 1) {
                single_submit.setText("进入下一题");
                single_rightAnswer.setText("正确答案:" + mQuestionBeans.get(mCount).getAnswer());
                if(answer == null) {
                    single_answer.setText("请选择答案");
                }else {
                    single_answer.setText("您的答案:" + answer);
                }
                mSubmit = mSubmit - 1;
            } else {
                single_submit.setText("提交答案");
                single_rightAnswer.setText(" ");
                single_answer.setText("");
                mSubmit = mSubmit + 1;
                single_question_title.setText("        " + mQuestionBeans.get(mCount).getQuestionContent());
                single_select_one.setText("A:  " + mQuestionBeans.get(mCount).getQuestionOne());
                single_select_two.setText("B:  " + mQuestionBeans.get(mCount).getQuestionTwo());
                single_select_three.setText("C:  " + mQuestionBeans.get(mCount).getQuestionThree());
                single_select_four.setText("D:  " + mQuestionBeans.get(mCount).getQuestionFour());
                single_select_one.setBackgroundColor(Color.WHITE);
                single_select_two.setBackgroundColor(Color.WHITE);
                single_select_three.setBackgroundColor(Color.WHITE);
                single_select_four.setBackgroundColor(Color.WHITE);
                single_collect.setImageResource(R.drawable.ic_single_unstar);
                single_number.setText((mCount + 1)+ "/" + mQuestionBeans.size());
            }
        }
    };

    private Handler mHandlerNull = new Handler(){
        @Override
        public void handleMessage(Message message) {
            single_submit.setText("进入下一题");
            single_rightAnswer.setText(" ");
            single_answer.setText("");
            single_question_title.setText("        " + mQuestionBeans.get(mCount).getQuestionContent());
            single_select_one.setText("A:  " + mQuestionBeans.get(mCount).getQuestionOne());
            single_select_two.setText("B:  " + mQuestionBeans.get(mCount).getQuestionTwo());
            single_select_three.setText("C:  " + mQuestionBeans.get(mCount).getQuestionThree());
            single_select_four.setText("D:  " + mQuestionBeans.get(mCount).getQuestionFour());
            mSubmit = mSubmit - 1;
        }
    };

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.single_back:
                if(mCount > 1) {
                    mCount = mCount - 1;
                    Message messageBack = mHandler.obtainMessage();
                    messageBack.arg1 = mCount;
                    mHandler.sendMessage(messageBack);
                } else {
                    toastShow("这是第一题");
                }

                break;
            case R.id.single_collect:
                break;
            case R.id.single_forward:
                if(mCount < mQuestionBeans.size()) {
                    mCount = mCount + 1;
                    Message messageForward = mHandler.obtainMessage();
                    messageForward.arg1 = mCount;
                    mHandler.sendMessage(messageForward);
                } else {
                    toastShow("这是最后一道题");
                }
                break;
            case R.id.single_select_one:
                single_select_one.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_two.setBackgroundColor(Color.WHITE);
                single_select_three.setBackgroundColor(Color.WHITE);
                single_select_four.setBackgroundColor(Color.WHITE);
                /**
                 * 获取当前点击的答案
                 */
                answer = (String) single_select_one.getText().subSequence(0, 1);
                mQuestion = 1;
                break;
            case R.id.single_select_two:
                single_select_two.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_one.setBackgroundColor(Color.WHITE);
                single_select_three.setBackgroundColor(Color.WHITE);
                single_select_four.setBackgroundColor(Color.WHITE);
                answer = (String) single_select_two.getText().subSequence(0, 1);
                mQuestion = 1;
                break;
            case R.id.single_select_three:
                single_select_three.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_one.setBackgroundColor(Color.WHITE);
                single_select_two.setBackgroundColor(Color.WHITE);
                single_select_four.setBackgroundColor(Color.WHITE);
                answer = (String) single_select_three.getText().subSequence(0, 1);
                mQuestion = 1;
                break;
            case R.id.single_select_four:
                single_select_four.setBackgroundColor(Color.parseColor("#00574B"));
                single_select_one.setBackgroundColor(Color.WHITE);
                single_select_two.setBackgroundColor(Color.WHITE);
                single_select_three.setBackgroundColor(Color.WHITE);
                answer = (String) single_select_four.getText().subSequence(0, 1);
                mQuestion = 1;
                break;
            case R.id.single_relativeLayout_collect:
                if(mPoint > 0) {
                    single_collect.setImageResource(R.drawable.ic_single_star);
                    mPoint = mPoint - 1;
                    //TODO 取的数据保存到数据库中
                } else {
                    single_collect.setImageResource(R.drawable.ic_single_unstar);
                    mPoint = mPoint + 1;
                }
                break;
            case R.id.single_submit:
                //TODO 拿到答案保存到数组中 到最后显示对错答案
                if(mSubmit == 1) {
                    /**
                     *  表示 对答案
                     */
                    if(mQuestion == 1) {
                        Message messageSubmit = mHandlerSubmit.obtainMessage();
                        mHandlerSubmit.sendMessage(messageSubmit);
                        mQuestion = 0;
                    } else {
                        //TODO 我们应该选择弹框提示用户
                        toastShow("你还没有选择答案");
                        answer = "";
                        Message messageQuestionNull = mHandlerNull.obtainMessage();
                        mHandlerNull.sendMessage(messageQuestionNull);
                    }

                } else {
                    /**
                     * 进入下一题
                     */
                    if(mCount < mQuestionBeans.size()) {
                        mCount = mCount + 1;
                        Message messageNextQuestion = mHandlerSubmit.obtainMessage();
                        messageNextQuestion.arg1 = mCount;
                        mHandlerSubmit.sendMessage(messageNextQuestion);
                    } else {
                        //TODO 显示一个Dialog 用来提醒用户是否到了最后一道题 还要判断改题该用户答了没有 答了就选择下一题 没答 就空开
                        toastShow("这是最后一道题,");
                    }
                }

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 继承了 MvpActivity中的BaseActivity
         */
        setContentView(R.layout.activity_single);
        levelName = getIntent().getStringExtra("level");
        typeName = getIntent().getStringExtra("type");
        /**
         * 加载布局
         */
        initView();
        /**
         * 加载数据
         */
        initData(levelName, typeName);
    }

    private void initData(final String levelName, final String typeName) {
        /**
         * 制造延迟加载效果
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mvpPresenter.loadData(levelName, typeName);
            }
        }, 1000);
    }

    @Override
    protected QuestionPresenter createPresenter() {
        return  new QuestionPresenter(this);
    }

    private void initView() {
        single_question_type = findViewById(R.id.single_question_type);
        single_question_type.setText("题型:    " + typeName);
        single_question_title = findViewById(R.id.single_question_title);
        single_select_one = findViewById(R.id.single_select_one);
        single_select_two = findViewById(R.id.single_select_two);
        single_select_three = findViewById(R.id.single_select_three);
        single_select_four = findViewById(R.id.single_select_four);
        single_number = findViewById(R.id.single_number);
        single_collect = findViewById(R.id.single_collect);
        single_rightAnswer = findViewById(R.id.single_rightAnswer);
        single_answer = findViewById(R.id.single_answer);
        single_help = findViewById(R.id.single_help);
        single_submit = findViewById(R.id.single_submit);

    }

    @Override
    public void getDataSuccess(List<QuestionBean> questionBeans) {
        this.mQuestionBeans = questionBeans;
        single_question_title.setText("        " + mQuestionBeans.get(mCount).getQuestionContent());
        single_select_one.setText("A:  " + mQuestionBeans.get(mCount).getQuestionOne());
        single_select_two.setText("B:  " + mQuestionBeans.get(mCount).getQuestionTwo());
        single_select_three.setText("C:  " + mQuestionBeans.get(mCount).getQuestionThree());
        single_select_four.setText("D:  " + mQuestionBeans.get(mCount).getQuestionFour());
        single_number.setText((mCount + 1)+ "/" + mQuestionBeans.size());
    }

    @Override
    public void getDataFail(String msg) {
        toastShow(msg);
    }

    @Override
    public void showLoading() {
        showProgressDialog();
    }

    @Override
    public void hideLoading() {
        dismissProgressDialog();
    }

    @Override
    protected void onDestroy() {
        mvpPresenter.detachView();
        super.onDestroy();
    }
}