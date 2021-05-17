package edu.uw.vanessasgh.dotify.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Profile (
    val username: String,
    val firstName: String,
    val lastName: String,
    val profilePicURL: String
): Parcelable