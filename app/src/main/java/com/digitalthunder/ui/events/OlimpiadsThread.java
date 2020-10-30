package com.digitalthunder.ui.events;

import java.io.IOException;

public class OlimpiadsThread implements Runnable {
    String subject;
    public OlimpiadsThread(String subject)
    {
        this.subject = subject;
    }
    @Override
    public void run() {
        try {
            EventsFragment.olimpiads = Utils.getOlympiadeData(this.subject);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}