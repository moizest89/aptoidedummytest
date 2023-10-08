package com.moizest89.aptoidedummytest.presentation.app.applist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.moizest89.aptoidedummytest.R
import com.moizest89.aptoidedummytest.databinding.ActivityAppListBinding
import com.moizest89.aptoidedummytest.presentation.app.appdetails.AppDetailsActivity
import com.moizest89.aptoidedummytest.presentation.app.appdetails.EXTRA_BANNER
import com.moizest89.aptoidedummytest.presentation.app.appdetails.EXTRA_ICON
import com.moizest89.aptoidedummytest.presentation.app.appdetails.EXTRA_NAME
import com.moizest89.aptoidedummytest.presentation.app.appdetails.EXTRA_PACKAGE_NAME
import com.moizest89.aptoidedummytest.presentation.utils.ResultView.TypeResultView.EMPTY
import com.moizest89.aptoidedummytest.presentation.utils.ResultView.TypeResultView.ERROR
import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.utils.DataHandler.onError
import com.moizest89.domain.utils.DataHandler.onLoad
import com.moizest89.domain.utils.DataHandler.onSuccess
import org.koin.androidx.viewmodel.ext.android.viewModel

const val SEARCH_NAME_BY_DEFAULT = "telegram"

class AppListActivity : AppCompatActivity() {

    private val appListViewModel: AppListViewModel by viewModel()
    private lateinit var _binding: ActivityAppListBinding
    private lateinit var adapter: AppListAdapter
    private var appNameRequested: String = SEARCH_NAME_BY_DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAppListBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        with(_binding.recyclerView) {
            layoutManager = GridLayoutManager(this@AppListActivity, 2)
        }
        adapter = AppListAdapter() { item, position ->
            moveToNext(item)
        }
        _binding.recyclerView.adapter = adapter
        setTitleApp(appNameRequested)
        sendRequest()
            ._data.observe(this) {
                when (it) {
                    is onError -> {
                        _binding.emptyViewResult.setTypeResultView(ERROR)
                        _binding.emptyViewResult.visibility = View.VISIBLE
                    }

                    is onLoad -> loadingStatus(it.loading)
                    is onSuccess -> loadData(it.data.toMutableList())
                }
            }

        _binding.fab.setOnClickListener { view ->
            callDialog()
        }
        _binding.emptyViewResult.onTryAgainButton {
            when (it) {
                EMPTY -> callDialog()
                ERROR -> {
                    sendRequest()
                }
            }
        }.onResetFilter {
            appNameRequested = SEARCH_NAME_BY_DEFAULT
            sendRequest()
        }
        _binding.swipeToRefresh.setOnRefreshListener {
            sendRequest()
        }
    }

    private fun sendRequest(): AppListViewModel {
        appListViewModel.getAppListInformation(appNameRequested)
        setTitleApp(appNameRequested)
        return appListViewModel
    }

    private fun callDialog() {
        searchDialog {
            appNameRequested = it
            sendRequest()
        }.show()
    }

    private fun loadingStatus(isLoading: Boolean) = apply {
        _binding.progressBar.visibility = if (isLoading) {
            View.VISIBLE
        } else View.GONE
        if (isLoading) _binding.swipeToRefresh.visibility = View.GONE
        if (isLoading) _binding.emptyViewResult.visibility = View.GONE
        if (!isLoading && _binding.swipeToRefresh.isRefreshing) _binding.swipeToRefresh.isRefreshing =
            false
    }

    private fun loadData(data: MutableList<AppItem>) = apply {
        if (data.isNotEmpty()) {
            adapter.reloadData(data)
            _binding.swipeToRefresh.visibility = View.VISIBLE
        } else {
            _binding.emptyViewResult.setTypeResultView(EMPTY)
            _binding.emptyViewResult.visibility = View.VISIBLE
            _binding.swipeToRefresh.visibility = View.GONE
        }
    }

    private fun moveToNext(appItem: AppItem) {
        Intent(this, AppDetailsActivity::class.java).also {
            it.putExtra(EXTRA_NAME, appItem.name)
            it.putExtra(EXTRA_PACKAGE_NAME, appItem.packageName)
            it.putExtra(EXTRA_ICON, appItem.icon)
            it.putExtra(EXTRA_BANNER, appItem.graphic)
            startActivity(it)
        }
    }

    private fun searchDialog(
        search: (String) -> Unit
    ): AlertDialog {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val editText = EditText(this)
        builder
            .setTitle(R.string.search_here_label)
            .setView(editText)
            .setPositiveButton(android.R.string.ok) { dialog, which ->
                val text = editText.text.toString()
                if (text.isNotEmpty()) {
                    search.invoke(text)
                }
            }
            .setNegativeButton(android.R.string.cancel) { dialog, which ->
            }
        return builder.create()
    }

    private fun setTitleApp(
        appName: String
    ) {
        _binding.textViewSearchAppItem.text = String.format("Search results of: %s", appName)
    }
}
