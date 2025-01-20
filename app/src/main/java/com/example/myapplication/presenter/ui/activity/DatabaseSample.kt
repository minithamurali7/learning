package com.example.myapplication.presenter.ui.activity

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.db.NoteDao
import com.example.myapplication.db.NoteEntity
import com.example.myapplication.db.NoteRoomDatabase
import com.example.myapplication.domain.repository.NoteRepo
import com.example.myapplication.presenter.ui.viewmodel.NoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.mindrot.jbcrypt.BCrypt
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.IOException


@AndroidEntryPoint
class DatabaseSample : ComponentActivity() {
    val noteViewModel: NoteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
                layout()
            }
        }

    }

    @Composable
    private fun layout() {
        Column(modifier = Modifier.fillMaxSize()) {
            Button(
                modifier = Modifier.align(Alignment.Start),
                onClick = {
                    val file = R.drawable.ic_launcher_background
                    val imageByteArray = ByteArray(5)
                    noteViewModel.insertNote(
                        NoteEntity(
                            title = "Ram c/o Anandhi",
                            subTitle = "Novel",
                            content = "it is thriller romantic story",
                            author = "Akhil p dev",
                            hashPassword = BCrypt.hashpw("12345", BCrypt.gensalt())
                        )
                    )
                },
            ) {
                Text(text = "Insert")
            }

            Button(
                modifier = Modifier.align(Alignment.Start),
                onClick = {
                  /*  noteViewModel.get()?.observe(this@DatabaseSample, Observer {
                        android.util.Log.d("Notes", it[0].toString())
                    })*/
                },
            ) {
                Text(text = "Fetch Notes")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        layout()
    }

    fun convertImageToByteArray(imageFile: File): ByteArray? {
        return try {
            val bitmap = BitmapFactory.decodeStream(FileInputStream(imageFile))
            val byteArrayOutputStream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
            byteArrayOutputStream.toByteArray()
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

}