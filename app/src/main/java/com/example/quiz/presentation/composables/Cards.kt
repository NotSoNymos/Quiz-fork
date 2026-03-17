package com.example.quiz.presentation.composables

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.R
import com.example.quiz.ui.theme.Black
import com.example.quiz.ui.theme.QuizTheme
import java.nio.file.WatchEvent

@Composable
fun CardWork(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    onClick: () -> Unit,
    flagSettings: Boolean,
    flagCount: Boolean
) {
    Box(
        modifier = Modifier
            .width(333.dp)
            .height(105.dp)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(20.dp)
            )
    ) {
        if (flagSettings) {
            Icon(
                painter = painterResource(R.drawable.ic_setting_config),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 294.dp, top = 15.dp)
                    .size(24.dp),
                tint = Black
            )
        }

//        if(flagCount){
//            Box()
//        }


        Column(
            modifier = Modifier
                .padding(start = 23.dp, top = 15.dp)
                .fillMaxSize()

        ) {
            Text(text = title, style = MaterialTheme.typography.labelMedium)
            Text(
                text = text,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(start = 20.dp)
            )
        }
    }

}


@Composable
fun CardLookSolvedWork(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .width(172.dp)
            .height(53.dp)

            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(20.dp)
            ), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_book_open),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp),
            tint = Black
        )
        Text(
            text = "Посмотреть, \n" +
                    "кто решил",
            style = MaterialTheme.typography.labelLarge,
            color = Black,
            modifier = Modifier.padding(start = 23.dp)
        )

    }
}

@Composable
fun CardDeleteSolvedWork(modifier: Modifier = Modifier, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .width(172.dp)
            .height(53.dp)

            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(20.dp)
            ), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_delete),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp),
            tint = Black
        )
        Text(
            text = "Удалить",
            style = MaterialTheme.typography.labelLarge,
            color = Black,
            modifier = Modifier.padding(start = 23.dp)
        )

    }
}

@Composable
fun CardNotFound(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .width(274.dp)
            .height(391.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(45.dp)
            )
    ) {
        Image(
            painter = painterResource(R.drawable.not_found),
            contentDescription = null,
            modifier = Modifier.padding(start = 15.dp, top = 30.dp)
                .width(244.dp)
                .height(249.dp)
        )
        Text(
            text = "Ничего \n" +
                    "не найдено", textAlign = TextAlign.Center, modifier = Modifier.padding(top = 290.dp, start = 53.dp), style = MaterialTheme.typography.titleLarge
        )


    }
}


//@Preview
//@Composable
//private fun CardWorkPrev() {
//    QuizTheme { CardWork(modifier = Modifier, "Названиеeeeeeeeeeeee", "Описание работы)))))))))))))))))))))))))))", {}) }
//
//}

@Preview
@Composable
private fun ButtonLoginPrev() {
    QuizTheme { CardLookSolvedWork { } }
}

@Preview
@Composable
private fun ButtonDelete() {
    QuizTheme { CardDeleteSolvedWork { } }
}

@Preview
@Composable
private fun CardWorkPrev() {
   QuizTheme { CardWork(modifier = Modifier, "Title", "description", {}, false, true) }
}

@Preview
@Composable
private fun NotFoundPrev() {
   QuizTheme {  CardNotFound()}
}

