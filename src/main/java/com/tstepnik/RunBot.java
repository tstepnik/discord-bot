package com.tstepnik;

import com.tstepnik.events.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.ReadyEvent;

import javax.security.auth.login.LoginException;
import java.util.EventListener;

public class RunBot implements EventListener {

    public static String prefix = "-";

    public static void main(String[] args) throws LoginException {
        JDA api = JDABuilder.createDefault("NzA3NTQyMTc0NDA4OTAwNjQ5.XrYgdw.Pi4klJnKz_LIgX8cfYMhAhhgbIQ").build();

        api.getPresence().setStatus(OnlineStatus.IDLE);
        api.getPresence().setActivity(Activity.watching("His ex taking shower."));
        api.addEventListener(new RemoveSpam());
        api.addEventListener(new GuildMemberJoin());
    }

    public void onEvent(GenericEvent event) {
        if (event instanceof ReadyEvent) {
            System.out.println("API is ready!");
        } else {
            System.out.println("there is some problem, API is not ready!");
        }
    }
}
