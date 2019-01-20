package com.bot.main;

import java.util.Arrays;
import java.util.List;

import net.dv8tion.jda.core.Permission;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.requests.RestAction;

public class Test extends AdminCommand {

	@Override
	public void onCommand(MessageReceivedEvent e, String[] args) {
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return Arrays.asList("!test");
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "test";
	}

	@Override
	public Permission getPerm() {
		// TODO Auto-generated method stub
		return Permission.ADMINISTRATOR;
	}

}
