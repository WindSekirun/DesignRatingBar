## DesignRatingBar 
Custom filled drawable RatingBar in Android Application, written in Kotlin. 

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
    implementation ''
}
```

### Usages

#### XML
```XML
<pyxis.uzuki.live.desginratingbar.DesignRatingBar
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
