package com.mf.bot;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import com.bot.main.AdminCommand;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MF_Ole extends AdminCommand {
	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
		Role r = e.getGuild().getRoleById(538939904026083329L);
		if (e.getMember().getRoles().contains(r))
		{
			e.getGuild().getController().removeSingleRoleFromMember(e.getMember(), r).queue();
			e.getChannel().sendMessage("Removed `Ole Chat` from " + e.getMember().getAsMention()).queue(new Consumer<Message>() {

				@Override
				public void accept(Message t) {
					t.delete().queueAfter(5, TimeUnit.SECONDS);
					
				}
				
			});
		} else
		{
			e.getGuild().getController().addSingleRoleToMember(e.getMember(), r).queue();
			e.getChannel().sendMessage("Added `Ole Chat` to " + e.getMember().getAsMention()).queue(new Consumer<Message>() {

				@Override
				public void accept(Message t) {
					t.delete().queueAfter(5, TimeUnit.SECONDS);
					
				}
				
			});
		}
		
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return Arrays.asList("!o", "!ole");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Ole Command";
	}

	@Override
	public Permission getPerm() {
		// TODO Auto-generated method stub
		return Permission.MESSAGE_WRITE;
	}

}
