import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class Bot {

    public static JDA jda;
    public static String prefix = "~";

    public static void main(String[] args) throws LoginException {
        jda = new JDABuilder(AccountType.BOT).setToken("NzA3NTQyMTc0NDA4OTAwNjQ5.XrKV2A.LfnssBSgGv7fY4rtpCSzhdGcB2k").build();
        jda.getPresence().setStatus(OnlineStatus.IDLE);
        jda.getPresence().setActivity(Activity.watching("His ex taking shower."));

        jda.addEventListener(new Commands());
    }
}
