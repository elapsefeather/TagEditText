# TagEditText

[![](https://jitpack.io/v/elapsefeather/TagEditText.svg)](https://jitpack.io/#elapsefeather/TagEditText)   
tag 標記樣式、選單列表，可自訂 顯示介面、回傳資料處理格式 及 tag 色彩樣式

## sample

<img src="https://github.com/elapsefeather/TagEditText/blob/b0240c3949324cec3c65fac92afbaecfff11d74a/screenshots/TagEditText.gif" height="500">   <img src="https://github.com/elapsefeather/TagEditText/blob/4d370b92828f098940a622e5cbb7cc802ae0e808/screenshots/TagEditText3.gif" height="500">

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

## References

thank <a href="https://github.com/hearsilent/TagEditText">hearsilent/TagEditText</a>

## Version History

> ### v1.0.0(2022/10/18)
> - new project.

## License

Copyright 2022 YiTing

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
