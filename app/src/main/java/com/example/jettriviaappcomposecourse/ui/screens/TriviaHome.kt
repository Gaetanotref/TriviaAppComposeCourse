package com.example.jettriviaappcomposecourse.ui.screens

import androidx.compose.runtime.Composable
import com.example.jettriviaappcomposecourse.ui.components.Questions
import com.example.jettriviaappcomposecourse.viewmodel.QuestionsViewModel

@Composable
fun TriviaHome(viewModel: QuestionsViewModel) {

    Questions(viewModel = viewModel)
}

