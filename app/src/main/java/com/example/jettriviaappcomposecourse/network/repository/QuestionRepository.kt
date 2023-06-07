package com.example.jettriviaappcomposecourse.network.repository

import android.util.Log
import com.example.jettriviaappcomposecourse.data.DataOrException
import com.example.jettriviaappcomposecourse.model.QuestionItem
import com.example.jettriviaappcomposecourse.network.QuestionApi
import javax.inject.Inject


class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException = DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions() : DataOrException<ArrayList<QuestionItem>,Boolean,Exception>{
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        }catch (exception:Exception){

            dataOrException.e = exception
            Log.d("Exception", "getAllQuestions: ${dataOrException.e?.message}")
        }
        return dataOrException
    }

}