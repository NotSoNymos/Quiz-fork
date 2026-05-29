package com.example.quiz.presentation.screen.search.searchbook

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.quiz.presentation.composables.CardWork
import com.example.quiz.presentation.composables.SimpleButton
import com.example.quiz.presentation.composables.SimpleCreateBackground


@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: SearchBookViewModel
) {
    SimpleCreateBackground(Modifier, "Поиск", navHostController)
    val searchQuery by viewModel.searchQuery.collectAsStateWithLifecycle()

    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier
            .padding(top = 150.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { newValue -> viewModel.onSearchQueryChanged(newValue) },
            modifier = Modifier
                .width(355.dp)
                .height(80.dp),
            label = {
                Text(
                    "Поиск...",
                    style = MaterialTheme.typography.labelSmall.copy(fontSize = 24.sp)
                )
            },
            shape = RoundedCornerShape(20),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
                unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
                focusedBorderColor = MaterialTheme.colorScheme.secondary
            ),
            textStyle = MaterialTheme.typography.labelSmall.copy(
                fontSize = 24.sp
            ),
        )


        //SimpleButton(Modifier, "Искать", { viewModel.onSearchQueryChanged(searchQuery) })
        LazyColumn(
            modifier = Modifier.padding(top  = 20.dp, bottom = 40.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(searchResults) { book ->
                CardWork(Modifier, book.title, book.description, {}, true, {})
            }
        }
    }

}