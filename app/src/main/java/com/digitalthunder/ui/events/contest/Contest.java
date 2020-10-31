package com.digitalthunder.ui.events.contest;

public class Contest {
    public String classes;
    public String title;
    public String subTitle;
    public String description;
    public String link;

    public Contest(String classes, String title, String subTitle, String description, String link)
    {
        this.classes = classes;
        this.title = title;
        this.subTitle = subTitle;
        this.description = description;
        this.link = link;
    }
}