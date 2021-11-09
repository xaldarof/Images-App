package dependencies

object Dependencies {

    object Coroutines {
        object Versions {
            const val coroutines_version = "1.3.9"
        }

        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines_version}"

    }


    object Network{
        object Versions{
            const val retrofit_version = "2.9.0"
            const val paging3_version = "3.0.1"
            const val gsonConverter_version = "2.9.0"
            const val glide_version = "4.12.0"
            const val chuck_version= "1.1.0"
        }

        const val chuckInterceptor = "com.readystatesoftware.chuck:library:${Versions.chuck_version}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide_version}"
        const val paging3 = "androidx.paging:paging-runtime:${Versions.paging3_version}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit_version}"
        const val RetrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter_version}"
    }

    object Cache {
        object Versions{
           const val persistenceRoom = "1.1.1"
           const val roomRuntime = "2.3.0"
           const val room = "2.3.0"
           const val roomCompiler = "2.3.0"
        }
        const val persistenceRoom = "android.arch.persistence.room:compiler:${Versions.persistenceRoom}"
        const val roomRuntime = "androidx.room:room-runtime:${Versions.roomRuntime}"
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val roomCompiler = "androidx.room:room-compiler:${Versions.roomCompiler}"

    }

    object Di {
        object Versions{
            const val legacySupport_version = "1.0.0"
            const val hiltCompiler_version = "1.0.0"
            const val hiltAndroidCompilerAlpha_version = "2.30.1-alpha"
            const val hiltAndroidCompiler_version = "2.35.1"
            const val hiltAndroid_version = "2.35"
            const val hiltCompilerGoogle_version = "2.35"
            const val hiltViewModel_version = "1.0.0-alpha03"
        }

       const val legacySupport = "androidx.legacy:legacy-support-v4:${Versions.legacySupport_version}"
       const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler_version}"
       const val hiltAndroidCompilerAlpha = "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompilerAlpha_version}"
       const val hiltAndroidCompiler =  "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler_version}"
       const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltAndroid_version}"
       const val hiltCompilerGoogle = "com.google.dagger:hilt-compiler:${Versions.hiltCompilerGoogle_version}"
       const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltViewModel_version}"


    }

    object Jitpack {
        object Versions {
            const val lifecycle_version = "2.2.0"
        }
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
        const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle_version}"
    }

    object View {
        object Versions {
            const val transformationLayout_version = "1.1.0"
            const val flexBoxLayout_version = "3.0.0"
            const val material_version = "1.3.0-alpha02"
        }
        const val transformationLayout = "com.github.skydoves:transformationlayout:${Versions.transformationLayout_version}"
        const val flexBoxLayout = "com.google.android.flexbox:flexbox:${Versions.flexBoxLayout_version}"
        const val material = "com.google.android.material:material:${Versions.material_version}"
    }
}