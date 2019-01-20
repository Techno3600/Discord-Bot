package com.mf.bot;

import java.util.Arrays;
import java.util.List;

import com.bot.functions.ArchiveCode;
import com.bot.functions.F;
import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Archive extends AdminCommand {
	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		if (args.length == 2)
		{
			TextChannel c = F.getT(e.getGuild(), args[1]);
			if (c == null)
			{
				e.getChannel().sendMessage(F.error("Archive Command", "!a(rchive) <#target-channel> - Archive a channel.", "<#target-channel> was not found.").build()).queue();
			} else
			{
				ArchiveCode.Archive(e.getGuild(), c, e.getGuild().getCategoryById(536041247056592906L));
			}
		} else
		{
			e.getChannel().sendMessage(F.error("Archive Command", "!a(rchive) <#target-channel> - Archive a channel.", "No arguments were entered.").build()).queue();
		}
	}


	@Override
	public List<String> getAliases() { return Arrays.asList("!a", "!archive"); }

	@Override
	public String getName() { return "Archive Command"; }

	@Override
	public Permission getPerm() { return Permission.MANAGE_SERVER; }


	
	

}