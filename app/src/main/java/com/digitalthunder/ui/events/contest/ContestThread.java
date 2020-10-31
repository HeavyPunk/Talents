package com.digitalthunder.ui.events.contest;

import com.digitalthunder.ui.events.EventsFragment;

import java.io.IOException;

public class ContestThread implements Runnable {
    String subject;
    public ContestThread(String subject)
    {
        this.subject = subject;
    }
    @Override
    public void run() {
        try {
            ContestFragment.olimpiads = Utils.getOlympiadeData(this.subject);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}