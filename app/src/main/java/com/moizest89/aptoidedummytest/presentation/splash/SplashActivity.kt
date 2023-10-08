package com.moizest89.aptoidedummytest.presentation.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.moizest89.aptoidedummytest.R
import com.moizest89.aptoidedummytest.presentation.app.applist.AppListActivity
import com.moizest89.aptoidedummytest.presentation.ui.theme.AptoideDummyTestTheme
import com.moizest89.domain.utils.DataHandler.onSuccess
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AptoideDummyTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.primary
                ) {
                    SplashView()
                }
                splashViewModel
                    .validateUser()
                    ._splasStatus.observe(this) {
                        when (it) {
                            is onSuccess -> {
                                moveToNext()
                            }

                            else -> {}
                        }
                    }
            }
        }
    }

    private fun moveToNext() {
        val intent = Intent(this, AppListActivity::class.java)
        startActivity(intent)
        finish()
    }
}

@Composable
fun SplashView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.aptoide_logo_banner),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentScale = ContentScale.Fit
        )
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp),
            color = MaterialTheme.colorScheme.surfaceVariant

        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    AptoideDummyTestTheme {
        SplashView()
    }
}
