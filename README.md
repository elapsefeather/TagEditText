# TagEditText

[![](https://jitpack.io/v/elapsefeather/TagEditText.svg)](https://jitpack.io/#elapsefeather/TagEditText)

## sample

<img src="https://github.com/elapsefeather/TagEditText/blob/b0240c3949324cec3c65fac92afbaecfff11d74a/screenshots/TagEditText.gif" height="500">  <img src="https://github.com/elapsefeather/TagEditText/blob/b0240c3949324cec3c65fac92afbaecfff11d74a/screenshots/TagEditText2.gif" height="500">

## Setup

The easiest way to add the **TagEditText** library to your project is by adding it as a dependency
to your build.gradle

**Step 1.** Add the JitPack repository to your build file

```gradle
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

**Step 2.** Add the dependency

```gradle
dependencies {
  implementation 'com.github.elapsefeather:TagEditText:1.0.0'
}
```

## Usage

### TagTextView

1. xml

```
    <com.elapsefeather.tagedittext.TagTextView
        android:id="@+id/tagText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

2. tagData need implements TagInterface and Set the display style and postback format

```

public class TagData implements TagInterface {

    @Override
    public String getTag() {
        return String.format("@{{%d}}", id);
    }

    @Override
    public String getLabel() {
        return String.format("@%s", name);
    }
}

```

3. tagText set up tagList and you can set tagColor(Not required).

```
        tagText.setTags(List<TagData>);
        tagText.setTagColor(Color);
```

### TagEditText

1. xml

```
    <com.elapsefeather.tagedittext.TagEditText
        android:id="@+id/tagEdit"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

2. tagData need implements TagInterface and Set the display style and postback format

```

public class TagData implements TagInterface {

    @Override
    public String getTag() {
        return String.format("@{{%d}}", id);
    }

    @Override
    public String getLabel() {
        return String.format("@%s", name);
    }
}

```

3. add tagAdapter need extends BaseTagAdapter(It's ArrayAdapter).
4. settings your selection view

```
public class TagAdapter extends BaseTagAdapter {

    public TagAdapter(@NonNull Context context, int resource, List<TagData> items) {
        super(context, resource, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return view;
    }
}
```

5. tagEdit set up tagList and tagAdapter.
6. you can set tagColor(Not required).

```
        tagEdit.setTags(List<TagData>);
        tagEdit.setTagColor(Color);
        tagEdit.setAdapter(new TagAdapter(this, R.layout.item_tag, tagList));
```

## Version History

> ### v1.0.0(2022/10/18)
> - new project.