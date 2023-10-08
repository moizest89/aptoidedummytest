package com.moizest89.aptoidedummytest.presentation.apps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.moizest89.aptoidedummytest.presentation.app.applist.AppListViewModel
import com.moizest89.aptoidedummytest.presentation.ui.theme.AptoideDummyTestTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class AppsListActivity : ComponentActivity() {

    private val appListViewModel: AppListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AptoideDummyTestTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    launch()
                }
            }
        }
    }

    private fun launch() {
        appListViewModel.getAppListInformation("")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AptoideDummyTestTheme {
    }
}
