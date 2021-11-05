package com.example.data.realization

import android.content.Context
import android.graphics.Bitmap
import com.example.data.cloud.abstraction.ImageSaver
import android.graphics.drawable.BitmapDrawable
import android.os.Environment
import android.widget.ImageView
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import android.content.Intent
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class ImageSaverImpl @Inject constructor(@ApplicationContext private val context: Context) :
    ImageSaver {

    override suspend fun saveImage(imageView: ImageView) = suspendCoroutine<String> {
        try {
            val bitmapDrawable = imageView.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap

            var outStream: FileOutputStream? = null
            val sdCard: File = Environment.getExternalStorageDirectory()
            val dir = File(sdCard.absolutePath.toString() + "/NewMyImages")
            dir.mkdirs()
            val fileName = String.format("%d.jpg", System.currentTimeMillis())
            val outFile = File(dir, fileName)
            outStream = FileOutputStream(outFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream)
            outStream.flush()
            outStream.close()

            it.resume(outFile.absolutePath)
            notifyDataChanged(outFile)

        }catch (e:Exception){
            it.resume("Произошла ошибка")
        }
    }

    private fun notifyDataChanged(file: File) {
        val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        intent.data = Uri.fromFile(file)
        context.sendBroadcast(intent)
    }
}