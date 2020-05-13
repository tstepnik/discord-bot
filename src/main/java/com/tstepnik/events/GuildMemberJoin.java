package com.tstepnik.events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Random;

public class GuildMemberJoin extends ListenerAdapter {

    List<String> messages = List.of(
            "[member] Jako nowy użytkownik musisz wysłać nudeska.",
            "Never gonna give [member] up. Never let [member] down!",
            "Hey! Listen! [member] has joined!");


    public void onGuildMemberJoin(GuildMemberJoinEvent event) {

        Random random = new Random();

        int number = random.nextInt(messages.size());

        EmbedBuilder join = new EmbedBuilder();
        join.setColor(0x66d8ff);
        join.setDescription(messages.get(number).replace("[member]",event.getMember().getAsMention()));

        event.getGuild().addRoleToMember(event.getMember(),event.getGuild().getRoleById(709137344867074170L)).complete();


    }
}