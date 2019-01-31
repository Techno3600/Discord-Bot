package com.mf.bot;

import java.awt.Color;

import com.bot.functions.F;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class MF_Verify extends ListenerAdapter {
	private void code(Guild g, Member m, MessageChannel c)
	{
		g.getController().addSingleRoleToMember(m, g.getRoleById(509174240293945345L)).reason("Verification").complete();
		g.getController().removeSingleRoleFromMember(m, g.getRoleById(509355672710676490L)).reason("Verification").complete();
		c.sendMessage(m.getAsMention() + " has been verified!").queue();
		g.getTextChannelById(509174186669899792L).sendMessage(welcome(m).build()).queue();
		g.getTextChannelById(509358039778721821L).sendMessage(m.getAsMention() + " has been verified!").queue();
	}
	@Override
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getChannel().getId().equals("509355971798368256"))
		{
			if (e.getMessage().getContentRaw().startsWith("!verify")) {
				code(e.getGuild(), e.getMember(), e.getChannel());
			}
		}
		
		if (e.getMessage().getContentRaw().startsWith("!welcomedebug"))
		{
			if (e.getMember().hasPermission(Permission.MANAGE_SERVER))
			{
				//-welcomedebug <member>
				String _m = e.getMessage().getContentRaw().replaceAll("!welcomedebug", "");
				EmbedBuilder f = welcome(F.getM(e.getGuild(), _m));
				e.getChannel().sendMessage(f.build()).queue();
			}
		}
	}
	private EmbedBuilder welcome(Member m)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("A NEW USER HAS JOINED!");
		f.setColor(Color.CYAN);
		f.setDescription(m.getAsMention() + " (" + m.getUser().getName() + ") has joined **Mineplex Forumers**! Welcome and we hope you have a fun time! \n" +
				" **Make sure to check <#509177563172700162>** and get some fancy roles at <#510659410461458443>! \n" +
				"Be sure to give " + m.getAsMention() + " a warm welcome!");
		f.setFooter("This was an automated action initiated by a player verifying themselves.", m.getGuild().getIconUrl());
		return f;
	}

}
