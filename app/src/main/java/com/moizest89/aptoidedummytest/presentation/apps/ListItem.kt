package com.moizest89.aptoidedummytest.presentation.apps

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.moizest89.aptoidedummytest.R
import com.moizest89.aptoidedummytest.presentation.ui.theme.AptoideDummyTestTheme
import com.moizest89.domain.model.apps.AppItem

@Composable
fun ListItem(appItem: AppItem, onClickItem: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val imagePainter = rememberAsyncImagePainter(
                model = appItem.icon,
                error = painterResource(id = R.drawable.aptoide_logo_banner)
            )
            Image(
                painter = imagePainter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .weight(0.4f)
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(CircleShape)
            )

            Column(
                modifier = Modifier
                    .weight(0.6f)
            ) {
                Text(
                    text = appItem.name,
                    style = TextStyle(fontSize = 20.sp),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Descripción del elemento",
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListItemPreviewDark() {
    AptoideDummyTestTheme {
        ListItem(
            AppItem(
                name = "Test Name"
            ),
            {}
        )
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ListItemPreviewLight() {
    AptoideDummyTestTheme {
        ListItem(
            AppItem(
                name = "Test Name"
            ),
            {}
        )
    }
}
