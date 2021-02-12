package com.iqbalfauzi.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.iqbalfauzi.core.ui.BaseActivity
import com.iqbalfauzi.detail.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<DetailViewModel, ActivityDetailBinding>(
    DetailViewModel::class,
    ActivityDetailBinding::inflate
) {
    override fun onInitUI(savedInstanceState: Bundle?) {
        subscribe()
    }

    override fun loadDependencies() {
        DetailModule.load()
    }

    private fun subscribe() {
        with(mViewModel){
            movieData.observe(this@DetailActivity, {
                mBinding.textView.text = it.originalTitle
            })
            movieTitleData.observe(this@DetailActivity, {
                mBinding.textView1.text = it
            })

            messageLiveData.observe(this@DetailActivity, {
                Toast.makeText(this@DetailActivity, it, Toast.LENGTH_SHORT).show()
            })

            isLoading.observe(this@DetailActivity, {
                if (it) {
                    mBinding.progressBar.visibility = View.VISIBLE
                } else {
                    mBinding.progressBar.visibility = View.GONE
                }
            })
            getMovie(464052)
        }
    }
}