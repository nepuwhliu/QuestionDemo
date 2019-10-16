package com.example.application.http.api;


import com.example.application.mvp.main.bean.LevelBean;
import com.example.application.mvp.main.bean.LevelTypeBean;
import com.example.application.mvp.main.bean.QuestionBean;
import com.example.application.mvp.main.bean.QuestionTypeBean;
import com.example.application.mvp.main.bean.ResponseBean;
import com.example.application.mvp.main.bean.UserBean;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * api访问接口 尽量写post请求 post请求安全可靠
 */
public interface ApiStores {

    String API_QUESTION_URL = "http://58.155.43.107:9002/";
    /**
     * 加载所有问题 自动分类
     * 这里 我们要细分
     */
    @GET("user/question")
    Call<List<QuestionBean>> loadQuestionByRetrofit();

    /**
     * 用户登录
     * 返回用户的基本信息
     */
    @GET("user/login")
    Call<UserBean> userLogin(
            @Query("username") String username,
            @Query("password") String password);
    /**
     * 用户注册
     */
    @POST("user/register")
    Call<ResponseBean> userRegister(@Field("username") String username);

    /**
     * 拿到考试等级
     */
    @GET("index/level")
    Call<List<LevelBean>> getQuestionLevel();
    /**
     * 拿到题型
     */
    @GET("index/questionType")
    Call<List<QuestionTypeBean>> getQuestionType();
    /**
     * 拿到题型和等级的关系
     */
    @GET("index/levelType")
    Call<List<LevelTypeBean>> getQuestionLevelType();
    /**
     * 根据等级 和 题型 获取相应的数据
     */
    @GET("question/question")
    Call<List<QuestionBean>> getSingleQuestion(
            @Query("levelName") String levelName,
            @Query("typeName") String typeName);
}
