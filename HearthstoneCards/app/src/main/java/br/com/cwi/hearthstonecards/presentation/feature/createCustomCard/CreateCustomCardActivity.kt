package br.com.cwi.hearthstonecards.presentation.feature.createCustomCard

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import br.com.cwi.hearthstonecards.databinding.ActivityCreateCustomCardBinding
import br.com.cwi.hearthstonecards.domain.entity.CustomCard
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.io.ByteArrayOutputStream

private const val REQUEST_CODE = 42
class CreateCustomCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateCustomCardBinding

    private val viewModel: CreateCustomCardViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCustomCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpCamera()
        setUpSaveCardActions()
    }

    private fun setUpCamera() {
        binding.btnTakePicture.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val takenImage = data?.extras?.get("data") as Bitmap
            binding.ivPictureTaken.setImageBitmap(takenImage)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    private fun setUpSaveCardActions() {
        binding.btnSaveCard.setOnClickListener {
            val timestampNow = (System.currentTimeMillis()/1000).toInt()
            val cardName = binding.etInsertCardName.text.toString()
            val createdCustomCard = CustomCard(timestampNow, cardName, getByteArrayOfCustomCardImage())
            viewModel.saveCardToLocalStorage(createdCustomCard)
        }
    }

    private fun getByteArrayOfCustomCardImage(): ByteArray {
        val byteArrayCardImage = ByteArrayOutputStream()
        binding.rlCustomCardImg.isDrawingCacheEnabled = true
        val cardImage = Bitmap.createBitmap(binding.rlCustomCardImg.drawingCache)
        cardImage.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayCardImage)
        binding.rlCustomCardImg.isDrawingCacheEnabled = false
        return byteArrayCardImage.toByteArray()
    }
}