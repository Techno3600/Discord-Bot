package com.ci.bot;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CI_Verify extends ListenerAdapter {
	public static Map<Member, String> map = new HashMap<Member, String>();
	public static TextChannel targetChannel;
	public static Member targetMember;
	public void onMessageReceived(MessageReceivedEvent e)
	{
		if (e.getChannel().getIdLong() == 526618612727808001L)
		{
			if (e.getMessage().getContentRaw().startsWith("!verify"))
			{
				if (!(map.containsKey(e.getMember())))
				{
					targetChannel = e.getTextChannel();
					targetMember = e.getMember();
					genCap(e.getMember(), e.getTextChannel());
					e.getChannel().sendMessage(embed(e.getMember(), map.get(e.getMember())).build()).queue();
					Task task = new Task();
					task.start();
				} else
				{
					e.getChannel().sendMessage("You've already have a code, please wait for it to expire first.").queue();
				}
			} else
			{
				if (map.containsKey(e.getMember()))
				{
					if (e.getMessage().getContentRaw().equals(map.get(e.getMember())))
					{
						e.getChannel().sendMessage(e.getMember().getAsMention() + " has been verified.").queue();
						e.getGuild().getTextChannelById(514859393393885194L).sendMessage(e.getMember().getAsMention() + " has been verified.").queue();
						e.getGuild().getController().removeSingleRoleFromMember(e.getMember(), e.getGuild().getRoleById(526618293868691456L)).queue();
						e.getGuild().getController().addSingleRoleToMember(e.getMember(), e.getGuild().getRoleById(526615867555971091L)).queue();
					} else
					{
						e.getChannel().sendMessage(e.getMessage().getContentRaw()).queue();
					}
				}
			}
		}
	}
	private void genCap(Member member, TextChannel channel)
	{
		StringBuilder result = new StringBuilder().append("");
		for (int i = 0; i < 4; i++)
		{
			int rand = new Random().nextInt(10);
			result.append(rand);
		}
		map.put(member, result.toString());
		
	}
	
	private EmbedBuilder embed(Member member, String code)
	{
		EmbedBuilder f = new EmbedBuilder();
		f.setTitle("Community Integrity Requires Verification");
		f.setDescription(member.getAsMention() + ", please type this code into " +  member.getGuild().getTextChannelById(526618612727808001L).getAsMention() + " to get verified: `" + code + "`. You have 30 seconds.");
		f.setFooter("This is an automated verification message.", member.getGuild().getIconUrl());
		return f;
		
	}
}


class Task extends Thread {
	private Map<Member, String> map = CI_Verify.map;
	private Member member = CI_Verify.targetMember;
	private TextChannel channel = CI_Verify.targetChannel;
	
	@Override
	public void run() {
		try {
			Thread.sleep(30000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (map.containsKey(member))
		{
			map.remove(member);
			channel.sendMessage("DEBUG: Code expired. Removed from map").queue();
		} else
		{
			channel.sendMessage("DEBUG: Already verfiied. Cannot remove from map.").queue();
		}
		
	}
}



/*package com.ci.bot;

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
}*/