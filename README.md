# Aptoide API

This is a test project using the API from [https://es.aptoide.com/](https://es.aptoide.com/). The project includes the following screens:**

-   Splash
-   Main apps list
    -   Search for apps by name
-   App Details when the user selects an application from the list.

**Main apps list:** We obtain a default list using the endpoint
>  [https://ws75.aptoide.com/api/7/apps/search?query=telegram](https://ws75.aptoide.com/api/7/apps/search?query=telegram).

**Search for apps by name:** We perform a search for apps based on a specific app name using the endpoint
>[https://ws75.aptoide.com/api/7/apps/search?query={appName}](https://ws75.aptoide.com/api/7/apps/search?query=$%7BappName%7D).

**App details:** We retrieve detailed information about an application using the endpoint
>[https://ws75.aptoide.com/api/7/getApp?package_name={packagename}](https://ws75.aptoide.com/api/7/getApp?package_name=$%7Bpackagename%7D).

You can download the app from the following [link](https://github.com/moizest89/AptoideDummyTestApp/resources/app-debug.apk):

## Demo

![](https://github.com/moizest89/AptoideDummyTestApp/resources/apptoide_test.webm)



Thank you! 🚀