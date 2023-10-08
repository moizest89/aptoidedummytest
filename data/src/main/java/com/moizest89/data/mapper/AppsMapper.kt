package com.moizest89.data.mapper

import com.moizest89.data.model.AppInfo
import com.moizest89.data.model.Screenshot
import com.moizest89.domain.model.apps.AppItem
import com.moizest89.domain.model.apps.AppItemMedia
import com.moizest89.domain.model.apps.AppItemMediaScreenshot

fun AppInfo.toAppItem(): AppItem {
    val media = this.media?.let {
        AppItemMedia(
            description = it.description,
            keywords = it.keywords,
            news = it.news,
            screenshots = it.screenshots?.map { it.toAppItemScreenshot() },
            summary = it.summary
        )
    }

    return AppItem(
        added = this.added,
        graphic = this.graphic,
        has_versions = this.hasVersions,
        icon = this.icon,
        id = this.id,
        modified = this.modified,
        name = this.name,
        packageName = this.packageName,
        size = this.size,
        uname = this.uname,
        updated = this.updated,
        uptype = this.uptype,
        urls = listOf(this.urls.m, this.urls.w),
        versionCode = this.file?.vercode ?: 0,
        media = media
    )
}

fun Screenshot?.toAppItemScreenshot() = AppItemMediaScreenshot(
    height = this?.height ?: 0,
    url = this?.url ?: "",
    width = this?.width ?: 0
)
