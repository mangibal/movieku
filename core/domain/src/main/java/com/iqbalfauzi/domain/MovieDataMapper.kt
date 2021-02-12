package com.iqbalfauzi.domain

import com.iqbalfauzi.data.model.MovieEntity

/**
 * Created by Iqbal Fauzi on 1/31/21 2:19 PM
 * iqbal.fauzi.if99@gmail.com
 */
object MovieDataMapper {

    fun MovieEntity.toUiData(): MovieEntityUI {
        return MovieEntityUI(
            this.id.toString(),
            this.title,
            this.overview,
            this.posterPath
        )
    }

}