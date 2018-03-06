## DesignRatingBar [![](https://jitpack.io/v/WindSekirun/DesignRatingBar.svg)](https://jitpack.io/#WindSekirun/DesignRatingBar)

[![Kotlin](https://img.shields.io/badge/kotlin-1.2.0-blue.svg)](http://kotlinlang.org)	[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

Custom filled drawable RatingBar in Android Application, written in Kotlin. 

<img src="https://github.com/WindSekirun/DesignRatingBar/blob/master/sample.png" width="202" height="360">

### Usages
*rootProject/build.gradle*
```	
allprojects {
    repositories {
	    maven { url 'https://jitpack.io' }
    }
}
```

*app/build.gradle*
```
dependencies {
    implementation 'com.github.WindSekirun:DesignRatingBar:1.1.0'
}
```

### Usages

#### XML
```XML
<pyxis.uzuki.live.designratingbar.DesignRatingBar
    android:id="@+id/ratingBar"
    android:layout_width="wrap_content"
    android:layout_height="15dp"
    android:isIndicator="true"
    android:rating="4.5"
    app:emptyIcon="@drawable/ico_star"
    app:filledIcon="@drawable/ico_star_on" />
```

### License 
```
Copyright 2017 WindSekirun (DongGil, Seo)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
