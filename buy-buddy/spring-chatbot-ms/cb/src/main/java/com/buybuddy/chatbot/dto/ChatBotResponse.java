package com.buybuddy.chatbot.dto;

public class ChatBotResponse {

	private String reply;

	public ChatBotResponse(String reply) {
		super();
		this.reply = reply;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public ChatBotResponse() {
		super();
	}

}
