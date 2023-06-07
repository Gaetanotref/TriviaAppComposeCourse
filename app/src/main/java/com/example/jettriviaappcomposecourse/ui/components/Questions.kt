package com.example.jettriviaappcomposecourse.ui.components

import android.util.Log
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import com.example.jettriviaappcomposecourse.viewmodel.QuestionsViewModel


@Composable
fun Questions(viewModel: QuestionsViewModel) {
    val questions = viewModel.data.value.data?.toMutableList()

    val questionIndex = remember {
        mutableStateOf(0)
    }



    if (viewModel.data.value.loading == true) {
        CircularProgressIndicator()
    } else {

        val question = try {
            questions?.get(questionIndex.value)
        } catch (e: Exception) {
            null
        }

        if (questions != null) {
            if (question != null) {
                QuestionDisplay(
                    question = question,
                    questionIndex = questionIndex,
                    viewModel = viewModel
                ){
                    questionIndex.value = questionIndex.value + 1
                }
            }
        }
    }
}