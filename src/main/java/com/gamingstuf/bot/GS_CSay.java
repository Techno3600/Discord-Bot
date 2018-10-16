import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GS_CSay extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		User auth = e.getAuthor();
		Guild g = e.getGuild();
		if (_m.isEmpty()) {
			_m = "__COMPLETED__";
		}
		if (content.startsWith("-csay")) {
			String _m = content.replaceAll("-csay", "");
			_m = _m.replaceAll("#", "");
			_m = _m.replaceAll("<", "");
			_m = _m.replaceAll(">", "");
			_m = _m.trim();
			if (e.getMember().hasPermission(Permission.MANAGE_CHANNEL)) {
				if (!(_m.equals("__COMPLETED__"))) {
					if (!(auth.isBot())) {
						g.getTextChannelById("469603739817345034").sendMessage("@everyone" + " " + _m).queue();
						channel.deleteMessageById(e.getMessageId()).complete();
						_m = "__COMPLETED__";
					}
				} else {
					channel.deleteMessageById(e.getMessageId()).complete();
					auth.openPrivateChannel().complete().sendMessage("Correct Usage: *-announce <message>*").queue();
				}
			} else if (!(e.getMember().hasPermission(Permission.MANAGE_CHANNEL))) {
				channel.deleteMessageById(e.getMessageId()).complete();
			}
		}
	}
}