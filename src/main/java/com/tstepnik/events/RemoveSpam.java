package com.tstepnik.events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RemoveSpam extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String message = event.getMessage().getContentRaw();
        boolean containSpam = messageContains(message);

        if (containSpam) {
            event.getChannel().deleteMessageById(event.getMessageId()).queue();
            event.getChannel().sendMessage(" Wysyłanie linków do innych kanałów jest zabronione!!!").queue();
        }
    }

    private static boolean messageContains(String words) {
        String[] s = words.split(" ");
        for (String s1 : s) {
            if (s1.contains("https://discord")){
                return true;
            }
        }

        return false;
    }
}
