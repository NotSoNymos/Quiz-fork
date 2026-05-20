package com.example.quiz.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quiz.R
import com.example.quiz.data.model.Quiz
import com.example.quiz.ui.theme.Black
import com.example.quiz.ui.theme.QuizTheme

@Composable
fun CardWork(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    onClick: () -> Unit,
    flagSettings: Boolean,

    ) {
    Box(
        modifier = Modifier
            .padding(bottom = 20.dp)
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
//@Composable
//fun CardResolvedWork(
//    modifier: Modifier = Modifier,
//    title: String,
//    text: String,
//    onClick: () -> Unit,
//    count,
//
//    ) {
//    Box(
//        modifier = Modifier
//            .padding(bottom = 20.dp)
//            .width(333.dp)
//            .height(105.dp)
//            .background(
//                color = MaterialTheme.colorScheme.secondary,
//                shape = RoundedCornerShape(20.dp)
//            )
//
//    ) {
//        if (flagSettings) {
//            Icon(
//                painter = painterResource(R.drawable.ic_setting_config),
//                contentDescription = null,
//                modifier = Modifier
//                    .padding(start = 294.dp, top = 15.dp)
//                    .size(24.dp),
//                tint = Black
//            )
//        }
//
//
//
//        Column(
//            modifier = Modifier
//                .padding(start = 23.dp, top = 15.dp)
//                .fillMaxSize()
//
//        ) {
//            Text(text = title, style = MaterialTheme.typography.labelMedium)
//            Text(
//                text = text,
//                style = MaterialTheme.typography.labelSmall,
//                modifier = Modifier.padding(start = 20.dp)
//            )
//        }
//    }
//
//}


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
            modifier = Modifier
                .padding(start = 15.dp, top = 30.dp)
                .width(244.dp)
                .height(249.dp)
        )
        Text(
            text = "Ничего \n" +
                    "не найдено",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 290.dp, start = 53.dp),
            style = MaterialTheme.typography.titleLarge
        )


    }
}


@Composable
fun CardTitle(modifier: Modifier = Modifier, title: String, color: Color) {
    
    Box(
        modifier = modifier
            .background(
                color = color,
                shape = RoundedCornerShape(15.dp)
            )
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp),
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxSize(),
            textAlign = TextAlign.Center
        )

    }
}

@Composable
fun CardDescription(modifier: Modifier = Modifier, description: String) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .width(346.dp)
            .verticalScroll(scrollState)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Text(text = description, style = MaterialTheme.typography.bodySmall)
    }
}


@Composable
fun ReadBookCard(modifier: Modifier = Modifier, description: String, title: String) {
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .width(367.dp)
            .verticalScroll(scrollState)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp)
                .width(335.dp)
        ) {
            CardTitle(title = title, color = MaterialTheme.colorScheme.primary)
        }

        Text(
            text = description,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 101.dp, start = 10.dp, end = 10.dp).height(500.dp)
        )
    }
}

@Composable
fun CardWorkQuiz(modifier: Modifier = Modifier, quiz: Quiz, onClick: () -> Unit, count: String) {
    Box(){
        CardWork(title = quiz.title, text = quiz.description, onClick = {}, flagSettings = false)
        Box(
            modifier = Modifier
                .padding(top = 24.dp, start = 206.dp)
                .width(107.dp)
                .height(58.dp)
        ) {
            CardTitle(title = count, color = MaterialTheme.colorScheme.primary)
        }
    }


}


