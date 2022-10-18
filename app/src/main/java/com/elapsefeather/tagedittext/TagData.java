package com.elapsefeather.tagedittext;

public class TagData implements TagInterface {
    public int id;
    public String name;

    public TagData(String name) {
        this.name = name;
        this.id = this.hashCode();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getTag() {
        return String.format("@{{%d}}", id);
    }

    @Override
    public String getLabel() {
        return String.format("@%s", name);
    }
}
