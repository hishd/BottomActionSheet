# Bottom Action sheet

iOS style bottom action sheet for android, a simple gradle dependancy which enables to show a bottom action sheet on android projects.

### Screenshot
[![](https://github.com/hishd/BottomActionSheet/blob/master/images/screen.gif)](https://github.com/hishd/BottomActionSheet/blob/master/images/screen.gif  =100x20)

### Installation & Setup

------------

The easiest way to use Animdialog is to add the android library to your projects dependencies.

##### Gradle
Add the repository to your project build.gradle

```
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
add dependency,
```
dependencies {
	        implementation 'com.github.hishd:BottomActionSheet:1.0'
	}
```

## Usage

##### Important

Make sure you create an instance on the **ActionSheet** as below,

```
actionSheet = new ActionSheet();
```

The ActionSheet has three buttons and you can set the properties of the buttons using,

**Top Main button**

```
actionSheet.setMainTopAction(this, "Exit", ActionSheet.ActionType.DESTRUCTIVE, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        actionSheet.dismiss();
                    }
                });
```

**Bottom Main button**

```
actionSheet.setMainBottomAction(this, "Back", ActionSheet.ActionType.NORMAL, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        actionSheet.dismiss();
                    }
                });
```

**Bottom Default button**

```
actionSheet.setDefaultBottomAction(this, "Cancel", ActionSheet.ActionType.NORMAL, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        actionSheet.dismiss();
                    }
                });
```

#### Show bottom sheet
```
actionSheet.show(getSupportFragmentManager(),"ACTION_SHEET");
```

#### Dismiss bottom sheet
```
actionSheet.dismiss();
```

###### Please Refer the Sample project for more information.

