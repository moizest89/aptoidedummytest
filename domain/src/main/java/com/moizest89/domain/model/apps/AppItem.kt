package com.moizest89.domain.model.apps

data class AppItem(
    val added: String = "",
    val graphic: String? = "",
    val has_versions: Boolean = false,
    val icon: String = "",
    val id: Int = 0,
    val modified: String = "",
    val name: String = "",
    val packageName: String = "",
    val size: Int = 0,
    val uname: String = "",
    val updated: String = "",
    val uptype: String = "",
    val urls: List<String?> = listOf(),
    val versionCode: Int = 0,
    val media: AppItemMedia? = null
)

data class AppItemMedia(
    val description: String? = "",
    val keywords: List<String?>? = listOf(),
    val news: String? = "",
    val screenshots: List<AppItemMediaScreenshot>? = null,
    val summary: String? = ""
)

data class AppItemMediaScreenshot(
    val height: Int? = 0,
    val url: String? = "",
    val width: Int? = 0
)

data class Store(
    val avatar: String = "",
    val id: Int = 0,
    val name: String = ""
)

data class Malware(
    val rank: String = ""
)

data class Prating(
    val avg: Double = 0.0,
    val total: Int = 0
)

data class Rating(
    val avg: Double = 0.0,
    val total: Int = 0
)

data class Appearance(
    val description: String = "",
    val theme: String = ""
)
