/**
 * Created by Iqbal Fauzi on 12/24/20 2:14 PM
 * iqbal.fauzi.if99@gmail.com
 */
object Apps {
    const val compileSdk = 30
    const val buildTools = "30.0.2"
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Modules {
    const val CORE = ":libraries:core"
    const val MOVIE = ":presentations:movie"
    const val DETAIL = ":presentations:detail"
}

object Versions {
    const val gradle = "4.1.1"
    const val kotlin = "1.4.21"
    const val appcompat = "1.2.0"

    /* test */
    const val junit = "4.13.1"
}

object Libs {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
}

object TestLibs {
    const val junit = "junit:junit:${Versions.junit}"
}