# MVVM Framework for Android

AKM (Android Kotlin MVVM) Framework provides utilities and pattern used to accelerate your app development workflow.

This framework make use of DataBinding, Kotlin-Extensions and Android Lifecycle Libraries.

## How the development flow works.

1. Create your XML layout first

```xml
<androidx.constraintlayout.widget.ConstraintLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    ...
```

2. Wrap your XML layout with the `<layout />` tag to enable ViewDataBinding to the layout

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">
    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
    ...
    </androidx.constraintlayout.widget.ConstraintLayout>
</layout>
```

3. Create your ViewModel and extends **AKMViewModel** or **AKMAndroidViewModel**

```kotlin
class MainViewModel : AKMViewModel() {
}
```

4. Bind the ViewModel into your XML layout with `<data />` and `<variable />` tags

```xml
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools">

    <data>
        <variable
            name="viewmodel"
            type="com.addeeandra.akm.template.MainViewModel" />
    </data>

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">
        ...

```

5. Then create your view class (Activity / Fragment / DialogFragment) extends :

    - **AKMActivity** for an Activity
    - **AKMFragment** for an Fragment
    - **AKMDialogFragment** for an DialogFragment
    
    For this example we create an Activity which extends the AKMActivity
    
```kotlin
class MainActivity : AKMActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
  ...
}
```

6. Override the viewModel properties

Depends on your pattern, you can instead using Dependency Injection to make the instance of ViewModel.

```kotlin
class MainActivity : AKMActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {
  override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
}
```



7. Implements the `HasViewModel` contract to pass the binding name of the `viewmodel` in XML

```kotlin
class MainActivity : AKMActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main), HasViewModel {
  override val brViewModelId: Int = BR.viewmodel
  override val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }
}
```

All done! The Model part within [M]VVM are at your own for now. The next steps are the usage of contracts.

---

## Contracts

In AKM Framework, the available contracts are :

#### HasViews

If you need any views to be pre-setup i.e. recyclerView adapter or else, you should implements the **HasViews** contract.

#### HasBindings

When have bindings other than the `viewmodel` variable, you should init those bindings by implementing this **HasBindings** contract.

#### HasObservers

To setup the observers of the `MainViewModel`, you should implements this **HasObservers** contract.

#### HasViewModel

If your View (the one who extends AKMActivity/AKMFragment/AKMDialogFragment) has a ViewModel, you should pass the generated binding ID by implementing this **HasViewModel** contract.

Note for the **HasViewModel**, you can instead call `AKM.init(BR.viewmodel)` in your Application.onCreate function to generally use the `BR.viewmodel` in all of your views.







