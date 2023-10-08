package com.moizest89.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppSearchList(
    @SerialName("datalist")
    val datalist: Datalist = Datalist(),
    @SerialName("info")
    val info: Info = Info()
)

@Serializable
data class Datalist(
    @SerialName("count")
    val count: Int = 0,
    @SerialName("hidden")
    val hidden: Int = 0,
    @SerialName("limit")
    val limit: Int = 0,
    @SerialName("list")
    val list: List<AppInfo> = listOf(),
    @SerialName("loaded")
    val loaded: Boolean = false,
    @SerialName("next")
    val next: Int = 0,
    @SerialName("offset")
    val offset: Int = 0,
    @SerialName("total")
    val total: Int = 0
)

@Serializable
data class Info(
    @SerialName("status")
    val status: String = "",
    @SerialName("time")
    val time: Time = Time()
)

@Serializable
data class AppInfo(
    @SerialName("added")
    val added: String = "",
    @SerialName("appcoins")
    val appcoins: Appcoins = Appcoins(),
    @SerialName("graphic")
    val graphic: String? = "",
    @SerialName("has_versions")
    val hasVersions: Boolean = false,
    @SerialName("icon")
    val icon: String = "",
    @SerialName("id")
    val id: Int = 0,
    @SerialName("modified")
    val modified: String = "",
    @SerialName("name")
    val name: String = "",
    @SerialName("package")
    val packageName: String = "",
    @SerialName("size")
    val size: Int = 0,
    @SerialName("uname")
    val uname: String = "",
    @SerialName("updated")
    val updated: String = "",
    @SerialName("uptype")
    val uptype: String = "",
    @SerialName("urls")
    val urls: Urls = Urls(),
    @SerialName("media")
    val media: Media? = Media(),
    @SerialName("file")
    val file: AppDetailsFile? = AppDetailsFile()
)

@Serializable
data class Appcoins(
    @SerialName("advertising")
    val advertising: Boolean = false,
    @SerialName("billing")
    val billing: Boolean = false
)

@Serializable
data class Urls(
    @SerialName("m")
    val m: String? = "",
    @SerialName("w")
    val w: String? = ""
)

@Serializable
data class Malware(
    @SerialName("rank")
    val rank: String = ""
)

@Serializable
data class Prating(
    @SerialName("avg")
    val avg: Double = 0.0,
    @SerialName("total")
    val total: Int = 0
)

@Serializable
data class Rating(
    @SerialName("avg")
    val avg: Double = 0.0,
    @SerialName("total")
    val total: Int = 0
)

@Serializable
data class Appearance(
    @SerialName("description")
    val description: String = "",
    @SerialName("theme")
    val theme: String = ""
)

@kotlinx.serialization.Serializable
data class StatsX(
    @SerialName("apps")
    val apps: Int = 0,
    @SerialName("downloads")
    val downloads: Int = 0,
    @SerialName("subscribers")
    val subscribers: Int = 0
)

@Serializable
data class Time(
    @SerialName("human")
    val human: String = "",
    @SerialName("seconds")
    val seconds: Double = 0.0
)

@Serializable
data class Media(
    @SerialName("description")
    val description: String? = "",
    @SerialName("keywords")
    val keywords: List<String?>? = listOf(),
    @SerialName("news")
    val news: String? = "",
    @SerialName("screenshots")
    val screenshots: List<Screenshot?>? = listOf(),
    @SerialName("summary")
    val summary: String? = ""
)
