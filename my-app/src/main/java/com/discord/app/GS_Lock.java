import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GS_Lock extends ListenerAdapter {
	String _l = "UNLOCK";
	public void onMessageReceived(MessageReceivedEvent e) {
		MessageChannel channel = e.getChannel();
		Message message = e.getMessage();
		String content = message.getContentRaw();
		if (content.startsWith("-lock")) {
			channel.sendMessage("**CHANNEL LOCKED**").queue();
			_l = "LOCK";
			channel.deleteMessageById(e.getMessageId()).complete();
		} else if (content.startsWith("-unlock")) {
			_l = "UNLOCK";
			channel.sendMessage("**CHANNEL UNLOCKED**").queue();
			channel.deleteMessageById(e.getMessageId()).complete();
		}
	}
	public void Lock(MessageReceivedEvent _e) {
		if (_l == "LOCK") {
			_e.getChannel().deleteMessageById(_e.getMessageIdLong()).complete();
		}
	}
}