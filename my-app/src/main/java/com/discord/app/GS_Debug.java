import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class GS_Debug extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e) {
		Message message = e.getMessage();
		String content = message.getContentRaw();
		if (content.startsWith("-debug")) {
			//user.openPrivateChannel().complete().sendMessage("Hi").queue();
			System.out.println("Member:  " + e.getMember());
			System.out.println("Author:  " + e.getAuthor());
			System.out.println("Roles:  " + e.getMember().getRoles());
			System.out.println("DISCORD Roles:  " + e.getGuild().getRoles());
			System.out.println("Permissions:  " + e.getMember().getPermissions());
			System.out.println("Message ID:  " + e.getMessageId());
			System.out.println("Channels: " + e.getGuild().getTextChannels());
			System.out.println("Categories: " + e.getGuild().getCategories());
		}
	}
}