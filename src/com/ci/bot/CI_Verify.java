package com.ci.bot;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CI_Verify extends ListenerAdapter {
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getChannel().getIdLong() == 526618612727808001L)
		{
			if (e.getMessage().getContentRaw().startsWith("!verify"))
			{
				e.getGuild().getController().removeSingleRoleFromMember(e.getMember(), e.getGuild().getRoleById(526618293868691456L)).complete();
				e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById(526615867555971091L)).complete();
				e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById(461225653602222110L)).complete();
				e.getChannel().sendMessage(e.getMember().getAsMention() + " has been verified!").queue();
				e.getGuild().getTextChannelById(461226213143478272L).sendMessage(e.getMember().getAsMention() + " has been verified!").queue();
			}
		}
	}
}
