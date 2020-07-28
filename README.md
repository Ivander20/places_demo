# Demo Android app for places.

Google Android PlacesAutoComplete sdk is having problem with some search strings. When searched it is clearing the list of options and search text.

- Platform 

The problem is on Android 10 and above. Other Android versions seems working fine.

- Sdk setup

Implememted Android places autocomplete sdk activity as mentioned in docs.

https://developers.google.com/places/android-sdk/autocomplete#option_2_use_an_intent_to_launch_the_autocomplete_activity

- Keywords

```
Marina Bay
Bay s
```

- Steps

1. On Android device having Android 10 just launch search places activity and type any search string mentioned above.
2. Create Android 10 emulator and run search places activity, use emulator soft keyboard to search the location strings.

- Video

https://drive.google.com/file/d/1pXs61HdlGYy_CkRw57g7dxgFfhyAfjdY/view?usp=sharing
