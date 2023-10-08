package com.moizest89.aptoidedummytest.presentation.apps

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.moizest89.aptoidedummytest.presentation.ui.theme.AptoideDummyTestTheme
import com.moizest89.domain.model.apps.AppItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppsListView(
    modifier: Modifier = Modifier,
    data: List<AppItem> = emptyList(),
    onClickItem: () -> Unit,
    onSearItem: (String) -> Unit
) {
    var searchText by remember { mutableStateOf(TextFieldValue()) }

    Column(modifier = Modifier.fillMaxSize()) {
        // EditText de búsqueda en la parte superior
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearItem.invoke(it.text)
            },
            label = { Text("Buscar") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )

        // Lista de elementos
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(data.size) { item ->
                ListItem(data[item], onClickItem)
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun MovieItemPreviewDark() {
    AptoideDummyTestTheme {
        AppsListView(Modifier, emptyList(), {}, {})
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun MovieItemPreviewLight() {
    AptoideDummyTestTheme {
        AppsListView(Modifier, emptyList(), {}, {})
    }
}