@Composable
fun CardVariableVariant(modifier: Modifier = Modifier, text: String) {
    Box(
        modifier = Modifier
            .width(346.dp)
            .height(68.dp)
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(15.dp)
            )
    ) {
        SimpleCheckbox(
            Modifier
                .padding(start = 11.dp, top = 3.dp)
                .fillMaxSize(), {}
        )
        Text(
            text = text,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 60.dp, top = 19.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
private fun CardVariableVariantPreview() {
    QuizTheme { CardVariableVariant(Modifier, "Вопрос") }
}

@Preview
@Composable
private fun Preview() {
    QuizTheme { CardWorkQuiz(Modifier, Quiz(0,"Title", "Description", listOf()), {}, "16") }
}

@Preview
@Composable
private fun ReadBookCardPreview() {
    QuizTheme {


        ReadBookCard(
            title = "title", description = "У лукоморья дуб зелёный;\n" +
                    "Златая цепь на дубе том:\n" +
                    "И днём и ночью кот учёный\n" +
                    "Всё ходит по цепи кругом;\n" +
                    "Идёт направо — песнь заводит,\n" +
                    "Налево — сказку говорит.\n" +
                    "Там чудеса: там леший бродит,\n" +
                    "Русалка на ветвях сидит;\n" +
                    "Там на неведомых дорожках\n" +
                    "Следы невиданных зверей;\n" +
                    "Избушка там на курьих ножках\n" +
                    "Стоит без окон, без дверей;\n" +
                    "Там лес и дол видений полны;\n" +
                    "Там о заре прихлынут волны\n" +
                    "На брег песчаный и пустой,\n" +
                    "И тридцать витязей прекрасных\n" +
                    "Чредой из вод выходят ясных,\n" +
                    "И с ними дядька их морской;\n" +
                    "Там королевич мимоходом\n" +
                    "Пленяет грозного царя;\n" +
                    "Там в облаках перед народом\n" +
                    "Через леса, через моря\n" +
                    "Колдун несёт богатыря;\n" +
                    "В темнице там царевна тужит,\n" +
                    "А бурый волк ей верно служит;\n" +
                    "Там ступа с Бабою Ягой\n" +
                    "Идёт, бредёт сама собой,\n" +
                    "Там царь Кащей над златом чахнет;\n" +
                    "Там русский дух… там Русью пахнет!\n" +
                    "И там я был, и мёд я пил;\n" +
                    "У моря видел дуб зелёный;\n" +
                    "Под ним сидел, и кот учёный\n" +
                    "Свои мне сказки говорил.\n"
        )
    }
}

@Preview
@Composable
private fun CardDescriptionPreview() {
    QuizTheme {

        CardDescription(
            description = "У лукоморья дуб зелёный;\n" +
                    "Златая цепь на дубе том:\n" +
                    "И днём и ночью кот учёный\n" +
                    "Всё ходит по цепи кругом;\n" +
                    "Идёт направо — песнь заводит,\n" +
                    "Налево — сказку говорит.\n" +
                    "Там чудеса: там леший бродит,\n" +
                    "Русалка на ветвях сидит;\n" +
                    "Там на неведомых дорожках\n" +
                    "Следы невиданных зверей;\n" +
                    "Избушка там на курьих ножках\n" +
                    "Стоит без окон, без дверей;\n" +
                    "Там лес и дол видений полны;\n" +
                    "Там о заре прихлынут волны\n" +
                    "На брег песчаный и пустой,\n" +
                    "И тридцать витязей прекрасных\n" +
                    "Чредой из вод выходят ясных,\n" +
                    "И с ними дядька их морской;\n" +
                    "Там королевич мимоходом\n" +
                    "Пленяет грозного царя;\n" +
                    "Там в облаках перед народом\n" +
                    "Через леса, через моря\n" +
                    "Колдун несёт богатыря;\n" +
                    "В темнице там царевна тужит,\n" +
                    "А бурый волк ей верно служит;\n" +
                    "Там ступа с Бабою Ягой\n" +
                    "Идёт, бредёт сама собой,\n" +
                    "Там царь Кащей над златом чахнет;\n" +
                    "Там русский дух… там Русью пахнет!\n" +
                    "И там я был, и мёд я пил;\n" +
                    "У моря видел дуб зелёный;\n" +
                    "Под ним сидел, и кот учёный\n" +
                    "Свои мне сказки говорил.\n"
        )
    }
}


@Composable
fun SimpleCardNavigation(
    modifier: Modifier = Modifier,
    icon: Int,
    onClick: () -> Unit,
    modifierIcon: Modifier = modifier
) {
    val isCheck = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .padding(top = 7.dp)
            .clickable(onClick = {
                onClick
                isCheck.value = !isCheck.value
            })
            .size(56.dp)
            .background(
                if (isCheck.value) MaterialTheme.colorScheme.secondary else Color.Unspecified,
                shape = RoundedCornerShape(15.dp)
            ), contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = modifierIcon,
            tint = Black
        )

    }
}

@Preview
@Composable
private fun CardTitlePreview() {
    QuizTheme {
        CardTitle(
            Modifier
                .width(346.dp)
                .height(71.dp), title = "Title", color = MaterialTheme.colorScheme.primary
        )
    }
}

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
    QuizTheme { CardWork(modifier = Modifier, "Title", "description", {}, false) }
}

@Preview
@Composable
private fun NotFoundPrev() {
    QuizTheme { CardNotFound() }
}

