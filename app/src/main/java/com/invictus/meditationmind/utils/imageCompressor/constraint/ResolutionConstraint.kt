package com.invictus.meditationmind.utils.imageCompressor.constraint

import android.graphics.BitmapFactory
import com.invictus.meditationmind.utils.imageCompressor.calculateInSampleSize
import com.invictus.meditationmind.utils.imageCompressor.decodeSampledBitmapFromFile
import com.invictus.meditationmind.utils.imageCompressor.determineImageRotation
import com.invictus.meditationmind.utils.imageCompressor.overWrite
import java.io.File

/**
 * Created on : January 24, 2020
 * Author     : zetbaitsu
 * Name       : Zetra
 * GitHub     : https://github.com/zetbaitsu
 */
class ResolutionConstraint(private val width: Int, private val height: Int) : Constraint {

    override fun isSatisfied(imageFile: File): Boolean {
        return BitmapFactory.Options().run {
            inJustDecodeBounds = true
            BitmapFactory.decodeFile(imageFile.absolutePath, this)
            calculateInSampleSize(this, width, height) <= 1
        }
    }

    override fun satisfy(imageFile: File): File {
        return decodeSampledBitmapFromFile(imageFile, width, height).run {
            determineImageRotation(imageFile, this).run {
                overWrite(imageFile, this)
            }
        }
    }
}

fun Compression.resolution(width: Int, height: Int) {
    constraint(ResolutionConstraint(width, height))
}