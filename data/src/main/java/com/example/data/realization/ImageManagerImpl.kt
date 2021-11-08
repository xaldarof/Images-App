package com.example.data.realization

import android.content.Context
import android.graphics.Bitmap
import com.example.data.cloud.abstraction.ImageManager
import android.graphics.drawable.BitmapDrawable
import android.os.Environment
import android.widget.ImageView
import java.io.File
import java.io.FileOutputStream
import javax.inject.Inject
import android.content.Intent
import android.net.Uri
import dagger.hilt.android.qualifiers.ApplicationContext
import android.provider.MediaStore
import android.widget.Toast
import com.example.data.R
import com.example.data.utils.DataConstants
import java.io.ByteArrayOutputStream


class ImageManagerImpl

@Inject constructor(@ApplicationContext private val context: Context) : ImageManager {

    override suspend fun saveImage(imageView: ImageView)  {
        try {
            val bitmapDrawable = imageView.drawable as BitmapDrawable
            val bitmap = bitmapDrawable.bitmap

            var outStream: FileOutputStream? = null
            val path: File = Environment.getExternalStorageDirectory()
            val dir = File(path.absolutePath.toString() + DataConstants.FILE_NAME)
            dir.mkdirs()
            val fileName = String.format("%d.jpg", System.currentTimeMillis())
            val outFile = File(dir, fileName)
            outStream = FileOutputStream(outFile)
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outStream)
            outStream.flush()
            outStream.close()

            notifyDataChanged(outFile)

            Toast.makeText(context, "${R.string.save_in} ${outFile.absolutePath}", Toast.LENGTH_SHORT).show()

        } catch (e: Exception) {
            Toast.makeText(context, R.string.an_error, Toast.LENGTH_SHORT).show()
        }
    }

    override fun shareImage(imageView: ImageView) {
        val bitmapDrawable = imageView.drawable as BitmapDrawable
        val bitmap = bitmapDrawable.bitmap

        val share = Intent(Intent.ACTION_SEND)
        share.type = DataConstants.IMAGE_TYPE
        val bytes = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes)
        val path = MediaStore.Images.Media.insertImage(
            context.contentResolver,
            bitmap, (System.currentTimeMillis() / 1000).toString(), null)
        val imageUri = Uri.parse(path)
        share.putExtra(Intent.EXTRA_STREAM, imageUri)
        context.startActivity(Intent.createChooser(share, DataConstants.SELECT_APP))

    }

    private fun notifyDataChanged(file: File) {
        val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
        intent.data = Uri.fromFile(file)
        context.sendBroadcast(intent)
    }
}