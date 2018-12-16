	package com.divine.bot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Join extends ListenerAdapter {
	private static String _r;
	private void code(Guild g, Member m, MessageChannel c)
	{
		g.getController().addSingleRoleToMember(m, g.getRoleById(308383726604386306L)).reason("Verification").complete();
		g.getController().removeSingleRoleFromMember(m, g.getRoleById(431630051105308692L)).reason("Verification").complete();
		c.sendMessage(m.getAsMention() + " has been verified!").queue();
		EmbedBuilder f = welcome(m);
		g.getTextChannelById(212634316969213952L).sendMessage(f.build()).queue();
		g.getTextChannelById(217420689336958976L).sendMessage(m.getAsMention() + " has been verified!").queue();
	}
	@Override
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getChannel().getId().equals("521373705230614586"))
		{
			if (e.getMessage().getContentRaw().startsWith("!verify")) { code(e.getGuild(), e.getMember(), e.getChannel()); }
			else if (e.getMessage().getContentRaw().startsWith("!verify")) { code(e.getGuild(), e.getMember(), e.getChannel()); }
		}
		
		if (e.getMessage().getContentRaw().startsWith("-welcomedebug"))
		{
			if (e.getMember().hasPermission(Permission.MANAGE_SERVER))
			{
				//-welcomedebug <member>
				String _m = e.getMessage().getContentRaw().replaceAll("-welcomedebug", "");
				serialize(_m);
				long l = Long.parseLong(_r);
				EmbedBuilder f = welcome(e.getGuild().getMemberById(l));
				e.getChannel().sendMessage(f.build()).queue();
			}
		}
	}
	private EmbedBuilder welcome( Member m)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setAuthor("A NEW USER HAS JOINED!");
		f.setColor(Color.CYAN);
		f.setDescription(m.getAsMention() + " (" + m.getUser().getName() + ") has joined **DivinePegasi's Hangout**! Welcome and we hope you have a fun time! \n" +
				" **Make sure to check <#498643430805602305>** and get some fancy roles at <#467019209965174814>! \n" +
				"Be sure to give " + m.getAsMention() + " a warm welcome!");
		f.setFooter("This was an automated action initiated by a player verifying themselves.", "https://cdn.discordapp.com/icons/207553852147236864/c2d53e9f467990658a8010dd2c8c0442.png");
		return f;
	}
	private String serialize(String _m) {
		_m = _m.replaceAll("!", "");
		_m = _m.replaceAll("@", "");
		_m = _m.replaceAll("<", "");
		_m = _m.replaceAll(">", "");
		return _r = _m.trim();
	}
}