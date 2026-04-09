package com.example.quiz.data.model

import androidx.compose.material3.DatePicker
import com.example.quiz.R

data class DataNavigationCategories(val icon: Int, val onClick: () -> Unit)

val categories = listOf(
    DataNavigationCategories(R.drawable.ic_home, {}),
    DataNavigationCategories(R.drawable.ic_search, {}),
    DataNavigationCategories(R.drawable.ic_file_addition, {}),
    DataNavigationCategories(R.drawable.ic_all_application, {}),
    DataNavigationCategories(R.drawable.ic_profile, {})

)