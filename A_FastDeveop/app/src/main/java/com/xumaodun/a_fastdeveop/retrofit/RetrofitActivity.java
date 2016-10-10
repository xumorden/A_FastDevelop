package com.xumaodun.a_fastdeveop.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.xumaodun.a_fastdeveop.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class RetrofitActivity extends AppCompatActivity {

    private String TAG = "Retrofit";
    public static final String baseUrl = "http://cms.bonday.cn/";
    private Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        getStarBean();
    }

    public void getStarBean(){
        ICommentBeanService iservice = retrofit.create(ICommentBeanService.class);
        Call<StarEntity> call = iservice.getStarData("user_star_anchor","1","2");
        call.enqueue(new Callback<StarEntity>() {
            @Override
            public void onResponse(Call<StarEntity> call, Response<StarEntity> response) {
                Log.e(TAG, "normalGet:" + response.body().toString() + "");
                Toast.makeText(RetrofitActivity.this, response.body() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<StarEntity> call, Throwable t) {
                Log.e(TAG, "normalGet:  请求网络失败啦"+ t.getMessage());
                Toast.makeText(RetrofitActivity.this, "请求网络失败啦--" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //查询参数的设置@Query
    public interface ICommentBeanService{
        //http://cms.bonday.cn/api/comments/page?oid=56a1fadd0cf204fd74527166   一个参数
        @GET("api/comments/page")
        Call<CommentBean> getCommentData(@Query("oid") String oid);
        //http://cms.bonday.cn/api/users/page?code=user_star_anchor&page=1&size=4     多个参数
        @GET("api/users/page")
        Call<StarEntity> getStarData(@Query("code") String code, @Query("page") String page, @Query("size") String size);
        //https://api.example.com/tasks?id=123&id=124&id=125
        //Call<List<Task>> getTask(@Query("id") List<Long> taskIds);
    }

    public interface ISerachEntivyService {
        @GET("api/schools/all/withoutStudent")
        Call<MovieBean> getSearchEntity();
    }

    public void getMovieData(){
        ISerachEntivyService iservice = retrofit.create(ISerachEntivyService.class);
        Call<MovieBean> call = iservice.getSearchEntity();
        call.enqueue(new Callback<MovieBean>() {
            @Override
            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
                Log.e(TAG, "normalGet:" + response.body().toString() + "");
                Toast.makeText(RetrofitActivity.this, response.body() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MovieBean> call, Throwable t) {
                Log.e(TAG, "normalGet:  请求网络失败啦"+ t.getMessage());
                Toast.makeText(RetrofitActivity.this, "请求网络失败啦--" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //动态的url访问@PATH
    public interface ISerachService {
        @GET("api/search/hotKeyWords/{param}")
        @Headers("X-Content-type: application/json;charset=UTF-8")
//      @Headers({"X-User-Email: abcd@gmail.com", "X-User-Token: qQsQobQv-Wmum7bUs4b_"})
        Call<SearchEntity> getSearchEntity(@Path("param") String username);
    }

    public void getCommentBean(){
        ICommentBeanService iservice = retrofit.create(ICommentBeanService.class);
        Call<CommentBean> call = iservice.getCommentData("56a1fadd0cf204fd74527166");
        call.enqueue(new Callback<CommentBean>() {
            @Override
            public void onResponse(Call<CommentBean> call, Response<CommentBean> response) {
                Log.e(TAG, "normalGet:" + response.body().toString() + "");
                Toast.makeText(RetrofitActivity.this, response.body() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<CommentBean> call, Throwable t) {
                Log.e(TAG, "normalGet:  请求网络失败啦"+ t.getMessage());
                Toast.makeText(RetrofitActivity.this, "请求网络失败啦--" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //POST请求体的方式向服务器传入json字符串@Body   未验证
    public interface ITaskService {
        @POST("add")
        Call<TaskEntity> createTask(@Body TaskEntity taskEntity);
    }

    public void postTaskEntity(){
        ITaskService iTaskService = retrofit.create(ITaskService.class);
        Call<TaskEntity> call = iTaskService.createTask(new TaskEntity(1, "my task title"));
        call.enqueue(new Callback<TaskEntity>() {
            @Override
            public void onResponse(Call<TaskEntity> call, Response<TaskEntity> response) {
                Log.e(TAG, "normalGet:" + response.body().toString() + "");
                Toast.makeText(RetrofitActivity.this, response.body() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TaskEntity> call, Throwable t) {
            }
        });
    }

    //表单的方式传递键值对@FormUrlEncoded
    public interface IUserService {
        @POST("login")
        @FormUrlEncoded
        Call<UserEntity> login(@Field("username") String username, @Field("password") String password);
    }

    public void postFormUserEntity(){
        IUserService iUserService = retrofit.create(IUserService.class);
        Call<UserEntity> call = iUserService.login("morden", "123456");
        call.enqueue(new Callback<UserEntity>() {
            @Override
            public void onResponse(Call<UserEntity> call, Response<UserEntity> response) {
                Log.e(TAG, "normalGet:" + response.body().toString() + "");
                Toast.makeText(RetrofitActivity.this, response.body() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserEntity> call, Throwable t) {
            }
        });
    }


}
