package io.viesure.hiring.screen.articlelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import io.viesure.hiring.MainActivity
import io.viesure.hiring.R
import io.viesure.hiring.databinding.FragmentArticleListBinding
import io.viesure.hiring.screen.articledetail.ArticleDetailFragment
import io.viesure.hiring.screen.base.BaseFragment
import io.viesure.hiring.screen.base.viewModelFactory
import org.kodein.di.android.x.kodein
import org.kodein.di.direct
import org.kodein.di.generic.instance

class ArticleListFragment : BaseFragment() {
    override val viewModel by viewModels<ArticleListViewModel>(factoryProducer = { viewModelFactory { kodein.direct.instance<ArticleListViewModel>() } })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentArticleListBinding>(
            inflater,
            R.layout.fragment_article_list,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }
}