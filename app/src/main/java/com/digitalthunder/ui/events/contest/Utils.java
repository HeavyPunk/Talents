package com.digitalthunder.ui.events.contest;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Utils {
    public static ArrayList<Contest> getOlympiadeData(String type) throws IOException {
        final String addr = "https://olimpiada.ru/search?q=";
        ArrayList<Contest> contests = new ArrayList<Contest>();
        Document html;
        try
        {
            html = Jsoup.connect(addr + type).get();

            Elements table = html.getElementsByAttributeValueContaining("style", "vertical-align:top;");
            Elements classes = html.getElementsByClass("classes_dop");
            for (int tableNum = 0; tableNum < table.size(); tableNum++)
            {
                Contest contest = new Contest("", "", "", "Описание отсутствует", "");

                contest.classes = classes.get(tableNum).text();
                String description = table.get(tableNum).getElementsByClass("none_a black olimp_desc").first().text();
                String link = table.get(tableNum).getElementsByClass("none_a black olimp_desc").first().attributes().get("href");
                if(link != null)
                    contest.link = link;

                if(description != null && description != "")
                    contest.description = description;

                Elements titles = table.get(tableNum).getElementsByClass("headline");
                for (int titleNum = 0; titleNum < titles.size(); titleNum++)
                {
                    if(titles.get(titleNum).className().equals("headline")) {
                        contest.title = titles.get(titleNum).text();
                    }
                    else
                        contest.subTitle = titles.get(titleNum).text();
                }
                contests.add(new Contest(contest.classes, contest.title, contest.subTitle, contest.description, contest.link));
            }

        }
        catch (Exception e)
        {
            Log.d("Olympiades", "ERROR");
        }
        return contests;
    }
}