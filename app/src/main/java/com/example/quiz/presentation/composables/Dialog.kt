package com.example.quiz.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.quiz.R
import com.example.quiz.ui.theme.Black
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun DialogResolvedWork(
    modifier: Modifier = Modifier,
    stateWindow: Boolean,
    onClickLook: () -> Unit,
    onClickDelete: () -> Unit
) {

    var showDialog by remember { mutableStateOf(stateWindow) }

    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            Card(
                modifier = Modifier
                    .width(300.dp)
                    .height(260.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondary)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Row(
                        modifier = Modifier
                            .clickable(onClick = onClickLook)
                            .width(250.dp)
                            .height(60.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_book_open),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 5.dp),
                            tint = Black
                        )
                        Text(
                            text = "Посмотреть, \n" +
                                    "кто решил", style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.padding(start = 10.dp),
                            color = Black
                        )
                    }


                    Row(
                        modifier = Modifier
                            .clickable(onClick = onClickDelete)
                            .padding(top = 20.dp)
                            .width(250.dp)
                            .height(60.dp)
                            .background(
                                color = MaterialTheme.colorScheme.secondaryContainer,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_delete),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 5.dp),
                            tint = Black
                        )
                        Text(
                            text = "Удалить", style = MaterialTheme.typography.labelLarge,
                            modifier = Modifier.padding(start = 10.dp),
                            color = Black
                        )
                    }

                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewDialog() {
    QuizTheme { DialogResolvedWork(Modifier, true, {}, {}) }
}