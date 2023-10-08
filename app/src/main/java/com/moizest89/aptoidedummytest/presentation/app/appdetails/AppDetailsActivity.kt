package com.moizest89.aptoidedummytest.presentation.app.appdetails

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.moizest89.aptoidedummytest.presentation.ui.theme.AptoideDummyTestTheme
import org.koin.androidx.compose.koinViewModel

const val EXTRA_NAME = "name"
const val EXTRA_PACKAGE_NAME = "packageName"
const val EXTRA_ICON = "icon"
const val EXTRA_BANNER = "banner"

class AppDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AptoideDummyTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val appDetailsViewModel = koinViewModel<AppDetailsViewModel>()
                    val packageName = intent.extras?.getString(EXTRA_PACKAGE_NAME, "")
                    appDetailsViewModel.fetchData(packageName ?: "")
                    AppDetailsContent(appDetailsViewModel) {
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("https://${it.uname}.en.aptoide.com/app")
                        )
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

fun launchWeb() {
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AptoideDummyTestTheme {
        AppDetailsContent(viewModel(), {})
    }
}
