package com.moizest89.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppDetails(
    @SerialName("info")
    val info: AppDetailsInfo = AppDetailsInfo(),
    @SerialName("nodes")
    val nodes: Nodes = Nodes()
)

@Serializable
data class AppDetailsInfo(
    @SerialName("status")
    val status: String? = "",
    @SerialName("time")
    val time: Time? = Time()
)

@Serializable
data class Nodes(
    @SerialName("meta")
    val meta: Meta? = Meta(),
    @SerialName("versions")
    val versions: Versions? = Versions()
)

@Serializable
data class Meta(
    @SerialName("data")
    val data: AppInfo? = AppInfo(),
    @SerialName("info")
    val info: Info? = Info()
)

@Serializable
data class Versions(
    @SerialName("info")
    val info: Info? = Info(),
    @SerialName("list")
    val list: List<AppInfo>? = listOf()
)

@Serializable
data class Age(
    @SerialName("name")
    val name: String? = "",
    @SerialName("pegi")
    val pegi: String? = "",
    @SerialName("rating")
    val rating: Int? = 0,
    @SerialName("title")
    val title: String? = ""
)

@Serializable
data class Developer(
    @SerialName("email")
    val email: String? = "",
    @SerialName("id")
    val id: Int? = 0,
    @SerialName("name")
    val name: String? = "",
    @SerialName("privacy")
    val privacy: String? = "",
    @SerialName("website")
    val website: String? = ""
)

@Serializable
data class AppDetailsFile(
    @SerialName("added")
    val added: String? = "",
    @SerialName("filesize")
    val filesize: Int? = 0,
    @SerialName("flags")
    val flags: Flags? = Flags(),
    @SerialName("hardware")
    val hardware: Hardware? = Hardware(),
    @SerialName("malware")
    val malware: Malware? = Malware(),
    @SerialName("md5sum")
    val md5sum: String? = "",
    @SerialName("path")
    val path: String? = "",
    @SerialName("path_alt")
    val pathAlt: String? = "",
    @SerialName("signature")
    val signature: Signature? = Signature(),
    @SerialName("tags")
    val tags: List<String>? = listOf(),
    @SerialName("used_features")
    val usedFeatures: List<String?>? = listOf(),
    @SerialName("used_permissions")
    val usedPermissions: List<String?>? = listOf(),
    @SerialName("vercode")
    val vercode: Int? = 0,
    @SerialName("vername")
    val vername: String? = ""
)

@Serializable
data class Flags(
    @SerialName("review")
    val review: String? = ""
)

@Serializable
data class Hardware(
    @SerialName("cpus")
    val cpus: List<String?>? = listOf(),
    @SerialName("gles")
    val gles: Int? = 0,
    @SerialName("screen")
    val screen: String? = "",
    @SerialName("sdk")
    val sdk: Int? = 0
)

@Serializable
data class Signature(
    @SerialName("owner")
    val owner: String? = "",
    @SerialName("sha1")
    val sha1: String? = ""
)

@Serializable
data class Reason(
    @SerialName("manual_qa")
    val manualQa: ManualQa? = ManualQa(),
    @SerialName("scanned")
    val scanned: Scanned? = Scanned(),
    @SerialName("signature_validated")
    val signatureValidated: SignatureValidated? = SignatureValidated()
)

@Serializable
data class ManualQa(
    @SerialName("date")
    val date: String? = "",
    @SerialName("status")
    val status: String? = "",
    @SerialName("tester")
    val tester: String? = ""
)

@Serializable
data class Scanned(
    @SerialName("av_info")
    val avInfo: List<AvInfo?>? = listOf(),
    @SerialName("date")
    val date: String? = "",
    @SerialName("status")
    val status: String? = ""
)

@Serializable
data class SignatureValidated(
    @SerialName("date")
    val date: String? = "",
    @SerialName("signature_from")
    val signatureFrom: String? = "",
    @SerialName("status")
    val status: String? = ""
)

@Serializable
data class AvInfo(
    @SerialName("name")
    val name: String? = ""
)

@Serializable
data class Screenshot(
    @SerialName("height")
    val height: Int? = 0,
    @SerialName("url")
    val url: String? = "",
    @SerialName("width")
    val width: Int? = 0
)

@Serializable
data class Vote(
    @SerialName("count")
    val count: Int? = 0,
    @SerialName("value")
    val value: Int? = 0
)
