package com.example.quizapp2.data;

import android.util.Log;

import com.example.quizapp2.data.model.QuestionsResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class QuizRepository implements IQuizRepository{


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private TriviaNetworkClient client = retrofit.create(TriviaNetworkClient.class);


    @Override
    public void getQuestions(int ammount, OnQuizCallback callback) {

    }

    private interface TriviaNetworkClient{
        @GET("/api.php")
        Call<QuestionsResponce> getQuestions(
                @Query("amount") int amount,
                @Query("category") int category,
                @Query("difficulty") String difficulty
        );
    }

    @Override
    public void getQuiz(final OnQuizCallback callback) {
        Call<QuestionsResponce> call = client.getQuestions(
                10,
                9,
                "easy"
        );

        Log.d("ololo", call.request().url().toString());
        call.enqueue(new Callback<QuestionsResponce>() {
            @Override
            public void onResponse(Call<QuestionsResponce> call, Response<QuestionsResponce> response) {
                if (response.isSuccessful()){
                    if (response.body()!=null){
                        callback.onSuccess(response.body().getQuestionsResults());
                    }else {
                        callback.onFailure(new Exception("remote data source not initiazialate"));
                    }
                }else {
                    callback.onFailure(new Exception("remote data source not initialate"));
                }
            }

            @Override
            public void onFailure(Call<QuestionsResponce> call, Throwable t) {
                callback.onFailure(new Exception(t));
            }
        });
    }
}
