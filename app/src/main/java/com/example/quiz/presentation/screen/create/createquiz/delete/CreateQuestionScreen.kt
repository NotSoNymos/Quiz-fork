package com.example.quiz.presentation.screen.create.createquiz.delete

/*
@Composable
fun CreateQuestionScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val createQuestionFormState by rememberSaveable { mutableStateOf(CreateQuestionFormState()) }

    SimpleQuizBackground(modifier = Modifier, "Создать учебник", "book", navHostController)
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            modifier = modifier
                .padding(top = 209.dp)
                .width(367.dp)
                .height(503.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(15.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleOutlinedText(
                modifier = Modifier.width(335.dp),
                "",
                "Название",
                {},
                MaterialTheme.colorScheme.primaryContainer,
                shape = 20
            )
            SimpleOutlinedText(
                modifier = Modifier
                    .width(367.dp)
                    .height(403.dp),
                "",
                "Описание",
                {},
                MaterialTheme.colorScheme.secondary,
                shape = 20
            )

        }
        Row(){
            SimpleButton(
                modifier = Modifier
                    .padding(top = 18.dp, start = 70.dp),
                text = "Сохранить"
            ) { navHostController.navigate(Destinations.CreateQuestion) }

            ButtonAddParagraph(modifier = Modifier.padding(10.dp)) { }

        }

    }
}

@Preview
@Composable
private fun CreateQuestionPreview() {
    QuizTheme { CreateQuestionScreen(Modifier, rememberNavController()) }
}

 */