package com.moizest89.aptoidedummytest.presentation.app.appdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.moizest89.aptoidedummytest.R.drawable
import com.moizest89.aptoidedummytest.presentation.ui.theme.AptoideDummyTestTheme
import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.model.apps.AppItemMediaScreenshot
import com.moizest89.domain.utils.DataHandler.onError
import com.moizest89.domain.utils.DataHandler.onLoad
import com.moizest89.domain.utils.DataHandler.onSuccess

@Composable
fun AppDetailsContent(
    appDetailsViewModel: AppDetailsViewModel = viewModel(),
    onDownload: (appItem: AppItem) -> Unit
) {
    val dataState by appDetailsViewModel.dataState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        when (dataState) {
            is onLoad -> {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }
            }

            is onSuccess -> {
                val appItem: AppItem = (dataState as onSuccess).data
                item {
                    val imagePainterBanner = rememberAsyncImagePainter(
                        model = appItem.graphic,
                        error = painterResource(id = drawable.aptoide_logo_banner)
                    )
                    Image(
                        painter = imagePainterBanner,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                item {
                    val imagePainterIcon = rememberAsyncImagePainter(
                        model = appItem.icon,
                        error = painterResource(id = drawable.aptoide_logo_banner)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = imagePainterIcon,
                            contentDescription = "icon",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(128.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Gray, CircleShape)
                        )
                        Column(
                            modifier = Modifier
                                .padding(8.dp)
                        ) {
                            Text(
                                text = appItem.name,
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Black
                            )
                            Spacer(modifier = Modifier.height(1.dp))
                            Text(
                                text = "Version: ${appItem.versionCode}",
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
                item {
                    Text(
                        text = appItem.media?.summary ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp),
                        fontWeight = FontWeight.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                }
                item {
                    Text(
                        text = appItem.media?.description ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                val screenShots = appItem.media?.screenshots
                if (!screenShots.isNullOrEmpty()) {
                    item {
                        Text(
                            text = "Gallery",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(16.dp),
                            fontWeight = FontWeight.Black
                        )
                    }
                    item {
                        ScrollableRow(screenShots ?: emptyList())
                    }
                }
                item {
                    Button(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth(),
                        onClick = {
                            onDownload.invoke(appItem)
                        }
                    ) {
                        Text(text = "Downloand App")
                    }
                }
            }

            is onError -> {
                val message = (dataState as onError).message
                item {
                    Text(
                        text = "Error: $message",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Red,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ScrollableRow(items: List<AppItemMediaScreenshot>) {
    Row(
        Modifier
            .horizontalScroll(rememberScrollState()) // this makes it scrollable
            .height(intrinsicSize = IntrinsicSize.Max) // this make height of all cards to the tallest card.
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        repeat(items.size) {
            RowItem(items[it].url ?: "")
        }
    }
}

@Composable
fun RowItem(itemUrl: String) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .width(160.dp)
            .height(240.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            val imageScreenShoots = rememberAsyncImagePainter(
                model = itemUrl,
                error = painterResource(id = drawable.aptoide_logo_banner)
            )
            Image(
                painter = imageScreenShoots,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppDetailsContentPreview() {
    AptoideDummyTestTheme {
        AppDetailsContent(viewModel(), {})
    }
}
