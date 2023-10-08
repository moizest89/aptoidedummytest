package com.moizest89.aptoidedummytest.presentation.utils

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizest89.aptoidedummytest.presentation.ui.theme.AptoideDummyTestTheme

@Composable
fun LoadingCircular(
    modifier: Modifier = Modifier
) {
    Column(
        Modifier
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LoadingCircularPreview() {
    AptoideDummyTestTheme {
        LoadingCircular()
    }
}
