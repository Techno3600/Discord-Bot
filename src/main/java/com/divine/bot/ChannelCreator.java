package com.divine.bot;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Category;
import net.dv8tion.jda.core.entities.Channel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ChannelCreator extends AdminCommand {
	private static Long c;
	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		
		//!create <channel-name> <CategoryID>
		//addPermissionOverride(e.getGuild().getRoleById(207553852147236864L), Arrays.asList(Permission.UNKNOWN), Arrays.asList(Permission.MESSAGE_WRITE)
		Category cID = e.getGuild().getCategoryById(Long.parseLong(args[2]));
		String channelName = args[1];
		cID.createTextChannel(channelName).queue(new Consumer<Channel>()
	    {
	        @Override
	        public void accept(Channel t)
	        {
	        	
	        	c = t.getIdLong();
	        }
	    });
		TextChannel f = e.getGuild().getTextChannelById(c);
		f.getManager().putPermissionOverride(e.getGuild().getRoleById(207553852147236864L), Arrays.asList(Permission.UNKNOWN), Arrays.asList(Permission.MESSAGE_WRITE)).complete();
		f.sendMessage("Created Channel.").queue();
		f.sendMessage("Channel will be opened in 10 seconds.").queue();
		f.getManager().sync().completeAfter(10, TimeUnit.SECONDS);
	}

	@Override
	public List<String> getAliases() { return Arrays.asList("!create"); }

	@Override
	public String getName() { return "Channel Create Command";}

	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }

}
