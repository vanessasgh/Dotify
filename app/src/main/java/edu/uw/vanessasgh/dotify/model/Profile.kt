package edu.uw.vanessasgh.dotify.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Profile (
    val username: String,
    val firstname: String,
    val lastname: String,
    val profilePicURL: String
): Parcelable