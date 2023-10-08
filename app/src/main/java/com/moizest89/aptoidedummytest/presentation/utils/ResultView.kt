package com.moizest89.aptoidedummytest.presentation.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.moizest89.aptoidedummytest.R
import com.moizest89.aptoidedummytest.databinding.ViewEmptyStateBinding
import com.moizest89.aptoidedummytest.presentation.utils.ResultView.TypeResultView.EMPTY
import com.moizest89.aptoidedummytest.presentation.utils.ResultView.TypeResultView.ERROR

class ResultView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var defaultTypeResultView: TypeResultView = EMPTY

    private val binding: ViewEmptyStateBinding = ViewEmptyStateBinding.inflate(
        LayoutInflater.from(context),
        this,
        true
    )

    init {
    }

    fun setTypeResultView(typeResultView: TypeResultView) = apply {
        defaultTypeResultView = typeResultView
        when (defaultTypeResultView) {
            EMPTY -> {
                binding.textView.text = context.getText(R.string.empty_result)
                binding.textViewResetFilter.visibility = View.VISIBLE
                binding.textViewOrLabel.visibility = View.VISIBLE
            }

            ERROR -> {
                binding.textView.text = context.getText(R.string.error_result)
                binding.textViewResetFilter.visibility = View.GONE
                binding.textViewOrLabel.visibility = View.GONE
            }
        }
    }

    fun onTryAgainButton(onClickListener: (typeResultView: TypeResultView) -> Unit) = apply {
        binding.button.setOnClickListener {
            onClickListener.invoke(defaultTypeResultView)
        }
    }

    fun onResetFilter(onResetFilter: () -> Unit) = apply {
        binding.textViewResetFilter.setOnClickListener {
            onResetFilter.invoke()
        }
    }

    enum class TypeResultView {
        EMPTY,
        ERROR,
    }
}
