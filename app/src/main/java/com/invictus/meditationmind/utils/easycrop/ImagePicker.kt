package com.invictus.meditationmind.utils.easycrop

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

public interface ImagePicker {
    /** Pick an image with [mimetype] */
    fun pick(mimetype: String = "image/*")
}

/** Creates and remembers a instance of [ImagePicker] that launches
 * [ActivityResultContracts.GetContent] and calls [onImage] when the result is available */
@Composable
public fun rememberImagePicker(onImage: (uri: Uri) -> Unit): ImagePicker {
    val contract = remember { ActivityResultContracts.GetContent() }
    val launcher = rememberLauncherForActivityResult(
        contract = contract,
        onResult = { if (it != null) onImage(it) })
    return remember {
        object : ImagePicker {
            override fun pick(mimetype: String) = launcher.launch(mimetype)
        }
    }
}