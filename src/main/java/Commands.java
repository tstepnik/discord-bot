import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (args[0].equals(Bot.prefix + "info")) {
            EmbedBuilder info = new EmbedBuilder();
            info.setTitle("💩💩Bot information invo");
            info.setDescription("Completely useless information about a useless bot called Bot");

            info.setColor(0xf45642);
            info.setFooter("Created by Tomson13",event.getMember().getUser().getAvatarUrl());


            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage(info.build()).queue();
        }
    }
}
